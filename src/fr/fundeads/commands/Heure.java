package fr.fundeads.commands;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heure implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		Date d = new Date();
		
		Player player = (Player) sender;
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("heure")) {
			player.sendMessage("§e[FunDeads] The Time Is §a" + format.format(d));
			}
		}
			
		return false;
	}

}
