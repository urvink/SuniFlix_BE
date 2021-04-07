package com.flix.suni.controller;

import com.flix.suni.service.TvdbService;
import com.flix.suni.service.TvdbServiceProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableFeignClients(basePackageClasses = TvdbServiceProxy.class)
public class TvdbController implements TvdbService {

		private TvdbServiceProxy proxy;

		@Override
		public List<Object> getMovies() {
				return null;
		}

		@Override
		public List<Object> getGenres() {
				return null;
		}

		@Override
		public List<Object> getDiscover() {
				return null;
		}
}
