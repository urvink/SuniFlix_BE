package com.flix.suni.repository;

import com.flix.suni.model.Icons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconsRepository extends JpaRepository<Icons, Long> {
}
