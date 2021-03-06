package me.example.demo.playlists;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@JsonPropertyOrder({ "playlist_id", "title", "thumbnail_url", "created_date" })
public class PlaylistsResult {
	private Integer playlistId;
	private String title;
	private String createdDate;

	public Integer getPlaylist_id() {
		return playlistId;
	}

	public String getTitle() {
		return title;
	}

	public String getCreated_date() {
		return createdDate;
	}

	public String getThumbnail_url() {
		return "http://xxxxx.xxx/xxxxxx";
	}
}
