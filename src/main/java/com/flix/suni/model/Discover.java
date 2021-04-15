package com.flix.suni.model;


import java.util.List;

public class Discover {
		private Integer page;
		private List<MovieDetails> movieDetailsList;
		private Integer total_pages;
		private Integer total_results;

		public Integer getPage() {
				return page;
		}

		public void setPage(Integer page) {
				this.page = page;
		}

		public List<MovieDetails> getMovieDetailsList() {
				return movieDetailsList;
		}

		public void setMovieDetailsList(List<MovieDetails> movieDetailsList) {
				this.movieDetailsList = movieDetailsList;
		}

		public Integer getTotal_pages() {
				return total_pages;
		}

		public void setTotal_pages(Integer total_pages) {
				this.total_pages = total_pages;
		}

		public Integer getTotal_results() {
				return total_results;
		}

		public void setTotal_results(Integer total_results) {
				this.total_results = total_results;
		}
}