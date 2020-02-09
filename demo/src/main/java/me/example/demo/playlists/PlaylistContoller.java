package me.example.demo.playlists;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public PlaylistContoller(PlaylistService playlistService, ModelMapper modelMapper) {
		this.playlistService = playlistService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("/playlists")
	public ResponseEntity<Object> createPlaylist(@RequestHeader(name = "user_id") Integer userId,
			@RequestBody @Valid PlaylistParams playlistParams, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors);
		}

		Playlist playlist = modelMapper.map(playlistParams, Playlist.class);
		playlist.setUserId(userId);

		boolean isSuccessed = playlistService.createPlaylist(playlist);
		if (isSuccessed) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/playlists/{playlist_id}")
	public ResponseEntity<Object> addContents(@RequestHeader(name = "user_id") Integer userId,
			@PathVariable("playlist_id") Integer playlistId,
			@RequestBody PlaylistContentsParams playlistContentsParams) {
		boolean isEmptyContent = playlistService.isEmptyContent(playlistContentsParams);
		boolean isNotOwner = playlistService.isNotOwner(userId, playlistId);
		if (isNotOwner || isEmptyContent) {
			return ResponseEntity.noContent().build();
		}

		modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
				.setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);
		PlaylistContents playlistContents = modelMapper.map(playlistContentsParams, PlaylistContents.class);
		playlistContents.setUserId(userId);
		playlistContents.setPlaylistId(playlistId);

		int addContentsCount = playlistService.addConents(playlistContents);
		if (addContentsCount > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/playlists")
	public ResponseEntity<Object> getPlaylists(@RequestHeader(name = "user_id") Integer userId) {
		List<PlaylistsResult> playlists = playlistService.getPlaylists(new SearchPlaylist(userId));
		return ResponseEntity.status(HttpStatus.OK).body(playlists);
	}

	@DeleteMapping("/playlists/{playlist_id}")
	public ResponseEntity<Object> removePlaylist(@RequestHeader(name = "user_id") Integer userId,
			@PathVariable("playlist_id") Integer playlistId) {
		boolean isNotOwner = playlistService.isNotOwner(userId, playlistId);
		if (isNotOwner) {
			return ResponseEntity.noContent().build();
		}

		int removedPlaylistCount = playlistService.removePlaylist(userId, playlistId);
		if (removedPlaylistCount > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
