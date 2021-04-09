package com.cognizant.moviecuriser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecuriser.MoviecuriserApplication;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.service.FavouriteService;
import com.cognizant.moviecuriser.service.exception.MovieNotFoundException;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecuriserApplication.class);
	
	@Autowired
	FavouriteService favouriteService;
	
	@PostMapping("/{userId}/{movieId}")
	public void addFaviorateMovie(@PathVariable int movieId, @PathVariable int userId) {
		LOGGER.info("Start");
		favouriteService.saveToFaviorate(movieId, userId);
		LOGGER.info("End");
		
	}
	
	@GetMapping("/{id}")
	public List<Movie> showFav(@PathVariable int id) throws MovieNotFoundException {

		LOGGER.info("Start");
		LOGGER.info("End");
		return favouriteService.getFaviorateMovies(id);
		
	}
	
	
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFromFaviorates(@PathVariable int movieId, @PathVariable int userId) {
		LOGGER.info("Start");
		favouriteService.deleteFaviorate(userId, movieId);
		LOGGER.info("End");
	}
}
