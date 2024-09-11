package com.seikim.dispatcherservlet.controller;

import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seikim.dispatcherservlet.data.Base64Response;
import com.seikim.dispatcherservlet.data.StartTimeRequest;
import com.seikim.dispatcherservlet.utils.StartTimeRequestBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ServletController {

	private static final Base64.Encoder encoder = Base64.getEncoder();

	@GetMapping("/base")
	public ResponseEntity<Base64Response> base(@StartTimeRequestBody StartTimeRequest<String> request) {
		String encode = encoder.encodeToString(request.body().getBytes());
		log.info("{}", request);
		return ResponseEntity.ok(new Base64Response(encode));
	}
}
