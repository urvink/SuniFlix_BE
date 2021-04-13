package com.flix.suni.service;

import com.flix.suni.utils.Key;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = feignTmdbService, url = "https://api.themoviedb.org/3/")
public interface TmdbService {
		@GetMapping(value = "/discover/movie", params = "f885f7563a2d463bb18ed5f450c6c3d9")
		Di
}
