import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class Stylist {
  private int id;
  private String name;

  public Stylist(String name) {
    this.name = name;
  }
//
//   public String getType() {
//     return name;
//   }
//
//   public int getId() {
//     return id;
//   }
//
//   public static List<Stylist> all() {
//     String sql = "SELECT id, name FROM cuisines";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Stylist.class);
//     }
//   }
//
//   @Override
//   public boolean equals(Object otherStylist) {
//     if (!(otherStylist instanceof Stylist)) {
//       return false;
//     } else {
//       Stylist newStylist = (Stylist) otherStylist;
//       return this.getType().equals(newStylist.getType());
//     }
//   }
//
//   public void save() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "INSERT INTO cuisines(name) VALUES (:name)";
//       this.id = (int) con.createQuery(sql, true)
//         .addParameter("name", this.name)
//         .executeUpdate()
//         .getKey();
//     }
//   }
//
//   public static Stylist find(int id) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM cuisines WHERE id=:id";
//       Stylist cuisine = con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetchFirst(Stylist.class);
//       return cuisine;
//     }
//   }
//
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
//       String sql = "UPDATE cuisines SET name = :name WHERE id=:id";
//       con.createQuery(sql)
//         .addParameter("name", name)
//         .addParameter("id", id)
//         .executeUpdate();
//     }
//   }
//
//   public void delete() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM cuisines WHERE id=:id";
//       con.createQuery(sql)
//         .addParameter("id", id)
//         .executeUpdate();
//     }
//   }
}
