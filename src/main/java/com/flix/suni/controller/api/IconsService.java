package com.flix.suni.service;

import com.flix.suni.model.Icons;
import com.flix.suni.repository.IconsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconsService {
		@Autowired
		private IconsRepository repo;

		public List<Icons> findAllIcons(){
				return repo.findAll();
		}

		public Optional<Icons> findById(Long id){
				return repo.findById(id);
		}

		public void deleteById(Long id){
				repo.deleteById(id);
		}

		public Icons createNewIcon(Icons newIcon){
				return repo.save(newIcon);
		}

		public Icons updateIcon(Icons updatedIconInfo){
				return repo.save(updatedIconInfo);
		}
}
