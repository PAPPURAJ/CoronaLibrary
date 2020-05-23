package com.blogspot.prajbtc.coronalibrary;

public class ReportList {
    private  String countryName;
    private int totalCase,newCase,totalDeaths,newDeaths,totalRecovered,activeCase,seriousCritical,totalTested,population;

    public ReportList(String countryName, int totalCase, int newCase, int totalDeaths, int newDeaths, int totalRecovered, int activeCase, int seriousCritical, int totalTested, int population) {
        this.countryName = countryName;
        this.totalCase = totalCase;
        this.newCase = newCase;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCase = activeCase;
        this.seriousCritical = seriousCritical;
        this.totalTested = totalTested;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getTotalCase() {
        return totalCase;
    }

    public int getNewCase() {
        return newCase;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public int getActiveCase() {
        return activeCase;
    }

    public int getSeriousCritical() {
        return seriousCritical;
    }

    public int getTotalTested() {
        return totalTested;
    }

    public int getPopulation() {
        return population;
    }
}
