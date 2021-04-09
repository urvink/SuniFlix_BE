package com.flix.suni.model;

import javax.persistence.*;

@Entity
@Table(name = "Icons")
public class Icons{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String name;
		private String imgSrc;

		public Icons() {
		}

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getImgSrc() {
				return imgSrc;
		}

		public void setImgSrc(String imgSrc) {
				this.imgSrc = imgSrc;
		}
}
