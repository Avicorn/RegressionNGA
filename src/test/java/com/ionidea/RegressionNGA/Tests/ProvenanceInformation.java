/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import static com.ionidea.RegressionNGA.Tests.TestNgTestBase.m_baseUrl;
import com.ionidea.RegressionNGA.Tests.pages.ArtistInformationPage;
import com.ionidea.RegressionNGA.Tests.pages.ProvenanceInformationPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetBiographyPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetWorksOfArtPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author TestQA
 */
public class ProvenanceInformation extends TestNgTestBase{
    
    @Test
    
    public void provenanceElementsExist() throws InterruptedException{
        
        ProvenanceInformationPage provenanceInformationPage = new ProvenanceInformationPage(driver);   
        WidgetWorksOfArtPage widget = new WidgetWorksOfArtPage(driver);
        
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.6747.html#works");
        provenanceInformationPage.worksOfArtLink.click();
        m_wait.until(ExpectedConditions.visibilityOf(widget.leftAccordionsClosed.get(1)));
        
        //Verify number  of folter accordions        
        Assert.assertEquals(widget.leftAccordionsClosed.size(),4);  
        System.out.println("the number of accordions is correct");
        
        //Expand all accordions
        widget.clickAllElements(widget.leftAccordionsClosed, (FluentWait) m_wait);
        System.out.println("all closed accordions are displayed");
        
        //verify all left accordions
        widget.verifyAllElementsAreDisplayed(widget.leftAccordionsOpen, (FluentWait) m_wait);
        System.out.println("all open accordions are displayed");
        
        //verify all check-boxes and respective labels
        Assert.assertEquals(widget.allCheckBoxes.size(),widget.allLabels.size());
        Assert.assertEquals(widget.allCheckBoxes.size(),8);
        widget.verifyAllElementsAreDisplayed(widget.allCheckBoxes, (FluentWait) m_wait);
        widget.verifyAllElementsAreDisplayed(widget.allLabels, (FluentWait) m_wait);
        
        //verify all check-boxes are unselected
        widget.verifyAllCheckBoxesAreUnselected(widget.allCheckBoxes, (FluentWait) m_wait);
        System.out.println("all checkboxes are verified, the number is:" +widget.allCheckBoxes.size());
        
        

        //Verify the number of the works of art
        int worksNumber;
        worksNumber = widget.addToListallWorkObjects(widget,widget.artistNameLabels,2, (FluentWait) m_wait);
        Assert.assertEquals(worksNumber,40);
        System.out.println("The number of author labels is - 50");
  
        
    }
    
    
    
}
