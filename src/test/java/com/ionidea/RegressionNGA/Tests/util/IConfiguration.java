/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;

import java.io.IOException;
import java.text.DateFormat;
import org.openqa.selenium.Capabilities;

/**
 * @author Avicorn
 */
public interface IConfiguration {
   DateFormat getDateFormat();
   String getOutputPath();
   
   String getProperty(String name) throws IOException;
   Capabilities getCapabilities() throws IOException;
}
