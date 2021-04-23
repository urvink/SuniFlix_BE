package com.flix.suni.service;

import com.flix.suni.model.Discover;
import com.flix.suni.model.MovieDetails;
import com.flix.suni.model.Trailer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "movieData", url = "${tmdb.base.api.uri}")
public interface TmdbFeignClient {
				//Discover
				@GetMapping(value = "/discover/movie", produces = "application/json")
				Discover getDiscover();

				//80s/ 90s/ 00s Movies
				@GetMapping(value = "discover/movie?release_date.gte={gte}&release_date.lte={lte}", produces = "application/json")
				Optional<Discover> getEraMovies(@PathVariable String gte, @PathVariable String lte );

				//With Companies
				@GetMapping("discover/movie?with_companies={id}")
				Optional<Discover> getWithCompaniesMovies(@RequestParam Integer id);

				//Movie detail
				@GetMapping(value = "/movie/{id}", produces = "application/json")
				Optional<MovieDetails> getMovieDetails(@PathVariable("id") Long id);

				//Videos/ Trailers
				@GetMapping(value = "/movie/{id}/videos", produces = "application/json")
				Trailer getVideos(@PathVariable Long id);

				//Genre
				@GetMapping(value = "/genre/movie/list", produces = "application/json")
				Optional<Object> getGenreList();

				//Similar Movies
				@GetMapping(value = "movie/{id}/similar", produces = "application/json")
				Optional<Object> getSimilarMovies(@PathVariable Integer id);

				/*
				//80s Movies
				@GetMapping("/discover/movie/")

				//90s Movies
				@GetMapping("/discover/movie/")

				//00s Movies
				@GetMapping("/discover/movie/")

				//Films van Disney tonen
				@GetMapping("/discover/movie/")

				//Films van bepaalde actrice/acteur tonen

				 */
		}