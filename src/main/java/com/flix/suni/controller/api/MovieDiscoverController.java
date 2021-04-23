package com.flix.suni.controller.api;

import com.flix.suni.model.Discover;
import com.flix.suni.model.Release_Date;
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

		//With Companies
		@GetMapping("discover/movie/companies/{id}")
		public ResponseEntity<Discover> getDiscoverWithCompanies(@PathVariable Integer id, HttpServletRequest request){

				try{
						Optional<Discover> withCompany = client.getWithCompaniesMovies(id);
						return new ResponseEntity(withCompany.get(), HttpStatus.OK);
				}catch(Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		//80s/90s/ 00s
		@GetMapping("discover/movie/{era}")
		public ResponseEntity<List<Discover>> getMovieEra(@PathVariable Integer era){
				Release_Date release_date = new Release_Date();

						switch (era){
								case 80:
										release_date.setGte("1980-01-01");
										release_date.setLte("1989-12-31");
										break;
								case 90:
										release_date.setGte("1990-01-01");
										release_date.setLte("1999-12-31");
										break;
								case 00:
										release_date.setGte("2000-01-01");
										release_date.setLte("2009-12-31");
										break;
								default:
										System.out.println("NOPE!! DEFAULT TRIGGERED!");
						}
				System.out.println("GTE is "+ release_date.getGte() +"\n LTE is "+release_date.getLte());

						Optional<Discover> movieData = client.getEraMovies(release_date.getGte(), release_date.getLte());
				System.out.println(movieData.get());
				try{
						return new ResponseEntity(movieData.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}


}
