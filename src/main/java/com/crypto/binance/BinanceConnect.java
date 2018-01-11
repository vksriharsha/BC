package com.crypto.binance;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.market.TickerStatistics;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketSell;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;
public class BinanceConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("api key", "Secret Key");
	    BinanceApiRestClient client = factory.newRestClient();

	    
	    
	    Account account = client.getAccount(6000000L, System.currentTimeMillis());
	    System.out.println(account.getBalances());
	    System.out.println();
	    System.out.println(account.getAssetBalance("ETH"));
	    
	  /*  TickerStatistics ts = client.get24HrPriceStatistics("ASTETH");
	    System.out.println("Ask Price="+ ts.getAskPrice());
	    
	   // Buy - other coin ..... Sell - Ethereum
	   //NewOrderResponse newOrderResponse = client.newOrder(marketSell("XRPETH", "1"));
	    NewOrderResponse newOrderResponse = client.newOrder(marketBuy("ASTETH", "1"));
	   System.out.println(newOrderResponse);
	     
	    System.out.println(mytrades);
	   List<Order> allOrders = client.getAllOrders(new AllOrdersRequest("LINKBTC").limit(10));
	    System.out.println(allOrders);*/
	}

}
