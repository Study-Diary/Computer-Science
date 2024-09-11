package com.seikim.dispatcherservlet.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seikim.dispatcherservlet.utils.StartTimeArgumentResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * {@link org.springframework.web.servlet.DispatcherServlet}의 {@link List}<{@link org.springframework.web.servlet.HandlerAdapter}> handlerAdapter에 추가됩니다.
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new StartTimeArgumentResolver(new ObjectMapper()));
	}
}
