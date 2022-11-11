package de.itagile;

import de.itagile.pages.KanbanUniversity;
import de.itagile.pages.WebBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TestStepDefs {
    private WebBrowser browser;
    private KanbanUniversity kanbanUniversity;

    @Before
    public void setUp() {
        browser = new WebBrowser();
    }

    @After
    public void tearDown() {
        browser.quit();
    }
    @Given("^Navigate to Kanban University Website$")
    public void navigateToKanbanUniversityWebsite() {
        kanbanUniversity = new KanbanUniversity(browser.getDriver());
    }

    @When("I login")
    public void login() {
        if (kanbanUniversity != null) {
            kanbanUniversity.login();
        }
    }
}
