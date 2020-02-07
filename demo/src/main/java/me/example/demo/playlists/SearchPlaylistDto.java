package me.example.demo.playlists;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
public class SearchPlaylistDto {
	@Min(1)
	Integer page;
	@Min(1)
	@Max(50)
	Integer per_page;
}
