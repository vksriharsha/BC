package com.crypto.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  

import com.crypto.dto.CoinDBDto;

public class CoinDao {  
	
	@SuppressWarnings("unchecked")
	public List<CoinDBDto> getAllCoinDetails(){

		try
		{

			//creating configuration object  
			Configuration cfg=new Configuration();  
			cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  

			//creating seession factory object  
			SessionFactory factory=cfg.buildSessionFactory();  

			Session session = factory.openSession();
		    Query qry = session.createQuery("from CoinDBDto");

		    List<CoinDBDto> list =qry.list();
		    System.out.println("Total Number Of Records : "+list.size());

		   
		    session.close();
		    factory.close();
		    return list;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public void updateCoin(CoinDBDto coindto){
		//creating configuration object  
		Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  

		//creating seession factory object  
		SessionFactory factory=cfg.buildSessionFactory();  

		//creating session object  
		Session session=factory.openSession();  

		Object o=session.load(CoinDBDto.class,coindto.getCoinId());
		CoinDBDto oldCoin=(CoinDBDto)o;

		//creating transaction object  
		Transaction t=session.beginTransaction();  

		oldCoin.setX1hoursback(coindto.getX1hoursback());
		oldCoin.setX2hoursback(coindto.getX2hoursback());
		oldCoin.setX3hoursback(coindto.getX3hoursback());
		oldCoin.setX4hoursback(coindto.getX4hoursback());
		//persisting the object  

		t.commit();//transaction is committed  
		session.close();  
		factory.close();
		System.out.println("successfully updated");  
	}
}  