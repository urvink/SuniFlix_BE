package com.flix.suni.controller.api;

import com.flix.suni.model.Socials;
import com.flix.suni.service.SocialsService;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/socials")
public class SocialsController {
		@Autowired
		private SocialsService service;

		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Socials>> getAllsocials(HttpServletRequest request){
				List<Socials> socialsList;
				try {
						socialsList = service.findAllSocials();
						if (socialsList == null){
								return new ResponseEntity(StatusCodes.error400, HttpStatus.NO_CONTENT);
						}

				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity(socialsList, HttpStatus.OK);
		}

		@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Optional<Socials>> getSocial(@PathVariable Long id, HttpServletRequest request){
				Optional<Socials> social;
				try {
						social = service.findById(id);
						if ((social.get().getImgSrc() == null) || (social.get().getName() == null)){
								return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity(social.get(), HttpStatus.OK);
		}

		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteSocial(@PathVariable Long id, HttpServletRequest request){
				try {
						Optional<Socials> existsocial = service.findById(id);
						if(existsocial.get() != null){
								service.deleteById(id);
								return new ResponseEntity<>("Successfully removed resource", HttpStatus.OK);
						}else{
								return new ResponseEntity<>(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Socials> createNewSocial(@RequestBody Socials newSocialInfo, HttpServletRequest request){
				try{
						if ((newSocialInfo.getName() != null) && (newSocialInfo.getImgSrc() != null)){
								Socials newSocial = service.createNewSocials(newSocialInfo);
								return new ResponseEntity(newSocial, HttpStatus.OK);
						}else{
								return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Optional<Socials>> updateSocial(@PathVariable Long id, @RequestBody Socials updateInfo, HttpServletRequest request){
				try {
						if((updateInfo.getName()!=null) && (updateInfo.getImgSrc() != null)){
								Optional<Socials> existSocial = service.findById(id);
								existSocial.get().setImgSrc(updateInfo.getImgSrc());
								existSocial.get().setName(updateInfo.getName());
								Socials savedSocial = service.updateSocials(existSocial.get());
								return new ResponseEntity(savedSocial, HttpStatus.OK);
						}else{
								return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
