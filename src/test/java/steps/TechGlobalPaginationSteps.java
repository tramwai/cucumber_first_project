package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

import java.util.List;

public class TechGlobalPaginationSteps {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalPaginationPage techGlobalPaginationPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
    }

    @When("user moves to Practices header dropdown")
    public void user_moves_to_header_dropdown() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();

    }

    @When("user clicks on {string} option")
    public void user_clicks_on_header_dropdown_option(String option) {
        switch (option) {
            case "Frontend Testing":
                techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
                break;
            case "Pagination":
                techGlobalFrontendTestingHomePage.clickOnCard(option);
                break;
            default:
                throw new NotFoundException();
        }
    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());

    }

    @Then("user should see {string} heading")
    public void user_should_see_heading(String heading) {
        switch (heading) {
            case "Pagination":
                Assert.assertEquals(heading, techGlobalPaginationPage.mainHeading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, techGlobalPaginationPage.subHeading.getText());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @Then("user should see {string} paragraph")
    public void user_should_see_paragraph(String paragraph) {
        Assert.assertEquals(paragraph, techGlobalPaginationPage.paragraph.getText());
    }

    @And("user should see {string} button is disabled")
    public void userShouldSeeButtonIsDisabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertFalse(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} button is enabled")
    public void userShouldSeeButtonIsEnabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "Previous":
                techGlobalPaginationPage.previousButton.click();
                break;
            case "Next":
                techGlobalPaginationPage.nextButton.click();
                break;
            default:
                throw new NotFoundException();
        }
    }

    @When("user clicks on {string} button till it becomes disabled")
    public void userClicksOnButtonTillItBecomesDisabled(String nextButton) {

        while (techGlobalPaginationPage.nextButton.isEnabled()) {
            techGlobalPaginationPage.nextButton.click();
        }
    }

    @And("user should see {string} city with info below and an image")
    public void userShouldSeeTokyoCityWithInfoBelowAndAnImage(String string, DataTable dataTable) {
        List<String> expected = dataTable.asList();
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), techGlobalPaginationPage.cityInfo.get(i).getText());
            Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
        }
        if (techGlobalPaginationPage.nextButton.isEnabled())
            techGlobalPaginationPage.nextButton.click();
    }
}


