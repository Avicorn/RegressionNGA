/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import static com.ionidea.RegressionNGA.Tests.TestNgTestBase.m_baseUrl;
import com.ionidea.RegressionNGA.Tests.pages.MainPage;
import java.util.Iterator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author TestQA
 */
public class FooterTest extends TestNgTestBase {
        
    /**
     * the method verifies that the opened page is respective to the used sub menu option
     * @param url 
     * @param title
     * @param mainMenu 
     */    
    
    public void verifyOpenedPage(String url,String title) throws InterruptedException{
        
        //create excplicite wait
    
        m_wait.until(ExpectedConditions.titleContains(title));        
        //verify URL and title of the opened page
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        Assert.assertTrue(driver.getTitle().contains(title));  
        
    }
    
    /**
     * the method verifies that the opened page is respective to the used sub menu option
     * @param url 
     * @param link
     */  
    
    public void verifyFooterLinks(String url, WebElement link ) throws InterruptedException{
        driver.get(m_baseUrl);
        String mainHandle = driver.getWindowHandle();
        
        //Click on the link
        m_wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
        //create excplicite wait 
        Thread.sleep(2000);
        if(url=="https://www.google.com/maps/place/Constitution+Ave+"){
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
                if(driver.getCurrentUrl().contains("https://www.google.com/maps/place/Constitution+Ave+")){;
                    driver.close();
                    driver.switchTo().window(mainHandle);
                    break;
                }
            }
        }    
        else{
       //WebDriverWait wait = new WebDriverWait(driver,30000);
        m_wait.until(ExpectedConditions.urlContains(url));        
        //verify URL and title of the opened page
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        }
    }

    @Test       
    
    public void testMenu() throws InterruptedException{
        
        //initiate new page
        MainPage page = new MainPage(driver);
        //WebDriverWait wait = new WebDriverWait(driver,30000);
        
        //Open main page
        driver.get(m_baseUrl);  
        driver.manage().window().maximize();
        
        //Add all results for footer menu verifying   to array
        String[][] footerMenuResults={
        {"/content/ngaweb/about.html", "About"},
        {"/content/ngaweb/opportunities.html", "Opportunities"},
        {"/content/ngaweb/press.html", "Press Office"},
        {"/en/page/show_home_page.html", "National Gallery of Art | NGA Images"},
        {"/subscription_form_ngart.cfm", "Newsletter Subscription"},
        {"/content/ngaweb/notices.html", "Notices"},
        {"/content/ngaweb/contact-us.html", "Contact Us"},
        {"/content/ngaweb/audio-video.html", "Audio and Video"}       
      };
        
        //Add all results for links verifying to array
        String[]footerLinksResults={
        "https://www.google.com/maps/place/Constitution+Ave+",
        "https://twitter.com/ngadc",
        "https://www.facebook.com/nationalgalleryofart",
        "https://www.instagram.com/ngadc/",
        "https://www.pinterest.com/ngadc/"
        };
        
        
        //Verify all footer menu options
        int index =0;
        while(index<8){
            Thread.sleep(2000);
            driver.get(m_baseUrl);
            m_wait.until(ExpectedConditions.elementToBeClickable(page.footerMenu.get(index)));
            page.footerMenu.get(index).click();
            verifyOpenedPage(footerMenuResults[index][0],footerMenuResults[index][1]);
            System.out.println("the footer menu is verified, index: "+index);
            index++;
        }
        
        //Verify footer  Social Medi Links
        verifyFooterLinks(footerLinksResults[0],page.directions);
        verifyFooterLinks(footerLinksResults[1],page.twitterLink);
        verifyFooterLinks(footerLinksResults[2],page.facebookLink);
        verifyFooterLinks(footerLinksResults[3],page.instagramLink);
        verifyFooterLinks(footerLinksResults[4],page.pinterestLink);
        System.out.println("All Social Media Links are verified");
        
        //Verify text of the copyright label
        driver.get(m_baseUrl);
        assertTextIsPresent(driver,page.copyRightLabel,"© 2016 National Gallery of Art");
        System.out.println("The copyright information is correct");
        
    }
    
}
