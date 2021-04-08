package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
@ComponentScan("com")
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringLearnApplication.class, args);
		
		//displayDate();
		//displayCountry();
		displayCountries();
	}
	
	public static void displayDate() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
	
		LOGGER.info("START");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/12/2018");
		LOGGER.debug(date.toString());
		//System.out.println(format.parse("31/12/2018"));
		LOGGER.info("END");
		
	}
	
	public static void displayCountry() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.info("START");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("END");
	}
	
	public static void displayCountries() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.info("START");
		ArrayList<Country> country = (ArrayList<Country>) context.getBean("countryList");
		//Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("END");
	}

}
