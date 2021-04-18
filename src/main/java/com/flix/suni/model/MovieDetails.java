package com.flix.suni.model;

import java.util.List;

public class MovieDetails {

		private Boolean adult;
		private String backdrop_path;
		private List<Integer> genre_ids;
		private Long id;
		private String original_language;
		private String original_title;
		private String overview;
		private String popularity;
		private String poster_path;
		private String release_date;
		private String title;
		private String video;
		private String vote_average;
		private String vote_count;

		public Boolean getAdult() {
				return adult;
		}

		public void setAdult(Boolean adult) {
				this.adult = adult;
		}

		public String getBackdrop_path() {
				return backdrop_path;
		}

		public void setBackdrop_path(String backdrop_path) {
				this.backdrop_path = backdrop_path;
		}

		public List<Integer> getGenre_ids() {
				return genre_ids;
		}

		public void setGenre_ids(List<Integer> genre_ids) {
				this.genre_ids = genre_ids;
		}

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getOriginal_language() {
				return original_language;
		}

		public void setOriginal_language(String original_language) {
				this.original_language = original_language;
		}

		public String getOriginal_title() {
				return original_title;
		}

		public void setOriginal_title(String original_title) {
				this.original_title = original_title;
		}

		public String getOverview() {
				return overview;
		}

		public void setOverview(String overview) {
				this.overview = overview;
		}

		public String getPopularity() {
				return popularity;
		}

		public void setPopularity(String popularity) {
				this.popularity = popularity;
		}

		public String getPoster_path() {
				return poster_path;
		}

		public void setPoster_path(String poster_path) {
				this.poster_path = poster_path;
		}

		public String getRelease_date() {
				return release_date;
		}

		public void setRelease_date(String release_date) {
				this.release_date = release_date;
		}

		public String getTitle() {
				return title;
		}

		public void setTitle(String title) {
				this.title = title;
		}

		public String getVideo() {
				return video;
		}

		public void setVideo(String video) {
				this.video = video;
		}

		public String getVote_average() {
				return vote_average;
		}

		public void setVote_average(String vote_average) {
				this.vote_average = vote_average;
		}

		public String getVote_count() {
				return vote_count;
		}

		public void setVote_count(String vote_count) {
				this.vote_count = vote_count;
		}
}
