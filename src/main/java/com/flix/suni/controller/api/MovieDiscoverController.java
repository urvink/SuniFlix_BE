package com.flix.suni.controller.api;

import com.flix.suni.model.*;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class MovieDiscoverController {

		@Autowired
		private TmdbFeignClient client;

		@GetMapping("discover/movie")
		public ResponseEntity<Optional<Discover>> discoverData(HttpServletRequest request){

				try{
						Optional<Object> discover = Optional.ofNullable(client.getDiscover());
						System.out.println(request);
						return new ResponseEntity(discover.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		//Movie details
		@GetMapping("movie/{id}")
		public ResponseEntity<MovieDetails> getMovieDetails(@PathVariable Long id, HttpServletRequest request){
				System.out.println(request);

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

		//Genre List
		@GetMapping("genre/movie/list")
		public ResponseEntity<List<Object>> getGenreList(HttpServletRequest request){
				System.out.println(request);
				List<Object> genreList = client.getGenreList();
				try {

						return new ResponseEntity(genreList, HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
