package fr.fundeads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.fundeads.main.Main;

public class Back implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args.length >= 1) {
			
			p.sendMessage("§cError !");
			
		} else {
			if(Main.back.containsKey(p.getName())) {
				
				p.sendMessage("§aTéléportation Confirmé !");
				p.teleport(Main.back.get(p.getName()));
				
				Main.back.remove(p.getName(), p.getLocation());
			} else {
				p.sendMessage("§cVous n'êtes jamais mort !");
			}
		}
		
		return false;
	}

}
