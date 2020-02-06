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

	public List<PlaylistResultDto> getPlaylists(SearchPlaylist searchPlaylist) {
		return playlistRepository.getPlaylists(searchPlaylist);
	}

	public boolean isNotOwner(Integer userId, Integer playlistId) {
		return !isOwner(userId, playlistId);
	}

	public boolean isOwner(Integer userId, Integer playlistId) {
		Playlist playlist = playlistRepository.getPlaylist(userId, playlistId);
		return playlist != null && !StringUtils.isEmpty(playlist.getTitle());
	}

	public int removePlaylist(Integer userId, Integer playlistId) {
		return playlistRepository.removePlaylist(userId, playlistId);
	}
}
