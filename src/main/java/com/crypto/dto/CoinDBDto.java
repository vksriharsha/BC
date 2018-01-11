package com.crypto.dto;

public class CoinDBDto {

	private String CoinId;
	private double x4hoursback;
	private double x3hoursback;
	private double x2hoursback;
	private double x1hoursback;
	public String getCoinId() {
		return CoinId;
	}
	public void setCoinId(String coinId) {
		CoinId = coinId;
	}
	public double getX4hoursback() {
		return x4hoursback;
	}
	public void setX4hoursback(double x4hoursback) {
		this.x4hoursback = x4hoursback;
	}
	public double getX3hoursback() {
		return x3hoursback;
	}
	public void setX3hoursback(double x3hoursback) {
		this.x3hoursback = x3hoursback;
	}
	public double getX2hoursback() {
		return x2hoursback;
	}
	public void setX2hoursback(double x2hoursback) {
		this.x2hoursback = x2hoursback;
	}
	public double getX1hoursback() {
		return x1hoursback;
	}
	public void setX1hoursback(double x1hoursback) {
		this.x1hoursback = x1hoursback;
	}
	@Override
	public String toString() {
		return "CoinDBDto [CoinId=" + CoinId + ", x4hoursback=" + x4hoursback
				+ ", x3hoursback=" + x3hoursback + ", x2hoursback="
				+ x2hoursback + ", x1hoursback=" + x1hoursback + "]";
	}
	public CoinDBDto(String coinId, double x4hoursback, double x3hoursback,
			double x2hoursback, double x1hoursback) {
		super();
		CoinId = coinId;
		this.x4hoursback = x4hoursback;
		this.x3hoursback = x3hoursback;
		this.x2hoursback = x2hoursback;
		this.x1hoursback = x1hoursback;
	}
	public CoinDBDto() {
		super();
	}
	
	
}
