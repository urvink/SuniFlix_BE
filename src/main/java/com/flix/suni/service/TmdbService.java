package com.flix.suni.service;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Genre;
import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;

import java.util.Optional;

public interface TmdbService {
		//Discover
		public Optional<Discover> getDiscover();

		//Movie
		public  Optional<MovieDetails> getMovieDetail(Long id);

		//Genre
		public Genres<Genre> getGenreList();
}
