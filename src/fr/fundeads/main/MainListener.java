package fr.fundeads.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.fundeads.commands.Vanish;

public class MainListener implements Listener {
	
	private Main main;

	public MainListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void OnDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		
		Main.back.put(player.getName(), player.getLocation());
	}
	
	
	
	@EventHandler
	public void OnRespawn(PlayerRespawnEvent event) {
		
		Player player = event.getPlayer();
		
		ItemStack boussole = new ItemStack(Material.COMPASS, 1);
		ItemMeta boussoleM = boussole.getItemMeta();
		boussoleM.setDisplayName("§c[Menu]");
		boussoleM.setLore(Arrays.asList("§aCan help you."));
		boussoleM.addEnchant(Enchantment.DURABILITY, 200, true);
		boussoleM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		boussole.setItemMeta(boussoleM);
		
		if(player.isOp()) {
		player.getInventory().setItem(8, boussole);
		}
		
	}
	
	@EventHandler
	public void OnJoin(PlayerJoinEvent event) {
		
		// Envoie d'un Message de Bienvenue à la connexion
		DateFormat format = new SimpleDateFormat("HH:mm");
		Date d = new Date();
		
		Player player = event.getPlayer();
		
		
		if(player.hasPermission("fundeads.*")) {
			player.sendMessage("§e[FunDeads] §cHello Master ! The Time is §a" + format.format(d));
		}
		
		// [Vanish]
		for(Player p : Vanish.vanished) {
			p.hidePlayer(p);
		}
		
		// Retour Au Spawn à la connexion
		player.teleport(player.getWorld().getSpawnLocation());
		
		
		// Give De La boussole Admin
		ItemStack boussole = new ItemStack(Material.COMPASS, 1);
		ItemMeta boussoleM = boussole.getItemMeta();
		boussoleM.setDisplayName("§c[Menu]");
		boussoleM.setLore(Arrays.asList("§aCan help you."));
		boussoleM.addEnchant(Enchantment.DURABILITY, 200, true);
		boussoleM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		boussole.setItemMeta(boussoleM);
		
		if(player.isOp()) {
		player.getInventory().setItem(8, boussole);
		}
	}
	
	@EventHandler
	public void OnInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it == null) return;
				
		if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§c[Menu]")) {
			
			if(player.isOp()) {
			if(action == Action.RIGHT_CLICK_AIR) {
				player.sendMessage("§c[Menu Admin FunDeads] Hello !");
			}
			}
			
			Inventory inv = Bukkit.createInventory(null, 18, "§c[Menu]");
			
			ItemStack beacon = new ItemStack(Material.BEACON, 1);
			ItemMeta BeaconM = beacon.getItemMeta();
			BeaconM.setDisplayName("§aSend §fAn Message §cMaintenance.");
			beacon.setItemMeta(BeaconM);
			
			ItemStack anvil = new ItemStack(Material.ANVIL, 1);
			ItemMeta anvilM = anvil.getItemMeta();
			anvilM.setDisplayName("§8Activate §cThe §eWhitelist.");
			anvil.setItemMeta(anvilM);
			
			ItemStack feather = new ItemStack(Material.FEATHER, 1);
			ItemMeta featherM = feather.getItemMeta();
			featherM.setDisplayName("§9Désactivate §fThe §4Whitelist.");
			feather.setItemMeta(featherM);
			
			ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1);
			ItemMeta lavaM = lava.getItemMeta();
			lavaM.setDisplayName("§cSTOP THE SERVER !");
			lavaM.addEnchant(Enchantment.DURABILITY, 200, true);
			lavaM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			lava.setItemMeta(lavaM);

			ItemStack rl = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
			ItemMeta rlM = rl.getItemMeta();
			rlM.setDisplayName("§aReload");
			rlM.setLore(Arrays.asList("§l§4 (Probable Risk of Stopping [Cause: Plugins overload]!)"));
			rl.setItemMeta(rlM);
			
			
			ItemStack gm1 = new ItemStack(Material.WOOD_SWORD, 1);
			ItemMeta gm1M = gm1.getItemMeta();
			gm1M.setDisplayName("§aGamemode 1 (créative) !");
			gm1.setItemMeta(gm1M);
			
			ItemStack gm2 = new ItemStack(Material.STONE_SWORD, 1);
			ItemMeta gm2M = gm2.getItemMeta();
			gm2M.setDisplayName("§aGamemode 2 (aventure) !");
			gm2.setItemMeta(gm2M);
			
			ItemStack gm3 = new ItemStack(Material.GOLD_SWORD, 1);
			ItemMeta gm3M = gm3.getItemMeta();
			gm3M.setDisplayName("§aGamemode 3 (spectateur) !");
			gm3.setItemMeta(gm3M);
			
			ItemStack gm0 = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta gm0M = gm0.getItemMeta();
			gm0M.setDisplayName("§aGamemode 0 (survie) !");
			gm0.setItemMeta(gm0M);
			
			inv.setItem(8, beacon);
			inv.setItem(0, anvil);
			inv.setItem(1, feather);
			inv.setItem(2, rl);
			inv.setItem(3, lava);
			inv.setItem(4, gm1);
			inv.setItem(5, gm2);
			inv.setItem(6, gm3);
			inv.setItem(7, gm0);
			
			if(player.isOp()) {
			player.openInventory(inv);
			} else {
				player.sendMessage("§cFailure and Maths :/ (Access denied !)");
				System.out.println("[FunDeads] " + player.getName() + " as try to open the menu admin !");
			}
		}

	}
	
	@EventHandler
	public void OnClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current == null) return;
		
		if(inv.getName().equalsIgnoreCase("§c[Menu]")) {
			
			event.setCancelled(true);
			
			
			if(player.isOp()) {
			if(current.getType() == Material.BEACON) {
				player.closeInventory();
				Bukkit.broadcastMessage(main.getConfig().getString("menu.annonces.maintenance"));
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.ANVIL) {
				player.closeInventory();
				player.sendMessage("§aThe Whitelist as Activated !");
				Bukkit.setWhitelist(true);
				Bukkit.reloadWhitelist();
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.FEATHER) {
				player.closeInventory();
				player.sendMessage("§cThe Whitelist as Désactivated !");
				Bukkit.setWhitelist(false);
				Bukkit.reloadWhitelist();
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.LAVA_BUCKET) {
				player.closeInventory();
				Bukkit.broadcastMessage("Emergency shutdown of the server by " + player.getName());
				Bukkit.shutdown();
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.WOOD_SWORD) {
				player.closeInventory();
				player.sendMessage("§9Switching to Creative Gamemode !");
				player.setGameMode(GameMode.CREATIVE);
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.STONE_SWORD) {
				player.closeInventory();
				player.sendMessage("§9Switching to Adventure Gamemode !");
				player.setGameMode(GameMode.ADVENTURE);
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.GOLD_SWORD) {
				player.closeInventory();
				player.sendMessage("§9Switching to Spectator Gamemode !");
				player.setGameMode(GameMode.SPECTATOR);
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.DIAMOND_SWORD) {
				player.closeInventory();
				player.sendMessage("§9Switching to Survival Gamemode !");
				player.setGameMode(GameMode.SURVIVAL);
			}
			}
			
			if(player.isOp()) {
			if(current.getType() == Material.REDSTONE_COMPARATOR) {
				player.closeInventory();
				Bukkit.broadcastMessage("§9Reload !");
				Bukkit.reload();
			}
			}
			
			if(current.getType() == Material.WOOD_STAIRS) {
				player.closeInventory();
				player.sendMessage("§l§aHELLO !");
			}
			
		}
		
	}

	public ItemStack getItem(Material material, String customName) {
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		if(customName != null) itM.setDisplayName(customName);
		return it;
	}
	
}
