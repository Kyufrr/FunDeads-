package fr.fundeads.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.console.internal.ConsoleRunner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(sender instanceof ConsoleRunner) {
			sender.sendMessage("NOPE !");
		}
		if(sender instanceof Player) {
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("admin") || args[0].equalsIgnoreCase("guia")) {
				Inventory inv = Bukkit.createInventory(null, 18, "§c[Menu]");
				
				ItemStack beacon = new ItemStack(Material.BEACON, 1);
				ItemMeta BeaconM = beacon.getItemMeta();
				BeaconM.setDisplayName("§aAnnoncer §fUne §cMaintenance.");
				beacon.setItemMeta(BeaconM);
				
				ItemStack anvil = new ItemStack(Material.ANVIL, 1);
				ItemMeta anvilM = anvil.getItemMeta();
				anvilM.setDisplayName("§8Activer §cLa §eWhitelist.");
				anvil.setItemMeta(anvilM);
				
				ItemStack feather = new ItemStack(Material.FEATHER, 1);
				ItemMeta featherM = feather.getItemMeta();
				featherM.setDisplayName("§9Désactiver §fLa §4Whitelist.");
				feather.setItemMeta(featherM);
				
				ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1);
				ItemMeta lavaM = lava.getItemMeta();
				lavaM.setDisplayName("§cArrêt D'Urgence Du SERVEUR !");
				lavaM.addEnchant(Enchantment.DURABILITY, 200, true);
				lavaM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				lava.setItemMeta(lavaM);

				ItemStack rl = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
				ItemMeta rlM = rl.getItemMeta();
				rlM.setDisplayName("§aReload");
				rlM.setLore(Arrays.asList("§l§4(Risque Probable D'Arrêt [Cause : Plusieurs Plugins à Recharger] !)"));
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
				
				if(player.hasPermission("fundeads.menu.op")) {
				player.openInventory(inv);
				} else {
					player.sendMessage("§cInacessible !");
				}
				
			}
			
			if(args[0].equalsIgnoreCase("joueur") || args[0].equalsIgnoreCase("gui")) {
				
			Inventory inv = Bukkit.createInventory(null, 18, "§c[Menu]");
			
			
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
			
			inv.setItem(0, gm1);
			inv.setItem(1, gm2);
			inv.setItem(2, gm3);
			inv.setItem(3, gm0);
			
			player.openInventory(inv);
			}
		  }
		}
		
		if(args.length == 0) {
			player.sendMessage("§cUSAGE > /menu <guia/gui>");
		}
		
		if(args.length >= 2) {
			player.sendMessage("§cUSAGE > /menu <guia/gui>");
		}
		
		return false;
	}
}
	
