package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TigaPage {

    public TigaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "menu-item-179")
    public WebElement projelerimizButton;

    @FindBy(xpath = "//h3[@class=\"page-heading\"]")
    public WebElement pageHeadingText;

    @FindBy(xpath = "//div[@style=\"padding-right:10%;\"]")
    public WebElement tigaHakkindaText;

    @FindBy(className = "icon-twitter-circled")
    public WebElement twitterLogo;

    @FindBy(xpath = "//span[text()=\"As Tiga Healthcare Technologies, we have been driving healthcare forward with our proven technology since 2007.\"]")
    public WebElement twitterBio;

    @FindBy(className = "icon-youtube")
    public WebElement youtubeIcon;

    @FindBy(xpath = "(//div[@class=\"yt-spec-touch-feedback-shape__fill\"])[4]")
    public WebElement ytSubscribeButton;

    @FindBy(xpath = "(//span[text()=\"İletişim\"])[1]")
    public WebElement iletisimButton;

    @FindBy(xpath = "//div[@class=\"review-number\"]")
    public WebElement reviewNumber;

    @FindBy(xpath = "//iframe[@src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d765.102268425268!2d32.81166206809886!3d39.90986079342956!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d34f4c66534365%3A0x6009088a41ff5231!2sTiga+Bilgi+Teknolojileri!5e0!3m2!1str!2str!4v1560336962401!5m2!1str!2str\"]")
    public WebElement iFrameOfnextLevel;

    @FindBy(xpath = "//button[@title=\"Büyüt\"]")
    public WebElement zoomIn;

    @FindBy(xpath = "//button[@title=\"Küçült\"]")
    public WebElement zoomOut;


}
