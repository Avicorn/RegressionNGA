/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Avicorn
 */
public interface IDriverExtension {
     void waitForPageLoaded(WebDriver driver, int standartWaitTime);
}
