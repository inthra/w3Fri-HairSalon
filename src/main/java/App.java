import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

//     get("/stylists/new", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/stylist-form.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylists", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       String stylist_type = request.queryParams("stylist_type");
//       Cuisine newCuisine = new Cuisine(stylist_type);
//       newCuisine.save();
//       model.put("template", "templates/stylist-success.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/stylists", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("stylists", Cuisine.all());
//       model.put("template", "templates/stylists.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylists/:id", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Cuisine stylist = Cuisine.find(Integer.parseInt(request.params("id")));
//       String stylist_type = request.queryParams("stylist_type");
//       stylist.update(stylist_type);
//       String url = String.format("/stylists/%d", stylist.getId());
//       response.redirect(url);
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylists/:id/delete", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Cuisine stylist = Cuisine.find(Integer.parseInt(request.params("id")));
//       stylist.delete();
//       model.put("template", "templates/stylist-delete-success.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/stylists/:id", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Cuisine stylist = Cuisine.find(Integer.parseInt(request.params(":id")));
//       model.put("stylist", stylist);
//       model.put("template", "templates/stylist.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("stylists/:id/restaurants/new", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Cuisine stylist = Cuisine.find(Integer.parseInt(request.params(":id")));
//       model.put("stylist", stylist);
//       model.put("template", "templates/stylist-restaurants-form.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/restaurants", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Cuisine stylist = Cuisine.find(Integer.parseInt(request.queryParams("stylist_id")));
//       String restaurant_name = request.queryParams("restaurant_name");
//       String restaurant_description = request.queryParams("restaurant_description");
//       Restaurant newRestaurant = new Restaurant(restaurant_name, restaurant_description, stylist.getId());
//       newRestaurant.save();
//       model.put("stylist", stylist);
//       model.put("template", "templates/stylist-restaurants-success.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/restaurants", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("restaurants", Restaurant.all());
//       model.put("template", "templates/restaurant.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylists/:stylist_id/restaurants/:id", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Restaurant restaurant = Restaurant.find(Integer.parseInt(request.params("id")));
//       String restaurant_name = request.queryParams("restaurant_name");
//       String restaurant_description = request.queryParams("restaurant_description");
//       Cuisine stylist = Cuisine.find(restaurant.getCuisineId());
//       restaurant.update(restaurant_name, restaurant_description);
//       String url = String.format("/stylists/%d/restaurants/%d", stylist.getId(), restaurant.getId());
//       response.redirect(url);
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/stylists/:stylist_id/restaurants/:id", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Restaurant restaurant = Restaurant.find(Integer.parseInt(request.params(":id")));
//       model.put("restaurant", restaurant);
//       model.put("template", "templates/restaurant.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
  }
}
