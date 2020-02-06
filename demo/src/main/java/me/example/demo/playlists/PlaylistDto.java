package me.example.demo.playlists;

import javax.validation.constraints.NotEmpty;

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
public class PlaylistDto {
	@NotEmpty
	private String title;
}
