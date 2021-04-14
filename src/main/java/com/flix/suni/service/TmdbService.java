package com.flix.suni.service;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;

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
