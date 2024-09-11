package com.seikim.dispatcherservlet.utils;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seikim.dispatcherservlet.data.Base64Request;
import com.seikim.dispatcherservlet.data.StartTimeRequest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StartTimeArgumentResolver implements HandlerMethodArgumentResolver {
	private final ObjectMapper objectMapper;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		boolean hasParameterAnnotation = parameter.hasParameterAnnotation(StartTimeRequestBody.class);
		boolean assignableFrom = StartTimeRequest.class.isAssignableFrom(parameter.getParameterType());
		return hasParameterAnnotation && assignableFrom;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		Base64Request base64Request =
				objectMapper.readValue(Objects.requireNonNull(request).getInputStream(), Base64Request.class);
		return new StartTimeRequest<>(
				base64Request.value(),
				LocalDateTime.now()
		);
	}
}
