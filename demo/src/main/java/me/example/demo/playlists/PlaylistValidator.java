package me.example.demo.playlists;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class PlaylistValidator {
	public void validate(SearchPlaylist searchPlaylist, Errors errors) {
		if (searchPlaylist.getPage() < 1) {
			errors.rejectValue("page", "wrongValue", "page의  최소 값은 1 입니다.");
		}

		if (searchPlaylist.getPerPage() < 1) {
			errors.rejectValue("perPage", "wrongValue", "perPage의  최소 값은 1 입니다.");
		}

		if (searchPlaylist.getPerPage() > 50) {
			errors.rejectValue("perPage", "wrongValue", "perPage의  최대 값은 50 입니다.");
		}
	}
}
