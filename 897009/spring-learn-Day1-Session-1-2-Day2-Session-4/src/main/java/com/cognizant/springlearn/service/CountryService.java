package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	private ArrayList<Country> countries = new ArrayList<>

	(Arrays.asList(new Country("IN", "India"), 
			new Country("US", "USA"),
			new Country("DE", "Germany"),
			new Country("JP", "Japan")));

	public Country getCountryIndia() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country countryIndia = (Country) context.getBean("in");
		return countryIndia;
	}

	public ArrayList<Country> getAllCountries() {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		//ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");
		return countries;
	}

	public Country getCountry(String code) throws CountryNotFoundException {
		Country country = null;
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		//ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");
		int flag = 0;
		for (Country ctr : countries) {
			if (ctr.getCode().equals(code)) {
				country = ctr;
				flag = 1;
			}
		}
		if (flag == 0) {
			throw new CountryNotFoundException("Country Not Found");
		}
		return country;

		// return
		// countries.stream().filter(t->t.getCode().equals(code)).findFirst().get();

	}
	
	public void addCountry(Country country) {
		countries.add(country);
	}
	
	public void updateCountry(Country country, String code) {
		for(int i=0;i<countries.size();i++)
		{
			Country c = countries.get(i);
			if(c.getCode().contentEquals(code))
			{
				countries.set(i, country);
				return;
			}
		}
	}
	
	public void deleteCountry(String code) {
		countries.removeIf(c->c.getCode().equalsIgnoreCase(code));
	}
}
