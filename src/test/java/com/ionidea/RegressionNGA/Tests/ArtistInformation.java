/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.ArtistInformationPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetBibliographyPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetBiographyPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetWorksOfArtPage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Class verifies all elements on the page
 * @author TestQA
 * v. - Draft (be supplemented and improved)
 */
public class ArtistInformation extends TestNgTestBase{ 
    

    
    @Test       
    
    //Verify that page contains all static UI elemtns
    public void elementsExistBiography() throws InterruptedException{
        
        //Initiate new page (+widget)
        ArtistInformationPage artistInformationPage = new ArtistInformationPage(driver);   
        WidgetBiographyPage widget = new WidgetBiographyPage(driver);
        //move to the URL of test page
        artistInformationPage.openPageWidget(artistInformationPage,m_baseUrl,artistInformationPage.biographyLink);
        m_wait.until(ExpectedConditions.visibilityOf(widget.biographyTitle));
        
        //Test static objects of Main page
        assertElementIsPresent(driver, artistInformationPage.onlineEditions);         
        assertElementIsPresent(driver, artistInformationPage.nameBreadCrumb);    
        assertElementIsPresent(driver, artistInformationPage.nameTitle);
        assertElementIsPresent(driver, artistInformationPage.descriptionName);
        assertElementIsPresent(driver, artistInformationPage.descriptionDate);
        assertElementIsPresent(driver, artistInformationPage.artistImage);
        assertElementIsPresent(driver, artistInformationPage.citeLink);
        assertElementIsPresent(driver, artistInformationPage.pdfLink);
        assertElementIsPresent(driver, artistInformationPage.archivedVersionsLink);
        assertElementIsPresent(driver, artistInformationPage.searchInputField);
        assertElementIsPresent(driver, artistInformationPage.biographyLink);
        assertElementIsPresent(driver, artistInformationPage.worksOfArtLink);
        assertElementIsPresent(driver, artistInformationPage.artistBibliographyLink);
        System.out.println("all static elements are displayed");
        
        //Test the objects of #Biography 
        assertTextIsPresent(driver, widget.biographyTitle,"BIOGRAPHY");
        assertTextIsPresent(driver, widget.textBegin,"Nicolaes Berchem was one of the most popular and successful Italianate landscape painters of his day. Aside from views of Italy, his extensive oeuvre of paintings, drawings, and etchings consists of depictions of the hunt and biblical and mythological scenes. Born in Haarlem in 1620, Berchem received his early training under his father, the still-life painter Pieter Claesz (Dutch, 1596/1597 - 1660). Houbra­ken, however, enumerated other teachers, including Jan van Goyen (Dutch, 1596 - 1656), Claes Moeyaert (1591–1655), Pieter de Grebber (c. 1600–1652/1653), Jan Wils (c. 1600–1666), and, somewhat improbably, Berchem’s younger cousin Jan Baptist Weenix (1621–1660/1661).");
        assertTextIsPresent(driver, widget.theAuthorName,"Arthur K. Wheelock Jr.");
        assertTextIsPresent(driver, widget.dateOfArticle,"April 24, 2014");
    }  
    //Verify all UI elements of the #Bibliography (+widget)
    
    
    
    @Test
        
