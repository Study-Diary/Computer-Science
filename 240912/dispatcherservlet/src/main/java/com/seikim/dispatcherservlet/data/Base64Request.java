package com.seikim.dispatcherservlet.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record  Base64Request(
		@JsonProperty("value") String value
) {
}
