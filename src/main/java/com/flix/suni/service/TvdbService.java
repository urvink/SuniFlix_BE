package com.flix.suni.service;

import com.flix.suni.utils.Key;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface TvdbService {


//		public List<Object> getMovies();
//		@GetMapping("https:/")
//		public List<Object> getGenres();

		@GetMapping("https://api.themoviedb.org/3/discover/movie")
		public List<Object> getDiscover();
}
