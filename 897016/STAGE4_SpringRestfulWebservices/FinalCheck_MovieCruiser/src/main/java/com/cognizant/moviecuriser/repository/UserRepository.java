package com.cognizant.moviecuriser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecuriser.model.User;
//repository class
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
