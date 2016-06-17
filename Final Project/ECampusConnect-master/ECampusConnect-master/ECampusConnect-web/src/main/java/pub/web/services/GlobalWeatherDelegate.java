/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub.web.services;

/**
 *
 * @author Advait
 */
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class GlobalWeatherDelegate {

   GlobalWeather weather = new GlobalWeather();
   GlobalWeatherSoap soap = weather.getGlobalWeatherSoap();

 public List<String> getCities(String countryName) {
     ArrayList<String> cityList = new ArrayList<String>();
     GlobalWeather weather = new GlobalWeather();
     GlobalWeatherSoap soap = weather.getGlobalWeatherSoap();
     String cities = soap.getCitiesByCountry(countryName);

   try {
         DocumentBuilder documentBuilder = DocumentBuilderFactory
                                     .newInstance().newDocumentBuilder();
         InputSource is = new InputSource();
         is.setCharacterStream(new StringReader(cities));
         Document doc = documentBuilder.parse(is);
         NodeList nodes = doc.getElementsByTagName("Table");
         for (int i = 0; i < nodes.getLength(); i++) {
                 Element element = (Element) nodes.item(i);
                 NodeList subnode = element.getElementsByTagName("City");
                 Element subelement = (Element) subnode.item(0);
                 cityList.add(subelement.getTextContent());
                 System.out.println(subelement.getTextContent());
           }
        } catch (ParserConfigurationException e) {
                e.printStackTrace();
        } catch (SAXException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
     }
    return cityList;
 }

 public CurrentWeather getWeather(String city, String country) {

    try {
          GlobalWeather weather = new GlobalWeather();
          GlobalWeatherSoap soapWeather = weather.getGlobalWeatherSoap();
          String response = soapWeather.getWeather(city, country);
          if (response.equalsIgnoreCase("Data Not Found"))
          return null;
          
         else {

         JAXBContext jAXBContext = JAXBContext
                                                        .newInstance(CurrentWeather.class);
         Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
         CurrentWeather currentWeather = (CurrentWeather) unmarshaller
                                                                   .unmarshal(new StringReader(response));
         return currentWeather;
        }
      } catch (Exception e) {
            e.printStackTrace();
     return null;
    }
 }

}