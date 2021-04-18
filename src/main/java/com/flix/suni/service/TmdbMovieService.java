package com.flix.suni.service;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Genre;
import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TmdbMovieService implements TmdbService{
		//Discover
		@Override
		public Optional<Discover> getDiscover() {
				return null;
		}

		//Movie
		@Override
		public Optional<MovieDetails> getMovieDetail(Long id) {
				return null;
		}

		//Genre
		@Override
		public Genres<Genre> getGenreList() {
				return null;
		}
}

