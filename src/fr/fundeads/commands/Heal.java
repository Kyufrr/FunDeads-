package fr.fundeads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("heal") || cmd.getName().equalsIgnoreCase("h")) {
				player.setHealth(20);
				player.setFoodLevel(20);
				player.setFireTicks(0);
				player.sendMessage("§e[FunDeads]§a You have been heal !");
			}
		}
		return false;
	}

}
