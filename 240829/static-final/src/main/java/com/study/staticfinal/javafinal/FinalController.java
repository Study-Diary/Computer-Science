package com.study.staticfinal.javafinal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.staticfinal.data.MemberSignInRequest;
import com.study.staticfinal.data.MemberSignInResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/final")
@RestController
public class FinalController {
	private final FinalService finalService;

	@PostMapping("/member")
	public ResponseEntity<MemberSignInResponse> signIn(
			@RequestBody final MemberSignInRequest request
	) {
		MemberSignInResponse response = finalService.saveMember(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
