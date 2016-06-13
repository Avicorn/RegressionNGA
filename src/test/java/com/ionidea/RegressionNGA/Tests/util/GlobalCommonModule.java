package com.ionidea.RegressionNGA.Tests.util;
import com.google.inject.*;
/**
 *
 * @author Avicorn
 */
public class GlobalCommonModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(IConfiguration.class).to(Configuration.class).in(Singleton.class);
    } 
}