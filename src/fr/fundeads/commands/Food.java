package fr.fundeads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Food implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("food") || cmd.getName().equalsIgnoreCase("f")) {
				player.setFoodLevel(20);
				player.sendMessage("§e[FunDeads]§a Votre Nourriture à été remis à fond !");
			}
		}
		return false;
	}

}
