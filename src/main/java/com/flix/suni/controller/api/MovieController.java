package com.flix.suni.controller.api;

import com.flix.suni.model.MovieDetails;
import com.flix.suni.model.Trailer;
import com.flix.suni.model.Video;
import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api")
public class MovieController {
		@Autowired
		private TmdbFeignClient client;

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

		//Movie Trailers
		@GetMapping("movie/{id}/videos")
		public  ResponseEntity<List<Video>> getMovieTrailers(@PathVariable Long id, HttpServletRequest request){
				try{
						Trailer trailersList = client.getVideos(id);
						return new ResponseEntity(trailersList, HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		//Similar movies
		@GetMapping("movie/{id}/similar")
		public ResponseEntity<Optional<Object>> getSimilarMovies(@PathVariable Integer id, HttpServletRequest request){
				//Debug request
				try{
						Optional<Object> similarMovies = client.getSimilarMovies(id);
						return new ResponseEntity(similarMovies.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
