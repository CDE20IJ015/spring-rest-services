package com.cognizant.moviecuriser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecuriser.model.Favourites;


@Repository
public interface FavouriteRepository extends JpaRepository<Favourites, Integer>{

	@Query(nativeQuery = true, value = "select m.id from favourites f join movie m on f.id=m.id and f.user_id=:id")
	public List<Integer> getFaviorateMovies(@Param("id")Integer user_id);
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from favourites where user_id =:userId and id=:movieId limit 1")
	public Integer deleteFromFaviorate(@Param("userId")Integer userId,@Param("movieId")Integer movieId);
	
}
