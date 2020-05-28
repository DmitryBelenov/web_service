<%@ page import="get.interfaces.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Web Service</title>
</head>

<%
    CountryInfoService cis = new CountryInfoService();
    CountryInfoServiceSoapType cisst = cis.getCountryInfoServiceSoap();

    ArrayOftCountryInfo infoList = null;
    List<TCountryInfo> tCountryInfo = null;

    boolean ready = false;
    while (!ready) {
        if (cisst != null) {
            infoList = cisst.fullCountryInfoAllCountries();
            tCountryInfo = infoList.getTCountryInfo();
            ready = true;
        }
    }
%>

<body>
 <%
     if (tCountryInfo != null) {
        for(TCountryInfo countryInfo : tCountryInfo){
        %>
        <span style="font-size: 24px; font-family: 'Tahoma';"><%= countryInfo.getSName() + " ("+countryInfo.getSISOCode()+")"%></span>&nbsp;&nbsp;<img src="<%= countryInfo.getSCountryFlag()%>">
        <span style="font-size: 24px; font-family: 'Tahoma';"><%= "  ["+countryInfo.getSContinentCode()+"]"%></span>
        <hr>
        <span style="font-size: 12px; font-family: 'Tahoma';">Capital: </span><span style="font-size: 16px; font-family: 'Tahoma';"><%= countryInfo.getSCapitalCity()%></span>
        <br>
        <span style="font-size: 12px; font-family: 'Tahoma';">Currency: </span><span style="font-size: 16px; font-family: 'Tahoma';"><%= countryInfo.getSCurrencyISOCode()%></span>
        <br>
        <span style="font-size: 12px; font-family: 'Tahoma';">Languages: </span>
        <br>
        <%
            ArrayOftLanguage aol = countryInfo.getLanguages();
            List<TLanguage> tLanguage = aol.getTLanguage();
            for (TLanguage lang : tLanguage){
                %>
                    <span style="font-size: 16px; font-family: 'Tahoma';"><%= lang.getSName() + " (" + lang.getSISOCode()+")"%></span>
                    <br>
                <%
            }
        %>
        <span style="font-size: 12px; font-family: 'Tahoma';">Phone code: </span><span style="font-size: 16px; font-family: 'Tahoma';"><%= countryInfo.getSPhoneCode()%></span>
        <br><br><br><br><br><br>
  <%
    }
      } else {
         %>NO RESULTS<%
    }
 %>
</body>
</html>