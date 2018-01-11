import java.util.ArrayList;
import java.util.HashMap;

import com.crypto.dto.CoinDBDto;
import com.crypto.dto.CoinDto;


public class CoreAlgorithm {

	public HashMap<String,Double> getBestCoin(ArrayList<CoinDto> currentValuesOfCoins, ArrayList<CoinDBDto> oldValuesOfCoins){

		HashMap<String,Double> coinRaking = new HashMap<>();
		for(int i=0;i<currentValuesOfCoins.size();i++){

			for(int j=0;j<oldValuesOfCoins.size();j++){

				if(currentValuesOfCoins.get(i).equals(oldValuesOfCoins.get(j).getCoinId())){
					String name = currentValuesOfCoins.get(i).getSymbol();
					Double currentPercent = Double.parseDouble(currentValuesOfCoins.get(i).getPercent_change_1h());
					Double hour1Percent = oldValuesOfCoins.get(j).getX1hoursback();
					Double hour2Percent = oldValuesOfCoins.get(j).getX2hoursback();
					Double hour3Percent = oldValuesOfCoins.get(j).getX3hoursback();
					Double hour4Percent = oldValuesOfCoins.get(j).getX4hoursback();
					
					Double dif1 = (currentPercent-hour1Percent)*4;
					Double dif2 = (hour1Percent-hour2Percent)*3;
					Double dif3 = (hour2Percent-hour3Percent)*2;
					Double dif4 = (hour3Percent-hour4Percent)*1;
					
					Double totalSum=dif1+dif2+dif3+dif4;
					coinRaking.put(name, totalSum);
				}
			}
		}
		
		
		return coinRaking;
	}
}
