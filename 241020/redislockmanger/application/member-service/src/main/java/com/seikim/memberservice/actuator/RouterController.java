package com.seikim.memberservice.actuator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.seikim.memberservice.common.MemberRestController;

@MemberRestController
public class RouterController {

	@GetMapping("/v1/actuator/route")
	public ResponseEntity<String> routeCheck() {
		return ResponseEntity.ok("Route is OK");
	}
}
