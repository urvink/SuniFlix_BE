package com.flix.suni.controller.api;

import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class MovieGenreController {
		@Autowired
		private TmdbFeignClient client;

		//Genre List
		@GetMapping("genre/movie/list")
		public ResponseEntity<Optional<Object>> getGenreList(HttpServletRequest request){
				System.out.println(request);
				Optional<Object> genreList = client.getGenreList();
				try {
						return new ResponseEntity(genreList.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
