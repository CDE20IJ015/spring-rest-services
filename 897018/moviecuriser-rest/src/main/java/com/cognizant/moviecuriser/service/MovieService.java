package com.cognizant.moviecuriser.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecuriser.MoviecuriserApplication;
import com.cognizant.moviecuriser.model.Favourites;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.repository.FavouriteRepository;
import com.cognizant.moviecuriser.repository.MovieRepository;
import com.cognizant.moviecuriser.repository.UserRepository;
import com.cognizant.moviecuriser.service.exception.MovieNotFoundException;

@Service
public class MovieService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecuriserApplication.class);
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Movie> getMoviesListCustomer() {
		
		LOGGER.info("Start");
		return movieRepository.findCustomerMovies();
	}

	public Movie getByMovieId(int id) {
		LOGGER.info("Start");
		return movieRepository.findById(id).get();
	}
	
	@Transactional
	public boolean save(Movie movie) {
		LOGGER.info("Start");
		if(movieRepository.save(movie)==null) {
			return false;
		}
		return true;
	}
	
}
