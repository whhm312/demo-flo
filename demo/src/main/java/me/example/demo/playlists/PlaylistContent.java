package me.example.demo.playlists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaylistContent {
	private Integer userId;
	private Integer playlistId;
	private Integer songId;
	private Integer albumId;

}
