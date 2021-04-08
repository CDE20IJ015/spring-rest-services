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
//service class
@Service
public class FavouriteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecuriserApplication.class);
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FavouriteRepository faviorateRepository;
	
	@Transactional
	public boolean saveToFaviorate(int movieId,int userId)
	{
		
		LOGGER.info("Start");
		Favourites favorities = new Favourites();
		favorities.setMovie(movieRepository.getOne(movieId));
		favorities.setUser(userRepository.getOne(userId));
		LOGGER.info("End");
		if(faviorateRepository.save(favorities)==null)
			return false;
		return true;
	}
	
	@Transactional
	public List<Movie> getFaviorateMovies(int user_id) throws MovieNotFoundException {
		LOGGER.info("Start");
		List<Movie> movies = new ArrayList<>();
		faviorateRepository.getFaviorateMovies(user_id).stream().forEach(id -> movies.add(movieRepository.findById(id).get()));
		LOGGER.info("End");
		if(movies.isEmpty())
			throw new MovieNotFoundException();
		return movies;
	}
	
	@Transactional
	public void deleteFaviorate(int id,int movieId)
	{
		
		faviorateRepository.deleteFromFaviorate(id, movieId);
		
	}
}
