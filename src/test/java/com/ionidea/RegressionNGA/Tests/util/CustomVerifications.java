/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;


import static java.lang.Boolean.TRUE;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
 * The interface contains custom verifications
 * @author TestQA
 */
public abstract interface CustomVerifications{

    
    public static boolean assertElementIsPresent(WebDriver driver, WebElement element1){
                
        WebDriverWait wait = new WebDriverWait(driver, 30000);    
        wait.until(ExpectedConditions.visibilityOf(element1));
        Assert.assertTrue(element1.isDisplayed());       
        System.out.println("The element  is found:"+element1.toString());
        return true;
    }
    
    public static boolean assertTextIsPresent(WebDriver driver, WebElement element2,String text){
        WebDriverWait wait = new WebDriverWait(driver, 30000);    
        wait.until(ExpectedConditions.visibilityOf(element2));
        Assert.assertEquals(element2.getText(),text);     
        System.out.println("The element  is found:"+element2.getText());;
        return true;
    }
    
}
