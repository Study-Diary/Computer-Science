package com.seikim.apigateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seikim.apigateway.properties.LoadBalanceProperties;
import com.seikim.apigateway.properties.ServiceRouteProperties;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class ApiRouteLocator {
	private final LoadBalanceProperties loadBalanceProperties;
	private final ServiceRouteProperties serviceRouteProperties;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				/* Auth Service */
				.route("auth-service", r -> r.path(serviceRouteProperties.getAuth() + "/**")
						.uri(loadBalanceProperties.getAuth()))
				.route("member-service", r -> r.path(serviceRouteProperties.getMember() + "/**")
						.uri(loadBalanceProperties.getMember()))
				.build();
	}
}
