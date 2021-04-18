package com.flix.suni.controller.api;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Genre;
import com.flix.suni.model.Genres;
import com.flix.suni.model.MovieDetails;
import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieDiscoverController {

		private static final String apiKey = "f885f7563a2d463bb18ed5f450c6c3d9";

		@Autowired
		private TmdbFeignClient client;

		@GetMapping("discover/movie")
		public ResponseEntity<Optional<Discover>> discoverData(HttpServletRequest request){
				try{
						Optional<Discover> discover = Optional.ofNullable(client.getDiscover());
						return new ResponseEntity(discover.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		//Movie details
		@GetMapping("movie/{id}")
		public ResponseEntity<MovieDetails> getMovieDetails(@PathVariable Long id, HttpServletRequest request){
				try {
						Optional<MovieDetails> movieDetails =  client.getMovieDetails(id);
						return new ResponseEntity(movieDetails.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		//Genre List
		@GetMapping("genre/movie/list")
		public ResponseEntity<Genres<Genre>> getGenreList(HttpServletRequest request){

				try {
						Genres<Genre> genreList = client.getGenreList();
						return new ResponseEntity(genreList, HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}

		}
}
