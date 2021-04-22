package com.flix.suni.controller.api;

import com.flix.suni.model.Discover;
import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MovieDiscoverController {

		@Autowired
		private TmdbFeignClient client;

		//Discover
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

		//80s
		@GetMapping("discover/movie/{era}")
		public ResponseEntity<List<Object>> getMovieEra(@PathVariable Integer era){
				LocalDate gte = null;
				LocalDate lte = null;

				try{

						switch (era){
								case 80:
										gte.getEra();
										lte.getEra();
										break;
								case 90:
										gte.getEra();
										lte.getEra();
										break;
								case 00:
										gte.getEra();
										lte.getEra();
										break;
								default:
										System.out.println("NOPE!! DEFAULT TRIGGERED!");
						}
						Optional<Object> movieData = client.get80sMovies(gte, lte);
						return new ResponseEntity(movieData, HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}


}
