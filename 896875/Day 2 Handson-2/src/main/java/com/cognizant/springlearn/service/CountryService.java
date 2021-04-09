package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	private ArrayList<Country> countryList = new ArrayList<>(Arrays.asList(new Country("IN","India"),
			new Country("US","United States"),
			new Country("DE","Germany"),
			new Country("JP","Japan")));
	
	public Country getCountryIndia() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country countryIndia = (Country)context.getBean("in");
		return countryIndia;
	}
	
	public List<Country> getAllCountries() {
		return countryList;
	}
	
	public Country getCountry(String code) throws CountryNotFoundException {
		Country country = null;
		int found = 0;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList");
		for(Country ctr : countryList) {
			if(ctr.getCode().equals(code)) {
				country = ctr;
				found = 1;
			}
		}
		if(found == 0) {
			throw new CountryNotFoundException("Country with code "+code+" does not exist");
		}
		return country;
	}
	
	public void addCountry(Country country) {
		countryList.add(country);
	}
	
	public void updateCountry(String code, Country country) {
		for(int i=0;i<countryList.size();i++) {
			Country c = countryList.get(i);
			if(c.getCode().equals(code)) {
				countryList.set(i, country);
				return;
			}
		}
	}
	
	public void deleteCountry(String code) {
		for(int i=0;i<countryList.size();i++) {
			if(countryList.get(i).getCode().equals(code)) {
				countryList.remove(i);
				return;
			}
		}
	}
}
