/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Avicorn
 */
public class Configuration implements IConfiguration {
    private String _outputPath;
    
    public Configuration() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
        this._outputPath = "../"+dateFormat.format(new Date())+"/";
    }

    public String getOutputPath() {
        return _outputPath;
    }
}
