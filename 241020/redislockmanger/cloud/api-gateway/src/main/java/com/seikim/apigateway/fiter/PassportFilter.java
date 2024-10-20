package com.seikim.apigateway.fiter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import com.seikim.apigateway.config.FilterConfig;

public class PassportFilter extends AbstractGatewayFilterFactory<FilterConfig> {
	@Override
	public GatewayFilter apply(FilterConfig config) {
		
		return null;
	}
}
