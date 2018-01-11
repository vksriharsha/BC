import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.crypto.configread.Configurations;
import com.crypto.dao.CoinDao;
import com.crypto.dto.CoinDBDto;
import com.crypto.dto.CoinDto;
import com.crypto.wservices.CoinMarketWS;


public class Utilities {

	public ArrayList<CoinDto> getRequiredCoins(){

		//Call CoinMarket Web Service to get all coins
		System.out.println("Connecting to Coin Market WS...");
		CoinMarketWS cws = new CoinMarketWS();
		CoinDto[] allCoins = cws.callCoinMarketWS();

		
		
		//Get Binance Coins from Configuration
		System.out.println("Getting Binance Coin Config");
		Configurations cfg = new Configurations();
		ArrayList<String> allBinanceCoins = cfg.getBinanceCoins();

		
		//Filtering Required Coins
		ArrayList<CoinDto> requiredCoinsDtoList = new ArrayList<CoinDto>();

		System.out.println("Filtering Required Coins...");
		for(int i=0;i<allCoins.length;i++){
			for(int j=0;j<allBinanceCoins.size();j++){
				if(allCoins[i].equals(allBinanceCoins.get(j))){
					requiredCoinsDtoList.add(allCoins[i]);
					break;
				}
			}
		}

		return requiredCoinsDtoList;
		//System.out.println("Size of Required Coins :"+requiredCoinsDtoList.size());
	}
	
	
	 public Map<String, Double> sortByComparator(Map<String, Double> unsortMap, final boolean order)
	    {

	        List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(unsortMap.entrySet());

	        // Sorting the list based on values
	        Collections.sort(list, new Comparator<Entry<String, Double>>()
	        {
	            public int compare(Entry<String, Double> o1,
	                    Entry<String, Double> o2)
	            {
	                if (order)
	                {
	                    return o1.getValue().compareTo(o2.getValue());
	                }
	                else
	                {
	                    return o2.getValue().compareTo(o1.getValue());

	                }
	            }
	        });

	        // Maintaining insertion order with the help of LinkedList
	        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
	        for (Entry<String, Double> entry : list)
	        {
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }

	        return sortedMap;
	    }
	 
	 
	 public static void printMap(Map<String, Double> map)
	    {
	        for (Entry<String, Double> entry : map.entrySet())
	        {
	            System.out.println(entry.getKey() + "="+ entry.getValue());
	        }
	    }
	 
	 
	 public void updateOldValuesToDB(ArrayList<CoinDto> requiredCoinsDtoList,ArrayList<CoinDBDto> dbValuesOfCoins){
		 
		 CoinDao coinDao = new CoinDao();
		 for(int i=0;i<requiredCoinsDtoList.size();i++){
			 for(int j=0;j<dbValuesOfCoins.size();j++){
				 
				 if(requiredCoinsDtoList.get(i).equals(dbValuesOfCoins.get(j).getCoinId())){
					 String name = dbValuesOfCoins.get(j).getCoinId();
					 Double x1hoursback = Double.parseDouble(requiredCoinsDtoList.get(i).getPercent_change_1h());
					 Double x2hoursback = dbValuesOfCoins.get(j).getX1hoursback();
					 Double x3hoursback = dbValuesOfCoins.get(j).getX2hoursback();
					 Double x4hoursback = dbValuesOfCoins.get(j).getX3hoursback();
					 
					 
					 coinDao.updateCoin(new CoinDBDto(name, x4hoursback, x3hoursback, x2hoursback, x1hoursback));
					 
					 break;
				 }
			 }
		 }
		 
		 System.out.println("Coin data updated to DB");
	 }
}
