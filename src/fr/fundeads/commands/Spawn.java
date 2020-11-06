package fr.fundeads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase("spawn")) {
					
			player.sendMessage("§e[FunDeads]§aYou have been teleported to Spawn !");
			player.teleport(player.getWorld().getSpawnLocation());
		}
		}
		return false;
	}

}
