package me.example.demo.playlists;

import java.util.List;

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
public class PlaylistContents {
	private Integer userId;
	private Integer playlistId;
	private List<Integer> songIds;
	private List<Integer> albumIds;
}
