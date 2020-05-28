package get.service;

import get.interfaces.*;

import java.util.List;

public class CountriesServiceManager {

    private static void printContinents(CountryInfoServiceSoapType cisst) {
        ArrayOftContinent aoc = cisst.listOfContinentsByName();
        List<TContinent> tContinent = aoc.getTContinent();

        System.out.println("Continents:");
        for (TContinent tc : tContinent) {
            System.out.println(tc.getSCode() + " - " + tc.getSName());
        }
    }

    private static void printCountries(CountryInfoServiceSoapType cisst) {
        ArrayOftCountryCodeAndName aocn = cisst.listOfCountryNamesByCode();
        List<TCountryCodeAndName> tCountryCodeAndName = aocn.getTCountryCodeAndName();

        System.out.println("Countries:");
        for (TCountryCodeAndName tcan : tCountryCodeAndName){
            System.out.println(tcan.getSName()+" ("+tcan.getSISOCode()+")");
        }
    }

    private static void printCurrencies(CountryInfoServiceSoapType cisst) {
        ArrayOftCurrency aocn = cisst.listOfCurrenciesByName();
        List<TCurrency> tCurrency = aocn.getTCurrency();

        System.out.println("Currencies:");
        for (TCurrency tcur : tCurrency){
            System.out.println(tcur.getSName() + " ("+tcur.getSISOCode()+")");
        }
    }
//
    public static void main(String[] args) {
        CountryInfoService cis = new CountryInfoService();
        CountryInfoServiceSoapType cisst = cis.getCountryInfoServiceSoap();

//        printContinents(cisst);
//        printCountries(cisst);
        printCurrencies(cisst);
    }
}
