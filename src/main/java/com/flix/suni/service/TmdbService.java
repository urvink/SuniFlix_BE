package com.flix.suni.service;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;
import com.flix.suni.utils.Key;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface TmdbService {
		//Discover
		public Discover getDiscover();

		//Movie
		public  Optional<MovieDetails> getMovieDetail(Long id);

		//Genre
		public List<Genres> getGenreList();
}
