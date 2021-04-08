package com.cognizant.moviecuriser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//table name favourites used for mapping 
@Table(name = "favourites")
public class Favourites {
	//for primary key 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fav_id")
	private int id;

	//many to one mapping using the column name 
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Movie movie;

	
	

	public Favourites() {
		super();
	}
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}