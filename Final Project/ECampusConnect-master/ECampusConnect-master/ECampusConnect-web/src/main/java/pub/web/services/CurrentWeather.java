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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CurrentWeather")
public class CurrentWeather {

 private String location;
 private String time;
 private String wind;
 private String visibility;
 private String temperature;
 private String dewPoint;
 private String relativeHumidity;
 private String pressure;
 private String status;
 
 @XmlElement(name="Location")
 public String getLocation() {
      return location;
 }
 public void setLocation(String location) {
      this.location = location;
 }
 @XmlElement(name="Time")
      public String getTime() {
      return time;
 }
 public void setTime(String time) {
      this.time = time;
 }
 @XmlElement(name="Wind")
 public String getWind() {
      return wind;
 }
 public void setWind(String wind) {
      this.wind = wind;
 }
 @XmlElement(name="Visibility")
 public String getVisibility() {
      return visibility;
 }
 public void setVisibility(String visibility) {
       this.visibility = visibility;
 }
 @XmlElement(name="Temperature")
 public String getTemperature() {
        return temperature;
 }
 public void setTemperature(String temperature) {
        this.temperature = temperature;
 }
 @XmlElement(name="DewPoint")
 public String getDewPoint() {
         return dewPoint;
 }
 public void setDewPoint(String dewPoint) {
         this.dewPoint = dewPoint;
 }
 @XmlElement(name="RelativeHumidity")
 public String getRelativeHumidity() {
          return relativeHumidity;
 }
 public void setRelativeHumidity(String relativeHumidity) {
          this.relativeHumidity = relativeHumidity;
 }
 @XmlElement(name="Pressure")
 public String getPressure() {
          return pressure;
 }
 public void setPressure(String pressure) {
          this.pressure = pressure;
 }
 @XmlElement(name="Status")
 public String getStatus() {
           return status;
 }
 public void setStatus(String status) {
        this.status = status;
 }
 @Override
 public String toString() {
       return "CurrentWeather [location=" + location + ", time=" + time
          + ", wind=" + wind + ", visibility=" + visibility
          + ", temperature=" + temperature + ", dewPoint=" + dewPoint
          + ", relativeHumidity=" + relativeHumidity + ", pressure="
          + pressure + ", status=" + status + "]";
 }
 
}
