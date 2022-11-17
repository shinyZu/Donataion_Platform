package com.ceyentra.donationplatform;

import com.ceyentra.donationplatform.config.JPAConfig;
import com.ceyentra.donationplatform.repository.CharityRepo;
import com.ceyentra.donationplatform.service.CharityService;
import com.ceyentra.donationplatform.service.ProgramService;
import com.ceyentra.donationplatform.service.impl.CharityServiceImpl;
import com.ceyentra.donationplatform.service.impl.ProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class AppInitializer {

    private static CharityService charityService;
    private static ProgramService programService;

    public static void main(String[] args) throws IOException {

        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);

        // get the bean from spring container
        charityService = context.getBean("charityServiceImpl", CharityServiceImpl.class);
        programService = context.getBean("programServiceImpl", ProgramServiceImpl.class);

        // downloadAllCharityLogos();
        // downloadAllCharityBanners();
        // downloadAllShareURLBanners();

        // close the context
        context.close();

    }

    private static void downloadAllShareURLBanners() {
        // get all charity logos
        List<String> shareURLBanners = AppInitializer.programService.getAllShareURLBanners();

        try{
            for (String url : shareURLBanners) {
                // System.out.println(url);

                //Specify URL from which file will be downloaded.
                URL logoURL = new URL(url);
                System.out.println(logoURL);

                String downloadFileLocation = "/home/shinyT480/Ceyentra/Projects/DonationPlatform/03_share_url_banners/"+ UUID.randomUUID().toString()+".jpg";

                //Read image from specified URL using InputStream
                InputStream is = logoURL.openStream();

                //Write image to file using FileOutputStream
                OutputStream fos = new FileOutputStream(downloadFileLocation);

                int ch;
                while ((ch = is.read()) != -1) {
                    fos.write(ch);
                }

                System.out.println("Image from specified URL has been downloaded to " +downloadFileLocation);
                is.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadAllCharityBanners()  {
        // get all charity logos
        List<String> charityBanners = AppInitializer.programService.getAllCharityBanners();

        try{
            for (String url : charityBanners) {
                // System.out.println(url);

                //Specify URL from which file will be downloaded.
                URL logoURL = new URL(url);
                System.out.println(logoURL);

                String downloadFileLocation = "/home/shinyT480/Ceyentra/Projects/DonationPlatform/02_charity_banners/"+ UUID.randomUUID().toString()+".jpg";

                //Read image from specified URL using InputStream
                InputStream is = logoURL.openStream();

                //Write image to file using FileOutputStream
                OutputStream fos = new FileOutputStream(downloadFileLocation);

                int ch;
                while ((ch = is.read()) != -1) {
                    fos.write(ch);
                }

                System.out.println("Image from specified URL has been downloaded to " +downloadFileLocation);
                is.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadAllCharityLogos() throws IOException {
        // get all charity logos
        List<String> charityLogos = AppInitializer.charityService.getAllCharityLogos();

        for (String url : charityLogos) {
           // System.out.println(url);

            //Specify URL from which file will be downloaded.
            URL logoURL = new URL(url);
            System.out.println(logoURL);

            String downloadFileLocation = "/home/shinyT480/Ceyentra/Projects/DonationPlatform/01_charity_logos/"+ UUID.randomUUID().toString()+".jpg";

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
    }

}
