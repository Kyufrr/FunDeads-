package fr.fundeads.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {
			
			
			if(cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
				
				if(args.length == 0) {
					player.sendMessage("USAGE > /broadcast <message> !");
				}
			
				if(args.length >= 1) {
					
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + " ");
					}
					if(player.isOp()) {
					Bukkit.broadcastMessage("§f[ §cMessage§f ]e" + bc.toString());
					} else {
						Bukkit.broadcastMessage("§f[§e" + player.getName() + "§f]§e " + bc.toString());
					}
				}
				
			}
			
		}
		
		
		return false;
	} 
}
