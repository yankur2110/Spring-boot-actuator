package com.example.springbootactuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

@Component
public class InternetHealthMetrics implements HealthIndicator {

    @Override
    public Health health() {
        return checkInternet()==true?Health.up().withDetail("success code", "Active internet connection").build():Health.down().withDetail("error code", "Inactive internet connection").build();
    }

    private boolean checkInternet(){
        boolean flag=false;
        try{
            URL url = new URL("https://www.google.com/");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            flag=true;
        }catch (Exception e){
            flag=false;
        }
        return flag;
    }
}
