package com.flix.suni.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.flix.suni.model.Socials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class SocialsRepositoryTest {
		@Autowired
		private TestEntityManager entityManager;

		@Autowired
		private SocialsRepository repo;

		@Test
		public void testCreateTwitterSocials(){
				Socials twitterSocial = new Socials();

				twitterSocial.setName("Twitter");
				twitterSocial.setImgSrc("https://i.postimg.cc/bvy1bzqx/Twitter-icon-icons-com-66803.png");

				System.out.println();

				Socials savedTwitterSocial = (Socials) repo.save(twitterSocial);

				Socials existTwitterSocial = entityManager.find(Socials.class, savedTwitterSocial.getId());

				assertThat(twitterSocial.getId()).isEqualTo(existTwitterSocial.getId());
		}



}