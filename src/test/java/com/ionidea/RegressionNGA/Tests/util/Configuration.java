/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Capabilities;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;

/**
 * @author Avicorn
 */
public class Configuration implements IConfiguration {
    private PropertyLoader m_propertyLoader;
    
    private String m_outputPath;
    private DateFormat m_dateFormat;
    
    public Configuration() {
        System.out.println("[Configuration]");
        m_propertyLoader = new PropertyLoader();
        
        m_dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
        m_outputPath = "../test-results/" + m_dateFormat.format(new Date()) + "/";
    }

    public DateFormat getDateFormat() {
        return m_dateFormat;
    }
    
    public String getOutputPath() {
        return m_outputPath;
    }
    
    public String getProperty(String name) throws IOException {
        return m_propertyLoader.loadProperty(name);
    }
    
    public Capabilities getCapabilities() throws IOException {
        return m_propertyLoader.loadCapabilities();
    }

}
