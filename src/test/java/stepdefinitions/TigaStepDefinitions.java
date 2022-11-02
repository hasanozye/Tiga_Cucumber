package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.TigaPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TigaStepDefinitions {

    TigaPage tigaPage = new TigaPage();

    String tigaHandle = ""; //to reach handle from other methods, i defined global
    String twitterHandle = ""; //to reach handle from other methods, i defined global
    Actions actions = new Actions(Driver.getDriver()); //to write it efficiently, i defined global

    @Given("user goes to {string} webpage")
    public void user_goes_to_webpage(String theURL) {
        Driver.getDriver().get(ConfigurationReader.getProperty(theURL));
    }

    @Then("clicks on Projelerimiz")
    public void clicks_on_projelerimiz() {
        assertEquals(tigaPage.projelerimizButton.getText(), "Projelerimiz");
        tigaPage.projelerimizButton.click();
    }

    @Then("verifies the main text")
    public void verifies_the_main_text() {
        String expectedResult = "Gelişen internet ve yazılım teknolojilerini, bireysel ve kurumsal müşterilerimiz için pozitif bir değişim aracı olarak kullanarak toplumsal gelişmeye katkıda bulunuyoruz.";
        assertEquals(expectedResult, tigaPage.pageHeadingText.getText());
    }

    @Then("scrolls down until the bottom of the page")
    public void scrolls_down_until_the_bottom_of_the_page() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("verifies Tiga Hakkinda texts")
    public void verifies_Tiga_Hakkinda_texts() {
        String expectedResult = "Tiga Bilgi Teknolojileri A.Ş. kurulduğu günden itibaren yenilikçi uygulamalarıyla ülkemizi bilgi teknolojileri alanında dünya ile yarışır kılmak, ülkemizin sektördeki dışa bağımlılığını azaltmak hedefiyle hizmet vermektedir...";
        assertEquals(expectedResult, tigaPage.tigaHakkindaText.getText());
    }

    @Then("clicks on twitter logo")
    public void clicks_on_twitter_logo() {

        //First get the tigaPage handle
        tigaHandle = Driver.getDriver().getWindowHandle();

        //Then open twitter page
        actions.click(tigaPage.twitterLogo).perform();

        //Then use set to get all window handles
        Set<String> allHandles = Driver.getDriver().getWindowHandles();

        //Then use for each loop to get the twitter handle
        twitterHandle = "";

        for (String each : allHandles) {
            if (!each.equals(tigaHandle)) {
                twitterHandle = each;
            }

        }
        //driver switches to twitter
        Driver.getDriver().switchTo().window(twitterHandle);
    }

    @Then("clicks on youtube logo")
    public void clicks_on_youtube_logo() {
        Driver.getDriver().switchTo().window(tigaHandle);
        actions.click(tigaPage.youtubeIcon).perform();

        Set<String> allHandles = Driver.getDriver().getWindowHandles();

        String ytHandle = "";

        for (String each : allHandles) {
            if (!each.equals(tigaHandle) || each.equals(twitterHandle)) {
                ytHandle = each;
            }

        }

        Driver.getDriver().switchTo().window(ytHandle);
    }

    @Then("clicks on subscribe")
    public void clicks_on_subscribe() {
        actions.click(tigaPage.ytSubscribeButton).perform();
    }

    @Then("in the opening page verifies the tiga biography text")
    public void in_the_opening_page_verifies_the_tiga_biography_text() {
        String expectedResult = "As Tiga Healthcare Technologies, we have been driving healthcare forward with our proven technology since 2007.";
        assertEquals(expectedResult, tigaPage.twitterBio.getText());
    }

    @Then("hovers Projelerimiz")
    public void hovers_projelerimiz() {
        //i used reusable method to see the color changing and verified it within inside of the method
        ReusableMethods.hover(tigaPage.projelerimizButton);
    }

    @Then("clicks on iletişim")
    public void clicks_on_iletişim() {
        actions.click(tigaPage.iletisimButton).perform();
    }

    @Then("verifies the review number")
    public void verifies_the_review_number() {

        //first i have to switch to iFrame
        Driver.getDriver().switchTo().frame(tigaPage.iFrameOfnextLevel);

        //then review
        System.out.println("tigaPage.reviewNumber = " + tigaPage.reviewNumber);
        assertEquals("4,9",tigaPage.reviewNumber.getText());

    }

    @Then("then zooms in")
    public void then_zooms_in() {
        actions.click(tigaPage.zoomIn).perform();
    }


    @Then("then zooms out")
    public void then_zooms_out() {
        actions.click(tigaPage.zoomOut).perform();
    }
}
