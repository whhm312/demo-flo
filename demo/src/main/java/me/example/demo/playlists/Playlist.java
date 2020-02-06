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
public class Playlist {
	private String title;
	private Integer playlistId;
	private String createdDate;
	private String creator;
	private Integer userId;

}