        public void elementsExistBibliography() throws InterruptedException{            
        
        //Initiate new page (+widget)
        ArtistInformationPage artistInformationPage = new ArtistInformationPage(driver);   
        WidgetBibliographyPage widget = new WidgetBibliographyPage(driver);
        
        //move to the URL of test page
        artistInformationPage.openPageWidget(artistInformationPage,m_baseUrl,artistInformationPage.artistBibliographyLink);
        m_wait.until(ExpectedConditions.visibilityOf(widget.bibliographyLabel));
        
        //Verify all static  elements of the page
        assertTextIsPresent(driver,widget.bibliographyLabel,"BIBLIOGRAPHY");
        System.out.println("the label is displayed");
        
        //Add all text elements to array
        String years[][] = new String[10][2];
        years[0][0] = "1753";
        years [0][1]= "Houbraken, Arnold. De Groote Schouburgh der Nederlantsche Konstschilders en Schilderessen. 3 vols. in 1. The Hague, 1753 (Reprint: Amsterdam, 1976): 2:109-114.";
        
        years[1][0] = "1958";
        years [1][1] = "Schaar, Eckhard. Studien zu Nicolaes Berchem. Cologne, 1958.";
                
        years[2][0] = "1978";
        years [2][1]="Blankert, Albert. Nederlandse zeventiende eeuwse Italianiserende landschapschilders. Revised and enlarged ed. Exh. cat. Centraal Museum, Utrecht. Soest, 1978: 147-171.";
                
        years[3][0] = "1987";
        years [3][1]="Sutton, Peter C., et al. Masters of Seventeenth-Century Dutch Landscape Painting. Exh. cat. Rijksmuseum, Amsterdam; Museum of Fine Arts, Boston; Philadelphia Museum of Art. Boston, 1987: 262-268.";
                
        years[4][0] = "1990";
        years [4][1]="Dupare, Frederik J., and Linda L. Graif. Italian Recollections: Dutch Painters of the Golden Age. Exh. cat. The Montreal Museum of Fine Arts. Montreal, 1990: 55-78.";
                
        years[5][0] = "1991";
        years [5][1]="MacLaren, Neil. The Dutch School, 1600-1900. Revised and expanded by Christopher Brown. 2 vols. National Gallery Catalogues. London, 1991: 1:19-20.";
                
        years[6][0] = "1995";
        years [6][1]="Wheelock, Arthur K., Jr. Dutch Paintings of the Seventeenth Century. The Collections of the National Gallery of Art Systematic Catalogue. Washington, D.C., 1995: 22.";
                
        years[7][0] = "1998";
        years [7][1]="Wuestman, Gerdien. “Berchem in Prent: Tekenvoorbeeld, Kunstwerk of Bron? Verschuivingen in Functie en Betekenis van Reproduktiegrafiek.” In De Hollandse Schilderschool in Prent. Studies naar Reproduktiegrafiek in de Tweede Helft van de Zeventiende Eeuw. Ph.D. diss., Universiteit Utrecht, 1998: 59-102.";
                
        years[8][0] = "2006";
        years [8][1]="Van Thiel-Stroman, Irene. \"Nicolaes Pietersz Berchem.\" In Painting in Haarlem 1500-1850: The Collection of the Frans Hals Museum. Edited by Pieter Biesboer and Neeltje Köhler. Translated by Jennifer Kilian and Katy Kist. Ghent, 2006: 102-105.";
                
        years[9][0] = "2007";
        years [9][1]="Biesboer, Pieter. \"Nicolaes Berchem, Maître de Haarlem.\" L'Estampille--L'objet d'art 421 (2007): 28-37.";
                        
        //Verify all found static web elemnts contain respective text
        int x=0;
        while (x<10){
            assertTextIsPresent(driver,widget.yearLabel.get(x),years[x][0]);
            System.out.println("The element verified: "+widget.yearLabel.get(x));
            assertTextIsPresent(driver,widget.yearDescriptionLabel.get(x),years[x][1]);
            System.out.println("The element verified: "+widget.yearDescriptionLabel.get(x));
            x++;
            
            }
        }
                
                
        @Test 
        public void elementsExistWorksOfArt() throws InterruptedException{
        
        //Initiate new page (+widget)
        ArtistInformationPage artistInformationPage = new ArtistInformationPage(driver);
        WidgetWorksOfArtPage widget=new WidgetWorksOfArtPage(driver);
                
        //move to the URL of test page
        artistInformationPage.openPageWidget(artistInformationPage,m_baseUrl,artistInformationPage.worksOfArtLink);        
        m_wait.until(ExpectedConditions.visibilityOf(widget.leftAccordionsClosed.get(1)));    
       
        //Verify number  of folter accordions        
        Assert.assertEquals(widget.leftAccordionsClosed.size(),7);  
        System.out.println("the number of accordions is correct");
        
        //Expand all accordions
        widget.clickAllElements(widget.leftAccordionsClosed, (FluentWait) m_wait);
        System.out.println("all closed accordions are displayed");
        
        //verify all left accordions
        widget.verifyAllElementsAreDisplayed(widget.leftAccordionsOpen, (FluentWait) m_wait);
        System.out.println("all open accordions are displayed");
        
        //verify all check-boxes and respective labels
        Assert.assertEquals(widget.allCheckBoxes.size(),widget.allLabels.size());
        Assert.assertEquals(widget.allCheckBoxes.size(),11);
        widget.verifyAllElementsAreDisplayed(widget.allCheckBoxes, (FluentWait) m_wait);
        widget.verifyAllElementsAreDisplayed(widget.allLabels, (FluentWait) m_wait);
        
        //verify all check-boxes are unselected
        widget.verifyAllCheckBoxesAreUnselected(widget.allCheckBoxes, (FluentWait) m_wait);
        System.out.println("all checkboxes are verified, the number is:" +widget.allCheckBoxes.size());
        
        

        //Verify the number of the works of art
        int worksNumber;
        worksNumber = widget.addToListallWorkObjects(widget,widget.artistNameLabels, (FluentWait) m_wait);
        Assert.assertEquals(worksNumber,50);
        System.out.println("The number of author labels is - 50");
  
        
    }
        
 
        
}
