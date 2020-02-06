package me.example.demo.playlists;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.example.demo.albums.Album;
import me.example.demo.songs.Song;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaylistContent {
	private List<Song> songs;
	private List<Album> albums;
}
