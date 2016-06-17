/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.sessionbeans;

/**
 *
 * @author Advait
 */

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;

@Singleton(name="LogShopper")
public class LogCourseCount 
{
    private static final Logger log = Logger.getLogger("LogCourseCount.class");
	
	@Schedule(hour="*/2")
	public void logShopperCount(Timer timer) {
		
		log.entering("ShopperCount.class", "getShopperCount()");
		
		String timerInfo = (String) timer.getInfo();
		System.out.println(timerInfo);
	}
    
}
