package fr.fundeads.main;


import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import fr.fundeads.commands.Broadcast;
import fr.fundeads.commands.Food;
import fr.fundeads.commands.GameMode;
import fr.fundeads.commands.Heal;
import fr.fundeads.commands.Heure;
import fr.fundeads.commands.Menu;
import fr.fundeads.commands.SetSpawn;
import fr.fundeads.commands.Spawn;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		System.out.println("[FunDeads] The Plugin has been Enabled");
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("bc").setExecutor(new Broadcast());
		getCommand("menu").setExecutor(new Menu());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("heure").setExecutor(new Heure());
		getCommand("gm").setExecutor(new GameMode());
		getCommand("food").setExecutor(new Food());
		getCommand("f").setExecutor(new Food());
		getCommand("heal").setExecutor(new Heal());
		getCommand("h").setExecutor(new Heal());
		recipeSaddle();
		getServer().getPluginManager().registerEvents(new MainListener(this), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[FunDeads] The Plugin has been Disabled");
	}
	
	private void recipeSaddle() {
		ItemStack saddle = new ItemStack(Material.OBSIDIAN);
		
		ShapedRecipe recipe = new ShapedRecipe(saddle);
		
		recipe.shape("LLL","SIS","SSS");
		recipe.setIngredient('L', Material.STONE);
		recipe.setIngredient('S', Material.STONE);
		recipe.setIngredient('I', Material.DIAMOND);
		
		getServer().addRecipe(recipe);
		
		ItemStack cookie = new ItemStack(Material.COOKIE);
		
		ShapedRecipe recipe1 = new ShapedRecipe(cookie);
		
		recipe1.shape("LLL","SSS","III");
		recipe1.setIngredient('L', Material.SEEDS);
		recipe1.setIngredient('S', Material.MILK_BUCKET);
		recipe1.setIngredient('I', Material.BREAD);
		
		getServer().addRecipe(recipe1);
	}
}


// L L L
// S S S = Sadlle
// S I S