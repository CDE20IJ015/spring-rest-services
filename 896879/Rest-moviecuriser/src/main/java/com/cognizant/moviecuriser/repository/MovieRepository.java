package com.cognizant.moviecuriser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecuriser.model.Movie;
/**
 * 
 * @author Danish
 *
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query("select m from Movie m where active=1 and dateOfLaunch<CURRENT_DATE")
	List<Movie> findCustomerMovies();
	
}
