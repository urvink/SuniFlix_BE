package com.flix.suni.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TmdbRequestInterceptor implements RequestInterceptor {

		@Value("${tmdb.api.key}")
		private String apiKey;
		private static final String AUTHORIZATION = "Authorization";

		@Override
		public void apply(RequestTemplate requestTemplate) {

//				requestTemplate.header(apiKey);
				requestTemplate.query("api_key", apiKey);
				requestTemplate.header("User-Agent",
								"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 " +
								"(KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		}
}
