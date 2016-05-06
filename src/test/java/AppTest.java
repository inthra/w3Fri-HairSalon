import org.sql2o.*; // This import is for DB support
import org.junit.*; // This import is for @Before and @After
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Hair Salon Database");
    assertThat(pageSource()).contains("Add a New Stylist");
    assertThat(pageSource()).contains("View Stylist List");
  }

  @Test
  public void stylistIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Stylist"));
    fill("#input-stylist-name").with("Cherie");
    submit(".btn");
    assertThat(pageSource()).contains("Your stylist has been saved.");
  }

  @Test
  public void stylistIsDisplayedTest() {
    goTo("http://localhost:4567/stylists/new");
    fill("#input-stylist-name").with("Cherie");
    submit(".btn");
    click("a", withText("View Stylists"));
    assertThat(pageSource()).contains("Cherie");
  }

  @Test
  public void stylistShowPageDisplaysStylistName() {
    goTo("http://localhost:4567/stylists/new");
    fill("#input-stylist-name").with("Cherie");
    submit(".btn");
    click("a", withText("View Stylists"));
    click("a", withText("Cherie"));
    assertThat(pageSource()).contains("Cherie");
  }

  @Test
  public void stylistUpdate() {
    Stylist testStylist = new Stylist("Cherie");
    testStylist.save();
    String stylistPath = String.format("http://localhost:4567/stylists/%d", testStylist.getId());
    goTo(stylistPath);
    fill("#update-stylist-name").with("Cherie Brown");
    submit("#update-stylist");
    assertThat(pageSource()).contains("Cherie Brown");
  }

  @Test
  public void stylistDelete() {
    Stylist testStylist = new Stylist("Cherie");
    testStylist.save();
    String stylistPath = String.format("http://localhost:4567/stylists/%d", testStylist.getId());
    goTo(stylistPath);
    submit("#delete-stylist");
    assertEquals(0, Stylist.all().size());
    assertThat(pageSource()).contains("Your stylist has been deleted.");
  }

  @Test
  public void stylistClientsFormIsDisplayed() {
    goTo("http://localhost:4567/stylists/new");
    fill("#input-stylist-name").with("Cherie");
    submit(".btn");
    click("a", withText("View Stylists"));
    click("a", withText("Cherie"));
    click("a", withText("Add a New Client"));
    assertThat(pageSource()).contains("Add a client to Cherie");
  }

//   @Test
//   public void clientsIsAddedAndDisplayed() {
//     goTo("http://localhost:4567/stylists/new");
//     fill("#input-stylist-name").with("Cherie");
//     submit(".btn");
//     click("a", withText("View stylists"));
//     click("a", withText("Cherie"));
//     click("a", withText("Add a new client"));
//     fill("#client_name").with("Pit Cherie");
//     fill("#client_description").with("Tasty smoke");
//     submit(".btn");
//     click("a", withText("View stylists"));
//     click("a", withText("Cherie"));
//     assertThat(pageSource()).contains("Pit Cherie");
//     assertThat(pageSource()).contains("Tasty smoke");
//   }
//
//   @Test
//   public void clientUpdate() {
//     Stylist testStylist = new Stylist("Cherie");
//     testStylist.save();
//     Client testClient = new Client("Pit Cherie", "Tasty smoke", testStylist.getId());
//     testClient.save();
//     String clientPath = String.format("http://localhost:4567/stylists/%d/clients/%d", testStylist.getId(), testClient.getId());
//     goTo(clientPath);
//     fill("#client_name").with("Pit Cherie 2");
//     fill("#client_description").with("Real smokey");
//     submit("#update-client");
//     assertThat(pageSource()).contains("Pit Cherie 2");
//   }
}
