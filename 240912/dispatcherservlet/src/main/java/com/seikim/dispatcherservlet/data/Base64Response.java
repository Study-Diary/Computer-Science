package com.seikim.dispatcherservlet.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Base64Response(
		@JsonProperty("value") String value
) {
}
