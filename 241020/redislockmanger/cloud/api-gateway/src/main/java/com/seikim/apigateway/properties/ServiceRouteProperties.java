package com.seikim.apigateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "service-route")
public class ServiceRouteProperties {
	private String auth;
	private String member;
}