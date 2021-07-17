package com.demo.variant.data;

import com.google.gson.Gson;


public class VariantInfo {

	private String variant;
	private long confirmedCaseNumber;
	private long probableCaseNumber;
	private long totalCaseNumber;
	private long caseProportion;
	private long deaths;
	private long caseFatality;
	private long caseFatality28;
	
	public VariantInfo() {
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public long getConfirmedCaseNumber() {
		return confirmedCaseNumber;
	}

	public void setConfirmedCaseNumber(long confirmedCaseNumber) {
		this.confirmedCaseNumber = confirmedCaseNumber;
	}

	public long getProbableCaseNumber() {
		return probableCaseNumber;
	}

	public void setProbableCaseNumber(long probableCaseNumber) {
		this.probableCaseNumber = probableCaseNumber;
	}

	public long getTotalCaseNumber() {
		return totalCaseNumber;
	}

	public void setTotalCaseNumber(long totalCaseNumber) {
		this.totalCaseNumber = totalCaseNumber;
	}

	public long getCaseProportion() {
		return caseProportion;
	}

	public void setCaseProportion(long caseProportion) {
		this.caseProportion = caseProportion;
	}

	public long getDeaths() {
		return deaths;
	}

	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}

	public long getCaseFatality() {
		return caseFatality;
	}

	public void setCaseFatality(long caseFatality) {
		this.caseFatality = caseFatality;
	}
    
	public long getCaseFatality28() {
		return caseFatality28;
	}

	public void setCaseFatality28(long caseFatality28) {
		this.caseFatality28 = caseFatality28;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

