package com.cognizant.moviecuriser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull(message = "id can not be null")
	private int id;

	@Column(name = "title")
	@NotNull
	@Size(min = 1,max = 100,message = "title size must be between 1 to 100")
	private String title;

	@Column(name = "box_office")
	@NotNull(message = "box_office can not be null")
	private String boxOffice;

	@Column(name = "active")
	@NotNull
	private boolean active;

	@Column(name = "date_of_launch")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfLaunch;

	@Column(name = "genre")
	private String genre;

	@Column(name = "has_teaser")
	private boolean hasTeaser;

	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", hasTeaser=" + hasTeaser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
