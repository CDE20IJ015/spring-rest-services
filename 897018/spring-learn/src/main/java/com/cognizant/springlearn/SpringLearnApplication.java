package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();
		//displayCountries();
	}
	
	public static void displayDate() throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		//System.out.println(format.parse("31/12/2018"));
		Date date = format.parse("31/12/2018");
		
		LOGGER.info("START");
		LOGGER.debug(date.toString());
		LOGGER.info("END");
	}
	
	public static void displayCountry() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.info("START");
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}", anotherCountry);
		LOGGER.info("END");
	}
	
	public static void displayCountries() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");
		LOGGER.info("START");
		LOGGER.debug(countries.toString());
		LOGGER.info("END");
	}
}
