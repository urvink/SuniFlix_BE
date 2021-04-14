package com.flix.suni.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TmdbRequestInterceptor implements RequestInterceptor {

		@Value("${tmdb.api.key}")
		private String apiKey;

		@Override
		public void apply(RequestTemplate requestTemplate) {
				requestTemplate.header(apiKey);
		}
}
