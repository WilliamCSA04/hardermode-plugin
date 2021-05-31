package me.hardermode.configuration;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

public class Configuration {

  private static Configuration configuration = null;
  private Server server = null;

  private Configuration(Server server) {
    this.server = server;
  }

  public static Configuration startConfiguration(Server server) {
    if(configuration == null) {
      configuration = new Configuration(server);
    }
    return configuration;
  }

  public void configure() {
    System.out.println("[hardermode] - Starting configuration");
    removeRecipes();
    System.out.println("[hardermode] - Ending configuration");
  }

  private void removeRecipes() {
    Iterator<Recipe> recipes = server.recipeIterator();
    while(recipes.hasNext()) {
      if (recipes.next().getResult().getType() == Material.ENDER_EYE) {
        System.out.println("[hardermode] - Removing recipe: " + Material.ENDER_EYE.getKey());
        recipes.remove();
      }
    }
  }

}
