package com.flix.suni.service;

import com.flix.suni.model.Discover;

import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@FeignClient(name = "movieData", url = "${tmdb.base.api.uri}")
public interface TmdbFeignClient {
				//Discover
				@GetMapping(value = "/discover/movie", produces = "application/json")
				Discover getDiscover();

				//Movies
				@GetMapping(value = "/movie", produces = "application/json")
				Optional<MovieDetails> getMovieDetails(@PathVariable("id") Long id);

				//Genre
				@GetMapping(value = "/genre/movie/list", produces = "application/json")
				List<Genres> getGenreList();
		}
