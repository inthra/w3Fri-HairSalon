import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Gretchen", 1);
    assertTrue(testClient instanceof Client);
  }

  // @Test
  // public void getName_instantiatesWithName_String() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   assertEquals("Pit BBQ", testClient.getName());
  // }
  //
  // @Test
  // public void getDescription_instantiatesWithDescription_String() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   assertEquals("Tasty smoke", testClient.getDescription());
  // }
  //
  // @Test
  // public void all_ClientListIsEmptyFirst() {
  //   assertEquals(Client.all().size(), 0);
  // }
  //
  // @Test
  // public void equals_returnsTrueIfNamesAreSame() {
  //   Client firstClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   Client secondClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   assertTrue(firstClient.equals(secondClient));
  // }
  //
  // @Test
  // public void save_savesIntoDatabase_true() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   testClient.save();
  //   assertTrue(Client.all().get(0).equals(testClient));
  // }
  //
  // @Test
  // public void save_assignsIdToObject() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   testClient.save();
  //   Client savedClient = Client.all().get(0);
  //   assertEquals(testClient.getId(), savedClient.getId());
  // }
  //
  // @Test
  // public void find_findClientInDatabase_true() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   testClient.save();
  //   Client savedClient = Client.find(testClient.getId());
  //   assertTrue(testClient.equals(savedClient));
  // }
  //
  // @Test
  // public void update_updatesClientNameAndDescription_true() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   testClient.save();
  //   testClient.update("Pit BBQ 2", "Real smokey");
  //   assertEquals("Pit BBQ 2", Client.find(testClient.getId()).getName());
  //   assertEquals("Real smokey", Client.find(testClient.getId()).getDescription());
  // }
  //
  // @Test
  // public void update_updatesClientNameOrDescription_true() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   testClient.save();
  //   testClient.update("Pit BBQ 2", null);
  //   assertEquals("Pit BBQ 2", Client.find(testClient.getId()).getName());
  //   assertEquals("Tasty smoke", Client.find(testClient.getId()).getDescription());
  // }
  //
  // @Test
  // public void delete_deletesClientNameAndDesctription_true() {
  //   Client testClient = new Client("Pit BBQ", "Tasty smoke", 1);
  //   testClient.save();
  //   int testClientId = testClient.getId();
  //   testClient.delete();
  //   assertEquals(null, Client.find(testClientId));
  // }
  //
}
