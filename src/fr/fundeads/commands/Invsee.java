package fr.fundeads.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;

public class Invsee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player targetPlayer = Bukkit.getServer().getPlayer(args[0]); //something like that, I don't know if that is exact
		Player player = (Player) sender;
		Inventory targetInv = targetPlayer.getInventory();
		player.openInventory(targetInv);
		
		player.sendMessage(ChatColor.GOLD +"You have opened invsee of " + targetPlayer );
		
		return false;
	}

}
