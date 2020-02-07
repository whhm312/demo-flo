package me.example.demo.playlists;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PlaylistService {
	PlaylistRepository playlistRepository;

	public PlaylistService(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	public boolean createPlaylist(Playlist playlist) {
		return playlistRepository.createPlaylist(playlist);
	}

	public int addConents(PlaylistContents playlistContents) {
		int result = 0;
		PlaylistContent playlistContent = null;
		Integer playlistId = playlistContents.getPlaylistId();
		Integer userId = playlistContents.getUserId();

		List<Integer> songIds = playlistContents.getSongIds();
		for (Integer songId : songIds) {
			playlistContent = new PlaylistContent();
			playlistContent.setUserId(userId);
			playlistContent.setPlaylistId(playlistId);
			playlistContent.setSongId(songId);
			result += playlistRepository.addConent(playlistContent);
		}

		List<Integer> albumIds = playlistContents.getAlbumIds();
		for (Integer albumId : albumIds) {
			playlistContent = new PlaylistContent();
			playlistContent.setUserId(userId);
			playlistContent.setPlaylistId(playlistId);
			playlistContent.setAlbumId(albumId);
			result += playlistRepository.addConent(playlistContent);
		}

		return result;
	}

	public List<PlaylistResultDto> getPlaylists(SearchPlaylist searchPlaylist) {
		return playlistRepository.getPlaylists(searchPlaylist);
	}

	public int removePlaylist(Integer userId, Integer playlistId) {
		return playlistRepository.removePlaylist(userId, playlistId);
	}

	public boolean isNotOwner(Integer userId, Integer playlistId) {
		return !isOwner(userId, playlistId);
	}

	public boolean isOwner(Integer userId, Integer playlistId) {
		Playlist playlist = playlistRepository.getPlaylist(userId, playlistId);
		return playlist != null && !StringUtils.isEmpty(playlist.getTitle());
	}
}
