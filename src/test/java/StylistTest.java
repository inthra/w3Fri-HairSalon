import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Rachel");
    assertTrue(testStylist instanceof Stylist);
  }

  @Test
  public void Stylist_instantiatesWithStylistType_String() {
    Stylist testStylist = new Stylist("Rachel");
    assertEquals("Rachel", testStylist.getName());
  }

  @Test
  public void all_StylistListEmptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreSame() {
    Stylist firstStylist = new Stylist("Rachel");
    Stylist secondStylist = new Stylist("Rachel");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist testStylist = new Stylist("Rachel");
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist testStylist = new Stylist("Rachel");
    testStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(testStylist.getId(), savedStylist.getId());
  }

  // @Test
  // public void find_findStylistInDatabase_true() {
  //   Stylist testStylist = new Stylist("Rachel");
  //   testStylist.save();
  //   Stylist savedStylist = Stylist.find(testStylist.getId());
  //   assertTrue(testStylist.equals(savedStylist));
  // }
  //
  // @Test
  // public void getRestaurants_retrievesAllRestaurantsFromDatabase_restaurantsList() {
  //   Stylist testStylist = new Stylist("Rachel");
  //   testStylist.save();
  //   Restaurant firstRestaurant = new Restaurant("Pit Rachel", "Tasty smoke", testStylist.getId());
  //   firstRestaurant.save();
  //   Restaurant secondRestaurant = new Restaurant("Sticky Fingers", "Saucy sauce", testStylist.getId());
  //   secondRestaurant.save();
  //   Restaurant[] restaurants = new Restaurant[] { firstRestaurant, secondRestaurant };
  //   assertTrue(testStylist.getRestaurants().containsAll(Arrays.asList(restaurants)));
  // }
  //
  // @Test
  // public void update_updatesStylistType_true() {
  //   Stylist testStylist = new Stylist("Rachel");
  //   testStylist.save();
  //   testStylist.update("Texas Rachel");
  //   assertEquals("Texas Rachel", Stylist.find(testStylist.getId()).getName());
  // }
  //
  // @Test
  // public void delete_deletesStylistType_true() {
  //   Stylist testStylist = new Stylist("Rachel");
  //   testStylist.save();
  //   int testStylistId = testStylist.getId();
  //   testStylist.delete();
  //   assertEquals(null, Stylist.find(testStylistId));
  // }
}
