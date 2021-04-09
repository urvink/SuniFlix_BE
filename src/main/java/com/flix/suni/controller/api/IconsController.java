package com.flix.suni.controller.api;

import com.flix.suni.model.Icons;
import com.flix.suni.service.IconsService;
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
@RequestMapping("api/icons")
public class IconsController {
		@Autowired
		private IconsService service;

		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Icons>> getAllIcons(HttpServletRequest request){
				try{
						List<Icons> iconsList = service.findAllIcons();
						if (iconsList != null){
								return new ResponseEntity(iconsList, HttpStatus.OK);
						}else{
								return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Icons> getIcon(@PathVariable Long id, HttpServletRequest request){
				try {
						Optional<Icons> icon = service.findById(id);
						if (icon != null){
								return new ResponseEntity(icon.get(), HttpStatus.OK);
						}else{
								return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}

		@DeleteMapping("{id}")
		public ResponseEntity deleteIcon(@PathVariable Long id, HttpServletRequest request){
				Optional<Icons> existIcon = service.findById(id);
				if(existIcon.get() != null){
						service.deleteById(id);
				}else{
						return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity("Deletion of the Icon was successful", HttpStatus.OK);
		}

		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity createNewIcon(@RequestBody Icons newIconInfo, HttpServletRequest request){
				Icons newIcon;
				try {
						if((newIconInfo.getImgSrc()!= null) && (newIconInfo.getName() != null)){
								newIcon = service.createNewIcon(newIconInfo);
						}else {
								return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}

				return new ResponseEntity(newIcon, HttpStatus.CREATED);
		}

		@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity updateIcon(@PathVariable Long id, @RequestBody Icons updatedIconInfo, HttpServletRequest request){
				try {
						if (request.getContentType().equals("application/json")){
								if ((updatedIconInfo.getName() != null) && (updatedIconInfo.getImgSrc() != null)){
										Optional<Icons> existIcon = service.findById(id);
										existIcon.get().setName(updatedIconInfo.getName());
										existIcon.get().setImgSrc(updatedIconInfo.getImgSrc());
										Icons savedIcon = service.updateIcon(existIcon.get());
										return new ResponseEntity(savedIcon, HttpStatus.OK);
								}else{
										return new ResponseEntity(StatusCodes.error400, HttpStatus.BAD_REQUEST);
								}
						}else{
								return new ResponseEntity("Please provide content-type: application/json",HttpStatus.NOT_ACCEPTABLE);
						}
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
