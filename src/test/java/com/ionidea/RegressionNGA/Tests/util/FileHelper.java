/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;

import com.google.inject.Inject;
import java.io.File;
import java.util.Date;

/**
 *
 * @author Avicorn
 */

public class FileHelper implements IFileHelper{
    @Inject
    private IConfiguration m_config;
    
    
    public void insurePathExists(String path){
      File file = new File(path);
      if (!file.exists()) {
          file.mkdir();
      }
    };

    public String getNewFileName(Class cls, String fileExtention){
        return cls.getName() + "_" + m_config.getDateFormat().format(new Date()) + fileExtention;
    };
}
