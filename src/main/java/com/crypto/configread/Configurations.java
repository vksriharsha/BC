package com.crypto.configread;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Configurations {

	public ArrayList<String> getBinanceCoins(){
		Properties prop = new Properties();
		InputStream input = null;
		ArrayList<String> binanceCoins = new ArrayList<String>();
		try {

			//input = getClass().getClassLoader().getResourceAsStream(filename);
			input = new FileInputStream("config/coin.properties");
			prop.load(input);


			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);

				binanceCoins.add(value);

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return binanceCoins;
	}

	
	public static void main(String[] args) {
		Configurations c = new Configurations();
		System.out.println(c.getBinanceCoins());
	}
}



