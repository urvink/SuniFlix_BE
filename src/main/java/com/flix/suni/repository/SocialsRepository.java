package com.flix.suni.repository;

import com.flix.suni.model.Socials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialsRepository extends JpaRepository<Socials, Long> {
}
