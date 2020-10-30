package fr.fundeads.main;


import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import fr.fundeads.commands.Back;
import fr.fundeads.commands.Broadcast;
import fr.fundeads.commands.Food;
import fr.fundeads.commands.GameMode;
import fr.fundeads.commands.Heal;
import fr.fundeads.commands.Heure;
import fr.fundeads.commands.Home;
import fr.fundeads.commands.Menu;
import fr.fundeads.commands.SetSpawn;
import fr.fundeads.commands.Spawn;

public class Main extends JavaPlugin implements Listener {
	
	public static HashMap<String, Location> back = new HashMap<>();
	
	public static Main instance;
	
	public static Main getInstance() {
		return instance;
		
	}
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		instance = this;
		
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
		getCommand("back").setExecutor(new Back());
		getCommand("home").setExecutor(new Home());
		getCommand("sethome").setExecutor(new Home());
		getCommand("delhome").setExecutor(new Home());
		recipeSaddle();
		getServer().getPluginManager().registerEvents(new MainListener(this), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[FunDeads] The Plugin has been Disabled");
	}
	  
	
	private void recipeSaddle() {
		ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
		
		ShapedRecipe obsi = new ShapedRecipe(obsidian);
		
		obsi.shape("SSS","SIS","SSS");
		obsi.setIngredient('S', Material.STONE);
		obsi.setIngredient('I', Material.DIAMOND);
		
		getServer().addRecipe(obsi);
		
		ItemStack cookie = new ItemStack(Material.COOKIE);
		
		ShapedRecipe cookiee = new ShapedRecipe(cookie);
		
		cookiee.shape("LLL","SSS","III");
		cookiee.setIngredient('L', Material.SEEDS);
		cookiee.setIngredient('S', Material.MILK_BUCKET);
		cookiee.setIngredient('I', Material.WHEAT);
		
		getServer().addRecipe(cookiee);
	}
}


// L L L
// S S S = Obsidian
// S I S