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

  private Recipe getRecipeFromMaterial(Material material) {
    NamespacedKey materialKey = material.getKey();
    ItemStack item = new ItemStack(material);
    return new ShapedRecipe(materialKey, item);
  }


  private void addRecipes() {
    ItemStack book = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
    KnowledgeBookMeta recipeBook = (KnowledgeBookMeta) book.getItemMeta();
    Recipe enchantedGoldenApple = goldenAppleRecipe();
    Recipe conduit = conduitRecipe();
    Recipe chest = chestRecipe();
    Recipe ironHelmet = ironHelmetRecipe();
    Recipe goldenHelmet = goldenHelmetRecipe();
    Recipe diamondHelmet = diamondHelmetRecipe();
    Recipe ironChestPlate = ironChestPlateRecipe();
    Recipe goldenChestPlate = goldenChestPlateRecipe();
    Recipe diamondChestPlate = diamondChestPlateRecipe();
    Recipe ironLeggings = ironLeggingsRecipe();
    Recipe goldenLeggings = goldenLeggingsRecipe();
    Recipe diamondLeggings = diamondLeggingsRecipe();
    Recipe ironBoots = ironBootsRecipe();
    Recipe goldenBoots = goldenBootsRecipe();
    Recipe diamondBoots = diamondBootsRecipe();
    addRecipe(enchantedGoldenApple, Material.ENCHANTED_GOLDEN_APPLE, recipeBook);
    addRecipe(conduit, Material.CONDUIT, recipeBook);
    addRecipe(chest, Material.CHEST, recipeBook);
    addRecipe(ironHelmet, Material.IRON_HELMET, recipeBook);
    addRecipe(goldenHelmet, Material.GOLDEN_HELMET, recipeBook);
    addRecipe(diamondHelmet, Material.DIAMOND_HELMET, recipeBook);
    addRecipe(ironChestPlate, Material.IRON_CHESTPLATE, recipeBook);
    addRecipe(goldenChestPlate, Material.GOLDEN_CHESTPLATE, recipeBook);
    addRecipe(diamondChestPlate, Material.DIAMOND_CHESTPLATE, recipeBook);
    addRecipe(ironLeggings, Material.IRON_LEGGINGS, recipeBook);
    addRecipe(goldenLeggings, Material.GOLDEN_LEGGINGS, recipeBook);
    addRecipe(diamondLeggings, Material.DIAMOND_LEGGINGS, recipeBook);
    addRecipe(ironBoots, Material.IRON_BOOTS, recipeBook);
    addRecipe(goldenBoots, Material.GOLDEN_BOOTS, recipeBook);
    addRecipe(diamondBoots, Material.DIAMOND_BOOTS, recipeBook);
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

  private ShapedRecipe ironChestPlateRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.IRON_CHESTPLATE);
    recipe.shape("ICI", "III", "III");
    recipe.setIngredient('C', Material.LEATHER_CHESTPLATE);
    recipe.setIngredient('I', Material.IRON_INGOT);
    return recipe;
  }

  private ShapedRecipe goldenChestPlateRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.GOLDEN_CHESTPLATE);
    recipe.shape("ICI", "III", "III");
    recipe.setIngredient('C', Material.LEATHER_CHESTPLATE);
    recipe.setIngredient('I', Material.GOLD_INGOT);
    return recipe;
  }

  private ShapedRecipe diamondChestPlateRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.DIAMOND_CHESTPLATE);
    recipe.shape("ICI", "III", "III");
    recipe.setIngredient('C', Material.LEATHER_CHESTPLATE);
    recipe.setIngredient('I', Material.DIAMOND);
    return recipe;
  }

  private ShapedRecipe ironLeggingsRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.IRON_LEGGINGS);
    recipe.shape("III", "ICI", "I I");
    recipe.setIngredient('C', Material.LEATHER_LEGGINGS);
    recipe.setIngredient('I', Material.IRON_INGOT);
    return recipe;
  }

  private ShapedRecipe goldenLeggingsRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.GOLDEN_LEGGINGS);
    recipe.shape("III", "ICI", "I I");
    recipe.setIngredient('C', Material.LEATHER_LEGGINGS);
    recipe.setIngredient('I', Material.GOLD_INGOT);
    return recipe;
  }

  private ShapedRecipe diamondLeggingsRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.DIAMOND_LEGGINGS);
    recipe.shape("III", "ICI", "I I");
    recipe.setIngredient('C', Material.LEATHER_LEGGINGS);
    recipe.setIngredient('I', Material.DIAMOND);
    return recipe;
  }

  private ShapedRecipe ironHelmetRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.IRON_HELMET);
    recipe.shape("III", "ICI", "  ");
    recipe.setIngredient('C', Material.LEATHER_HELMET);
    recipe.setIngredient('I', Material.IRON_INGOT);
    return recipe;
  }

  private ShapedRecipe goldenHelmetRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.GOLDEN_HELMET);
    recipe.shape("III", "ICI", "  ");
    recipe.setIngredient('C', Material.LEATHER_HELMET);
    recipe.setIngredient('I', Material.GOLD_INGOT);
    return recipe;
  }

  private ShapedRecipe diamondHelmetRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.DIAMOND_HELMET);
    recipe.shape("III", "ICI", "  ");
    recipe.setIngredient('C', Material.LEATHER_HELMET);
    recipe.setIngredient('I', Material.DIAMOND);
    return recipe;
  }

  private ShapedRecipe ironBootsRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.IRON_BOOTS);
    recipe.shape("  ", "ICI", "I I");
    recipe.setIngredient('C', Material.LEATHER_BOOTS);
    recipe.setIngredient('I', Material.IRON_INGOT);
    return recipe;
  }

  private ShapedRecipe goldenBootsRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.GOLDEN_BOOTS);
    recipe.shape("  ", "ICI", "I I");
    recipe.setIngredient('C', Material.LEATHER_BOOTS);
    recipe.setIngredient('I', Material.GOLD_INGOT);
    return recipe;
  }

  private ShapedRecipe diamondBootsRecipe() {
    ShapedRecipe recipe = (ShapedRecipe) getRecipeFromMaterial(Material.DIAMOND_BOOTS);
    recipe.shape("  ", "ICI", "I I");
    recipe.setIngredient('C', Material.LEATHER_BOOTS);
    recipe.setIngredient('I', Material.DIAMOND);
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
      } else if (material == Material.IRON_CHESTPLATE) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.IRON_HELMET) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.IRON_BOOTS) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.IRON_LEGGINGS) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.GOLDEN_CHESTPLATE) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.GOLDEN_HELMET) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.GOLDEN_BOOTS) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.GOLDEN_LEGGINGS) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.DIAMOND_CHESTPLATE) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.DIAMOND_HELMET) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.DIAMOND_BOOTS) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      } else if (material == Material.DIAMOND_LEGGINGS) {
        System.out.println("[hardermode] - Removing recipe: " + material.getKey());
        recipes.remove();
      }
    }
  }

}
