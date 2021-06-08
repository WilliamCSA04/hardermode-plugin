package me.hardermode.configuration;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.KnowledgeBookMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    System.out.println("[hardermode] - Changing Recipes");
    removeRecipes();
    addRecipes();
    System.out.println("[hardermode] - Finished recipes customization");
    System.out.println("[hardermode] - Ending configuration");
  }

  private void addRecipes() {
    ItemStack book = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
    KnowledgeBookMeta recipeBook = (KnowledgeBookMeta) book.getItemMeta();
    Recipe enchantedGoldenApple = goldenAppleRecipe();
    Recipe conduit = conduitRecipe();
    Recipe chest = chestRecipe();
    addRecipe(enchantedGoldenApple, Material.ENCHANTED_GOLDEN_APPLE, recipeBook);
    addRecipe(conduit, Material.CONDUIT, recipeBook);
    addRecipe(chest, Material.CHEST, recipeBook);
  }

  private void addRecipe(Recipe recipe, Material material, KnowledgeBookMeta recipeBook) {
    if(Bukkit.addRecipe(recipe)) {
      NamespacedKey materialKey = material.getKey();
      if(recipeBook != null) {
        recipeBook.addRecipe(materialKey);
      }
      System.out.println("[hardermode] - Added recipe: " + materialKey);
    }
  }

  private ShapedRecipe goldenAppleRecipe() {
    Material enchantedGoldenAppleMaterial = Material.ENCHANTED_GOLDEN_APPLE;
    NamespacedKey enchantedGoldenAppleKey = enchantedGoldenAppleMaterial.getKey();
    ItemStack enchantedGoldenApple = new ItemStack(enchantedGoldenAppleMaterial);
    ShapedRecipe recipe = new ShapedRecipe(enchantedGoldenAppleKey, enchantedGoldenApple);
    recipe.shape("EEE", "NGN", "LLL");
    recipe.setIngredient('E', Material.EMERALD_BLOCK);
    recipe.setIngredient('N', Material.NETHER_STAR);
    recipe.setIngredient('L', Material.LAPIS_BLOCK);
    recipe.setIngredient('G', Material.GOLDEN_APPLE);
    return recipe;
  }

  private ShapedRecipe conduitRecipe() {
    Material conduitMaterial = Material.CONDUIT;
    NamespacedKey conduitKey = conduitMaterial.getKey();
    ItemStack conduit = new ItemStack(conduitMaterial);
    ShapedRecipe recipe = new ShapedRecipe(conduitKey, conduit);
    recipe.shape("NNN", "HHH", "NNN");
    recipe.setIngredient('H', Material.HEART_OF_THE_SEA);
    recipe.setIngredient('N', Material.NAUTILUS_SHELL);
    return recipe;
  }

  private ShapedRecipe chestRecipe() {
    Material material = Material.CHEST;
    NamespacedKey conduitKey = material.getKey();
    ItemStack chest = new ItemStack(material);
    ShapedRecipe recipe = new ShapedRecipe(conduitKey, chest);
    recipe.shape("WWW", "WIW", "WWW");
    List<Material> materials = new ArrayList<>();
    materials.add(Material.ACACIA_PLANKS);
    materials.add(Material.BIRCH_PLANKS);
    materials.add(Material.OAK_PLANKS);
    materials.add(Material.SPRUCE_PLANKS);
    materials.add(Material.DARK_OAK_PLANKS);
    materials.add(Material.JUNGLE_PLANKS);
    materials.add(Material.WARPED_PLANKS);
    materials.add(Material.CRIMSON_PLANKS);
    RecipeChoice planks = new RecipeChoice.MaterialChoice(materials);
    recipe.setIngredient('W', planks)
            .setIngredient('I', Material.IRON_NUGGET);
    return recipe;
  }

  private void removeRecipes() {
    Iterator<Recipe> recipes = server.recipeIterator();
    while(recipes.hasNext()) {
      Material material =  recipes.next().getResult().getType();
      if (material == Material.ENDER_EYE) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.CONDUIT) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.CHEST) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      }
    }
  }

}
