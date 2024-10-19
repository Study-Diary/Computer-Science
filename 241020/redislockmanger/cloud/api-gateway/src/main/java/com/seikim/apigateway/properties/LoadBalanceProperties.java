package com.seikim.apigateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "load-balance")
public class LoadBalanceProperties {
	private String auth;
	private String member;
}
