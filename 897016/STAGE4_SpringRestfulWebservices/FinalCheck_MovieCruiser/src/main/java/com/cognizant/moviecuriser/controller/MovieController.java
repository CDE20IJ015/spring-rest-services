package com.cognizant.moviecuriser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecuriser.MoviecuriserApplication;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.service.MovieService;
import com.cognizant.moviecuriser.service.exception.MovieNotFoundException;
//controller class for restful webservices
@RestController
//mapping with the url part
@RequestMapping("/movie-list")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecuriserApplication.class);
	//autowiring
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public List<Movie> getAllMovies() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return movieService.getMoviesListCustomer();
	}
	
	@PutMapping
	public void editMovie(@RequestBody Movie movie) {
		LOGGER.info("Start");
		if (movieService.save(movie)) {
			LOGGER.info("Updated Sucessfully");
		} else {
			LOGGER.info("Movie not updated");
		}
	}
	
	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable int id) {
		Movie movie = movieService.getByMovieId(id);
		LOGGER.info("{}",movie);
		return movie;
	}

}
