import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/story", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
    model.put("person1", request.queryParams("person1"));
    model.put("person2", request.queryParams("person2"));
    model.put("animal", request.queryParams("animal"));
    model.put("exclamation", request.queryParams("exclamation"));
    model.put("verb", request.queryParams("verb"));
    model.put("noun", request.queryParams("noun"));
    model.put("template", "templates/story.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
  }
}
