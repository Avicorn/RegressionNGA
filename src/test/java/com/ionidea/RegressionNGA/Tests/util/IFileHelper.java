/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.util;

/**
 *
 * @author Avicorn
 */
public interface IFileHelper {
    void insurePathExists(String path);

    String getNewFileName(Class cls, String fileExtention);
}

