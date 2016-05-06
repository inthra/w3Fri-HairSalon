import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class Stylist {
  private int id;
  private String name;

  public Stylist(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Stylist> all() {
    String sql = "SELECT * FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

//   public List<Restaurant> getRestaurants() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM restaurants where cuisine_id=:id";
//       return con.createQuery(sql)
//         .addParameter("id", this.id)
//         .executeAndFetch(Restaurant.class);
//     }
//   }
//
//   public void update(String name) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "UPDATE stylists SET name = :name WHERE id=:id";
//       con.createQuery(sql)
//         .addParameter("name", name)
//         .addParameter("id", id)
//         .executeUpdate();
//     }
//   }
//
//   public void delete() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM stylists WHERE id=:id";
//       con.createQuery(sql)
//         .addParameter("id", id)
//         .executeUpdate();
//     }
//   }
}
