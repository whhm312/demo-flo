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

	public int addConent(PlaylistContent playlistContent) {
		return playlistMapper.insertPlaylistContent(playlistContent);
	}

	public List<PlaylistsResult> getPlaylists(SearchPlaylist searchPlaylist) {
		return playlistMapper.selectPlaylists(searchPlaylist);
	}

	public int removePlaylist(Integer userId, Integer playlistId) {
		return playlistMapper.deletePlaylist(userId, playlistId);
	}

	public int removePlaylistContents(Integer playlistId) {
		return playlistMapper.deletePlaylistContents(playlistId);
	}

	public Playlist getPlaylist(Integer userId, Integer playlistId) {
		return playlistMapper.selectPlaylist(userId, playlistId);
	}
}
