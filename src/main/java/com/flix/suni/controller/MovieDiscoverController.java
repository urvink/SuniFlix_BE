package com.flix.suni.controller;

import com.flix.suni.model.Discover;
import com.flix.suni.service.DiscoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flix.suni.utils.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/discover")
public class MovieDiscoverController {
		@Autowired
		private TmdbService service;

		@GetMapping
		public ResponseEntity<Discover> discoverData(HttpServletRequest request){
				try{

				}catch (Exception e){
						return new ResponseEntity();
				}
		}

}
