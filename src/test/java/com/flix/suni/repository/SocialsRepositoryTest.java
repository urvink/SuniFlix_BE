package com.flix.suni.repository;

import com.flix.suni.model.Icons;
import com.flix.suni.model.Socials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SocialsRepositoryTest {
		@Autowired
		private TestEntityManager entityManager;

		@Autowired
		private SocialsRepository repo;

		@Autowired
		private IconsRepository iconsRepo;

		@Test
		public void testCreateTwitterSocials(){
				Socials twitterSocial = new Socials();
				Socials twitterWhiteSocial = new Socials();

				//Regular Twitter
				twitterSocial.setName("Twitter");
				twitterSocial.setImgSrc("https://i.postimg.cc/bvy1bzqx/Twitter-icon-icons-com-66803.png");

				//White Twitter
				twitterWhiteSocial.setName("White Twitter");
				twitterWhiteSocial.setImgSrc("https://i.postimg.cc/tg4JWDdD/Copy-of-twitter-icon-white-png-23.png");

				Socials savedTwitterSocial = (Socials) repo.save(twitterSocial);
				System.out.println(savedTwitterSocial.getImgSrc());

				Socials savedTwitterWhiteSocial = (Socials) repo.save(twitterWhiteSocial);
				System.out.println(savedTwitterWhiteSocial.getImgSrc());

				Socials existTwitterSocial = entityManager.find(Socials.class, savedTwitterSocial.getId());

				Socials existTwitterWhiteSocial = entityManager.find(Socials.class, savedTwitterWhiteSocial.getId());

				assertThat(twitterSocial.getId()).isEqualTo(existTwitterSocial.getId());

				assertThat(twitterWhiteSocial.getId()).isEqualTo(existTwitterWhiteSocial.getId());
		}

		@Test
		public void testCreateFacebook(){
				Socials fbSocial = new Socials();
				Socials fbWhiteSocial = new Socials();

				//Regular FB Logo
				fbSocial.setName("Facebook");
				fbSocial.setImgSrc("https://i.postimg.cc/TPM4X5qR/Facebook-icon-icons-com-66805.png");

				//White FB Logo
				fbWhiteSocial.setName("White Facebook");
				fbWhiteSocial.setImgSrc("https://i.postimg.cc/Lsph52hd/Copy-of-Facebookwhiteicon.png");

				Socials savedFacebookSocial = (Socials) repo.save(fbSocial);
				Socials savedFacebookWhiteSocial = (Socials) repo.save(fbWhiteSocial);

				Socials existFacebookSocial = entityManager.find(Socials.class, savedFacebookSocial.getId());
				Socials existFacebookWhiteSocial = entityManager.find(Socials.class, savedFacebookWhiteSocial.getId());

				assertThat(fbSocial.getId()).isEqualTo(existFacebookSocial.getId());
				assertThat(fbWhiteSocial.getId()).isEqualTo(existFacebookWhiteSocial.getId());
		}

		@Test
		public void testCreateInstagram(){
				Socials igSocial = new Socials();
				Socials igWhiteSocial = new Socials();

				igSocial.setName("Instagram");
				igSocial.setImgSrc("https://i.postimg.cc/mDhMX8zh/Instagram-icon-icons-com-66804.png");

				igWhiteSocial.setName("White Instagram");
				igWhiteSocial.setImgSrc("https://i.postimg.cc/Wb0dvdbm/Copy-of-Instawhiteicon.png");

				Socials savedInstagramSocial = (Socials) repo.save(igSocial);
				Socials savedInstagramWhiteSocial = (Socials) repo.save(igWhiteSocial);

				Socials existInstagramSocial = entityManager.find(Socials.class, savedInstagramSocial.getId());
				Socials existInstagramWhiteSocial = entityManager.find(Socials.class, savedInstagramWhiteSocial.getId());

				assertThat(igSocial.getId()).isEqualTo(existInstagramSocial.getId());
				assertThat(igWhiteSocial.getId()).isEqualTo(existInstagramWhiteSocial.getId());
		}

		@Test
		public void testCreateYoutube(){

				Icons ytIcon = new Icons();
				Icons maxSoundIcon = new Icons();
				Icons muteSoundIcon = new Icons();

				ytIcon.setName("YouTube");
				ytIcon.setImgSrc("https://i.postimg.cc/X7YPMCgm/Pngtree-youtube-white-icon-3570413.png");

				maxSoundIcon.setName("Maximum Sound Volume");
				maxSoundIcon.setImgSrc("https://i.postimg.cc/MKKfY7Xg/3643734-high-sound-speaker-voice-volume-113403.png");

				muteSoundIcon.setName("Muted Sound");
				muteSoundIcon.setImgSrc("https://i.postimg.cc/nhXsyn4k/3643732-mute-sound-speaker-voice-volume-113439.png");

				Icons savedYouTubeIcon = iconsRepo.save(ytIcon);
				Icons savedMaxSoundIcon = iconsRepo.save(maxSoundIcon);
				Icons savedMuteSoundIcon = iconsRepo.save(muteSoundIcon);

				Icons existYouTubeIcon = entityManager.find(Icons.class, savedYouTubeIcon.getId());
				Icons existMaxSoundIcon = entityManager.find(Icons.class, savedMaxSoundIcon.getId());
				Icons existMuteSoundIcon = entityManager.find(Icons.class, savedMuteSoundIcon.getId());

				assertThat(ytIcon.getId()).isEqualTo(existYouTubeIcon.getId());
				assertThat(maxSoundIcon.getId()).isEqualTo(existMaxSoundIcon.getId());
				assertThat(muteSoundIcon.getId()).isEqualTo(existMuteSoundIcon.getId());
		}
}