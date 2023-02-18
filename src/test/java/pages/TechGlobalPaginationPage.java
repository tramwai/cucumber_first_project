package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalPaginationPage extends TechGlobalBasePage{
    public TechGlobalPaginationPage(){super();}


    @FindBy(id = "main_heading")
    public WebElement mainHeading;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement paragraph;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = "div[class*='Data']>p")
    public List<WebElement> cityInfo;

    @FindBy(css = ".city_image")
    public WebElement cityImage;

}
