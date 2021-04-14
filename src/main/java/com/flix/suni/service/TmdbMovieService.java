package com.flix.suni.service;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TmdbMovieService implements TmdbService{
		//Discover
		@Override
		public Discover getDiscover() {
				return null;
		}

		//Movie
		@Override
		public Optional<MovieDetails> getMovieDetail(Long id) {
				return null;
		}

		//Genre
		@Override
		public List<Genres> getGenreList() {
				return null;
		}
}

