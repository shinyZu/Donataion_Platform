package com.ceyentra.donationplatform;

import com.ceyentra.donationplatform.config.JPAConfig;
import com.ceyentra.donationplatform.repository.CharityRepo;
import com.ceyentra.donationplatform.service.CharityService;
import com.ceyentra.donationplatform.service.impl.CharityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class AppInitializer {

    private static CharityService charityService;

    public static void main(String[] args) throws IOException {

        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);

        // get the bean from spring container
        charityService = context.getBean("charityServiceImpl", CharityServiceImpl.class);

        // get all charity logos
        List<String> charityLogos = AppInitializer.charityService.getAllCharityLogos();

        for (String url : charityLogos) {
//            System.out.println(url);

            //Specify URL from which file will be downloaded.
            URL logoURL = new URL(url);
            System.out.println(logoURL);

            String downloadFileLocation = "/home/shinyT480/Ceyentra/Projects/DonationPlatform/charity_logo_images/"+ UUID.randomUUID().toString()+".jpg";

            //Read image from specified URL using InputStream
            InputStream is = logoURL.openStream();

            //Write image to file using FileOutputStream
            OutputStream fos = new FileOutputStream(downloadFileLocation);

            int ch;
            while ((ch = is.read()) != -1) {
                fos.write(ch);
            }

            System.out.println("Image from specified URL has been downloaded at " +downloadFileLocation);
            is.close();
            fos.close();
        }

        // close the context
        context.close();

    }

}
