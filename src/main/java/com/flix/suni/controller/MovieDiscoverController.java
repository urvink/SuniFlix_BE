package com.flix.suni.controller;

import com.flix.suni.model.Discover;
import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.service.TmdbMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flix.suni.utils.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/discover/movie")
public class MovieDiscoverController {

		@Autowired
		private TmdbFeignClient client;

		@GetMapping(value = "{id}")
		public ResponseEntity<Discover> discoverData(HttpServletRequest request){
				try{
						Discover discover = client.getDiscover();
						return new ResponseEntity<>(discover, HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

}
