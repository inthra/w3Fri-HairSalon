import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class Client {
  private int id;
  private String name;
  private int stylist_id;

  public Client(String name, int stylist_id) {
    this.name = name;
    this.stylist_id = stylist_id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylist_id;
  }

  public static List<Client> all() {
    String sql = "SELECT * FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName());
    }
  }

  public void save(){
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, stylist_id) VALUES (:name, :stylist_id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name" , this.name)
        .addParameter("stylist_id", this.stylist_id)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void update(String name) {
    if (name != null) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE clients SET name = :update_name WHERE id=:id";
        con.createQuery(sql)
          .addParameter("update_name", name)
          .addParameter("id", this.getId())
          .executeUpdate();
      }
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id=:id";
      con.createQuery(sql)
        .addParameter("id", this.getId())
        .executeUpdate();
    }
  }
}
