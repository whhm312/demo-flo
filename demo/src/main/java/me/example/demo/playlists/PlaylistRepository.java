package me.example.demo.playlists;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PlaylistRepository {

	private PlaylistMapper playlistMapper;

	public PlaylistRepository(PlaylistMapper playlistMapper) {
		this.playlistMapper = playlistMapper;
	}

	public boolean createPlaylist(Playlist playlist) {
		return playlistMapper.insert(playlist) > 0;
	}

	public List<PlaylistResultDto> getPlaylists(SearchPlaylist searchPlaylist) {
		return playlistMapper.selectPlaylists(searchPlaylist);
	}

	public Playlist getPlaylist(Integer userId, Integer playlistId) {
		return playlistMapper.selectPlaylist(userId, playlistId);
	}

	public int removePlaylist(Integer userId, Integer playlistId) {
		return playlistMapper.deletePlaylist(userId, playlistId);
	}

}
