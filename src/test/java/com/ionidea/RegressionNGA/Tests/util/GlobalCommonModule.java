package com.ionidea.RegressionNGA.Tests.util;

import com.google.inject.*;
import com.ionidea.RegressionNGA.Tests.util.*;

/**
 *
 * @author Avicorn
 */
public class GlobalCommonModule implements Module {
    private static IConfiguration m_configuration;
    private static IConfiguration getConfiguration() {
        if (m_configuration == null) {
            m_configuration = new Configuration();
        }
   
        return m_configuration;
    }
    
    private static IFileHelper m_fileHelper;
    private static IFileHelper getFileHelper() {
        if (m_fileHelper == null) {
            m_fileHelper = new FileHelper();
        }

        return m_fileHelper;
    }
    
    
    
    @Override
    public void configure(Binder binder) {
        binder.bind(IConfiguration.class).toInstance(getConfiguration());
        binder.bind(IFileHelper.class).toInstance(getFileHelper());
    } 
}