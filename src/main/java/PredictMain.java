import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.crypto.configread.Configurations;
import com.crypto.dao.CoinDao;
import com.crypto.dto.CoinDBDto;
import com.crypto.dto.CoinDto;
import com.crypto.wservices.CoinMarketWS;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class PredictMain {

	public static void main(String[] args) {
		
		Utilities utl = new Utilities();
		ArrayList<CoinDto> requiredCoinsDtoList = utl.getRequiredCoins();
		
		CoinDao coindao = new CoinDao();
		ArrayList<CoinDBDto> oldValuesOfCoins = (ArrayList<CoinDBDto>) coindao.getAllCoinDetails();
		
		CoreAlgorithm cAlg= new CoreAlgorithm();

		utl.updateOldValuesToDB(requiredCoinsDtoList, oldValuesOfCoins);
		
		Utilities.printMap(utl.sortByComparator(cAlg.getBestCoin(requiredCoinsDtoList, oldValuesOfCoins),false));
	}

}
