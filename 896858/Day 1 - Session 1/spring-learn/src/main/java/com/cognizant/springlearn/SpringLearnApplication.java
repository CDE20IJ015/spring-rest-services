package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Program to read configuration file and display the details
@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start");

		SpringApplication.run(SpringLearnApplication.class, args);

		displayDate();
		
		//Invoke displayCountry() method
		displayCountry();
		
		displayCountries();
		
		LOGGER.info("End");
	}

//	Method will read the dateFormat bean from spring configuration file and display the date
	private static void displayDate() {
		LOGGER.info("Start");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat simpleDateFormat = applicationContext.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = simpleDateFormat.parse("31/12/2018");
			System.out.println("\n" + date + "\n");
			LOGGER.debug("Date : {}", date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("End");
	}

//	Method will read the country bean from spring configuration file and display the country
	private static void displayCountry() {
		LOGGER.info("Start");
		
//		Demonstration of Singleton Scope
//		The constructor will be called only once, which means that only one instance of Country bean is created
		LOGGER.debug("Singleton");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
		
		Country country = applicationContext.getBean("country", Country.class);
		Country country2 = applicationContext.getBean("country", Country.class);
		
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}", country2);
		
//		Demonstration of Prototype Scope
//		Constructor will be called twice, which means that two instances of country is created.
		LOGGER.debug("Prototype");
		Country anotherCountry = applicationContext.getBean("anotherCountry", Country.class);
		Country anotherCountry2 = applicationContext.getBean("anotherCountry", Country.class);
		
		LOGGER.debug("Country : {}", anotherCountry);
		LOGGER.debug("Country : {}", anotherCountry2);
		
		
		LOGGER.info("End");
	}
	
//	Method will read the country list from spring configuration file and display the list of countries as debug log
	private static void displayCountries() {
		LOGGER.info("Start");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countries = applicationContext.getBean("countryList", ArrayList.class);
		LOGGER.debug("Countries: {}", countries);
		
		LOGGER.info("End");
	}

}
