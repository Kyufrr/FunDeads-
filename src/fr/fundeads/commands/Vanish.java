package fr.fundeads.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

	public static ArrayList<Player> vanished = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(vanished.contains(p)) {
				
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.showPlayer(p);
				}
				
				//unvanish
				vanished.remove(p);
				p.sendMessage("§aYou have Been UnVanished");
				
			} else {
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.hidePlayer(p);
				}
				vanished.add(p);
				p.sendMessage("§aYou have Been Vanished");
			}
			
			return true;
		}
		return false;
	}

}
