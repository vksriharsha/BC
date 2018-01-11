package com.crypto.wservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.crypto.dto.CoinDto;
import com.google.gson.Gson;

public class CoinMarketWS {

	public CoinDto[] callCoinMarketWS(){
		
		 try {

				URL url = new URL("https://api.coinmarketcap.com/v1/ticker/?limit=1000");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				String coinOutput="";
				while ((output = br.readLine()) != null) {
					coinOutput += output;
				}
				
				
				conn.disconnect();
				
				Gson allCoinsJson = new Gson();
				CoinDto[] coins = allCoinsJson.fromJson(coinOutput,CoinDto[].class);
				
				
				return coins;

			  } catch (MalformedURLException e) {

				e.printStackTrace();
				return null;

			  } catch (IOException e) {

				e.printStackTrace();
				return null;

			  } 
		
	}
}
