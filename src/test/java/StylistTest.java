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

  @Test
  public void find_findStylistInDatabase_true() {
    Stylist testStylist = new Stylist("Rachel");
    testStylist.save();
    Stylist savedStylist = Stylist.find(testStylist.getId());
    assertTrue(testStylist.equals(savedStylist));
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientList() {
    Stylist testStylist = new Stylist("Rachel");
    testStylist.save();
    Client firstClient = new Client("Taylor", testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Kate", testStylist.getId());
    secondClient.save();
    Client[] client = new Client[] { firstClient, secondClient };
    assertTrue(testStylist.getClients().containsAll(Arrays.asList(client)));
  }

  @Test
  public void update_updatesStylistName_true() {
    Stylist testStylist = new Stylist("Rachel");
    testStylist.save();
    testStylist.update("Rachel Brown");
    assertEquals("Rachel Brown", Stylist.find(testStylist.getId()).getName());
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist testStylist = new Stylist("Rachel");
    testStylist.save();
    int testStylistId = testStylist.getId();
    testStylist.delete();
    assertEquals(null, Stylist.find(testStylistId));
  }
}
