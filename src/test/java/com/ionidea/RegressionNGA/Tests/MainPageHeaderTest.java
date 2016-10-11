/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.MainPage;
import java.util.ArrayList;
import java.util.List;
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
public class MainPageHeaderTest extends TestNgTestBase{ 
    
    /**
     * the method verifies that the opened page is respective to the used sub menu option
     * @param relativeUrl 
     * @param mainMenu 
     */    
    
    public void verifyOpenedPage(String relativeUrl,String title, Integer mainMenuIndex ){

        //verify that the title contains correct value           
        if(mainMenuIndex==8){
            m_wait.until(ExpectedConditions.urlContains("https://shop.nga.gov"+relativeUrl));
            Assert.assertTrue(driver.getCurrentUrl().contains("https://shop.nga.gov"+relativeUrl));
            System.out.println(relativeUrl);
        }
        else{
            m_wait.until(ExpectedConditions.urlContains(m_baseUrl+relativeUrl));
            Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl+relativeUrl));
            System.out.println(relativeUrl);
        }        
        //verify that the URL of opened page is correct 
        m_wait.until(ExpectedConditions.titleContains(title)); 
        Assert.assertTrue(driver.getTitle().contains(title));
        System.out.println("the page is loaded");        
    }

    @Test(dataProvider="collectionSubMenu")
    public void testMenu(String url, String title, Integer mainMenuIndex, Integer subMenuIndex) throws InterruptedException{
        //driver.manage().window().maximize();
        MainPage menu = new MainPage(driver);
        driver.get(m_baseUrl);  
        
        //Add all submenus to the List
        List <List> subMenu  = new ArrayList<>();
        subMenu.add(menu.subMenuVisit);
        subMenu.add(menu.subMenuCollection);
        subMenu.add(menu.subMenuExhibitions);
        subMenu.add(menu.subMenuEducation);
        subMenu.add(menu.subMenuConservation);
        subMenu.add(menu.subMenuResearch);
        subMenu.add(menu.subMenuCalendar);
        subMenu.add(menu.subMenuSupport);
        subMenu.add(menu.subMenuShop);        
        
        //Select necessary submenu list (accordin to the main menu option)
        List<WebElement> currentSubMenu = subMenu.get(mainMenuIndex);
        
        //Select submenu option and verify that correct page is opened
        menu.selectMenuOption(menu.mainMenuOptions.get(mainMenuIndex), currentSubMenu.get(subMenuIndex), this); 
        verifyOpenedPage(url, title, mainMenuIndex);
        //System.out.println("The submenu verified: "+currentSubMenu.get(subMenuIndex));
    }
       
        
        @DataProvider
        public Object[][] collectionSubMenu() {
            return new Object[][]{
                /*
                //Visit
            {"/content/ngaweb/visit/getting-here.html", "Getting Here",0,0},            
            {"/content/ngaweb/visit/accessibility.html", "Accessibility",0,1},
            {"/content/ngaweb/visit/tours-and-guides.html","Tours and Guides",0,2},
            {"/content/ngaweb/visit/shops.html","Gallery Shops",0,3},
            {"/content/ngaweb/visit/cafes.html","Cafes",0,4},
            {"/content/ngaweb/visit/ice-rink.html","The Ice Rink",0,5},
            {"/content/ngaweb/visit/copyist.html","Copyist",0,6},  
            {"/content/ngaweb/visit/visitor-policies.html","Visitor Policies",0,7},
            
                             
                // Collection 
            {"/content/ngaweb/Collection/highlights.html", "Highlights",1,0},
            {"/content/ngaweb/Collection/collection-search.html","Collection Search",1,1},
            {"/content/ngaweb/Collection/artists.html", "Artists",1,2},
            {"/content/ngaweb/Collection/recent_acquisitions.html","Recent Acquisitions",1,3},
            
                //Exhibitions
            {"/content/ngaweb/exhibitions/current.html", "Current",2,0},
            {"/content/ngaweb/exhibitions/upcoming.html","Upcoming",2,1},
            {"/content/ngaweb/exhibitions/ontour.html", "On Tour",2,2},
            {"/content/ngaweb/exhibitions/past.html","Past",2,3},
            
              //Education
            {"/content/ngaweb/education/teachers.html", "Teachers",3,0},
            {"/content/ngaweb/education/families.html","Families",3,1},
            {"/content/ngaweb/education/kids.html", "NGAkids Art Zone",3,2},
            {"/content/ngaweb/education/teens.html","Teens",3,3},
            {"/content/ngaweb/education/adults.html","Adults",3,4},
            {"/content/ngaweb/education/interns-fellows.html","Interns",3,5},
            {"/content/ngaweb/education/learningresources.html","About Learning Resources",3,6},
            
                //Conservation
            {"/content/ngaweb/conservation/projects.html", "Projects",4,0},
            {"/content/ngaweb/conservation/publications.html","Publications",4,1},
            {"/content/ngaweb/conservation/resources.html", "Resources",4,2},
            
                //Research
            {"/content/ngaweb/research/casva.html", "CASVA",5,0},
            {"/content/ngaweb/research/publications.html","Publications",5,1},
            {"/content/ngaweb/research/make-an-appointment.html", "Make an Appointment",5,2},
            {"/content/ngaweb/research/gallery-archives.html","Gallery Archives",5,3},
            {"/content/ngaweb/research/library.html","Library",5,4},
            {"/content/ngaweb/research/online-editions.html","Online Editions",5,5},
            
                //Calendar
            {"/content/ngaweb/calendar/film-programs.html", "Film Programs",6,0},
            {"/content/ngaweb/calendar/concerts.html","Concerts",6,1},
            {"/content/ngaweb/calendar/jazz.html", "Jazz Programs",6,2},
            {"/content/ngaweb/calendar/gallery-talks.html","Gallery Talks",6,3},
            {"/content/ngaweb/calendar/lectures.html","Lectures",6,4},
            {"/content/ngaweb/calendar/guided-tours.html", "Guided Tours",6,5},
            {"/content/ngaweb/calendar/family-activities.html","Family Activities",6,6},
            {"/content/ngaweb/calendar/films-for-children.html","Films for Children",6,7},
            
           
                //Support
            {"/content/ngaweb/support/vital-partnerships.html", "Vital Partnerships",7,0},
            {"/content/ngaweb/support/membership.html","Membership",7,1},
            {"/content/ngaweb/support/major-giving.html", "Major Giving",7,2},
            {"/content/ngaweb/support/planned-giving.html","Planned Giving",7,3},
            {"/content/ngaweb/support/corporate-giving.html","Corporate Giving",7,4},
            {"/content/ngaweb/support/gifts-of-art.html","Gifts of Art",7,5},
            {"/content/ngaweb/support/donate-now.html","Donate Now",7,6},
            */
                //Shop
            {"/category/1000/exhibitions/1.html", "Exhibitions | National Gallery of Art Shops | shop.nga.gov",8,0},
            {"/category/2000/books-media/1.html","Books ",8,1},
            {"/category/3000/stationery/1.html", "Stationery",8,2},
            {"/category/4000/jewelry/1.html","Jewelry",8,3},
            {"/category/5000/prints/1.html","Prints",8,4},
            {"/category/6000/apparel/1.html","Apparel",8,5},
            {"/category/7000/for-the-home/1.html","For the Home",8,6},
            {"/category/10000/kids/1.html","Kids",8,7}
            };
            
        }

}


