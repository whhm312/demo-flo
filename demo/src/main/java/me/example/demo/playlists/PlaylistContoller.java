package me.example.demo.playlists;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistContoller {
	PlaylistService playlistService;
	ModelMapper modelMapper;
	PlaylistValidator playlistValidator;

	public PlaylistContoller(PlaylistService playlistService, ModelMapper modelMapper,
			PlaylistValidator playlistValidator) {
		this.playlistService = playlistService;
		this.modelMapper = modelMapper;
		this.playlistValidator = playlistValidator;
	}

	@PostMapping("/api/playlists")
	public ResponseEntity<Object> createPlaylist(@RequestHeader(name = "user_id") Integer userId,
			@RequestBody @Valid PlaylistDto playlistDto, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors);
		}

		Playlist playlist = modelMapper.map(playlistDto, Playlist.class);
		playlist.setUserId(StringUtils.isEmpty(userId) ? 1 : userId);

		boolean isSuccessed = playlistService.createPlaylist(playlist);
		if (isSuccessed) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/api/playlists/{playlist_id}")
	public ResponseEntity<Object> addContents(@RequestHeader(name = "user_id") Integer userId,
			@PathVariable("playlist_id") Integer playlistId, @RequestBody PlaylistContentsDto playlistContentsDto) {
		boolean isNotOwner = playlistService.isNotOwner(userId, playlistId);
		if (isNotOwner) {
			return ResponseEntity.notFound().build();
		}

		modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
				.setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);
		PlaylistContents playlistContents = modelMapper.map(playlistContentsDto, PlaylistContents.class);
		playlistContents.setUserId(userId);
		playlistContents.setPlaylistId(playlistId);

		int addContentsCount = playlistService.addConents(playlistContents);
		if (addContentsCount > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/api/playlists")
	public ResponseEntity<Object> getPlaylists(@RequestHeader(name = "user_id") Integer userId,
			@PathParam("1") Integer page, @PathParam("50") Integer per_page) {

		SearchPlaylist searchPlaylist = new SearchPlaylist(userId, page, per_page);
		// TODO validate
//		playlistValidator.validate(searchPlaylist, errors);
//		if (errors.hasErrors()) {
//			return ResponseEntity.badRequest().body(errors);
//		}

		List<PlaylistResultDto> playlists = playlistService.getPlaylists(searchPlaylist);
		return ResponseEntity.status(HttpStatus.OK).body(playlists);
	}

	@DeleteMapping("/api/playlists/{playlist_id}")
	public ResponseEntity<Object> removePlaylist(@RequestHeader(name = "user_id") Integer userId,
			@PathVariable("playlist_id") Integer playlistId) {

		boolean isNotOwner = playlistService.isNotOwner(userId, playlistId);
		if (isNotOwner) {
			return ResponseEntity.notFound().build();
		}

		int removedPlaylistCount = playlistService.removePlaylist(userId, playlistId);
		if (removedPlaylistCount > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
