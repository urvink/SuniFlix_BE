package com.flix.suni.service;

import com.flix.suni.model.Socials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialsService {
		@Autowired
		private SocialsRepository repo;

		public List<Socials> findAllSocials(){
				return repo.findAll();
		}

		public Optional<Socials> findById(Long id){
				return repo.findById(id);
		}

		public void deleteById(Long id){
				repo.deleteById(id);
		}

		public Socials createNewSocials(Socials newSocial){
				return repo.save(newSocial);
		}

		public Socials updateSocials(Socials updatedSocial){
				return repo.save(updatedSocial);
		}
}
