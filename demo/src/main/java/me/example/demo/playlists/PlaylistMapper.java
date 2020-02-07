package me.example.demo.playlists;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlaylistMapper {
	int insert(Playlist playlist);

	List<PlaylistResultDto> selectPlaylists(SearchPlaylist searchPlaylist);

	Playlist selectPlaylist(@Param("user_id") Integer userId, @Param("playlist_id") Integer playlistId);

	int deletePlaylist(@Param("user_id") Integer userId, @Param("playlist_id") Integer playlistId);

	int insertPlaylistContent(PlaylistContent playlistContent);
}
