package fr.fundeads.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameMode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("fundeads.gm")) {
				if(args.length == 1) {
					
					if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
						p.sendMessage("§e[FunDeads] §9Passage En Mode Survie !");
						p.setGameMode(org.bukkit.GameMode.SURVIVAL);
					} else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
						p.sendMessage("§e[FunDeads] §9Passage En Mode Creative !");
						p.setGameMode(org.bukkit.GameMode.CREATIVE);
					} else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
						p.sendMessage("§e[FunDeads] §9Passage En Mode Aventure !");
						p.setGameMode(org.bukkit.GameMode.ADVENTURE);
					} else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
						p.sendMessage("§e[FunDeads] §9Passage En Mode Spectateur !");
						p.setGameMode(org.bukkit.GameMode.SPECTATOR);
					} else {
						p.sendMessage("§cUSAGE > /gm <0|1|2|3>");
					}
					
				}
				
				if(args.length == 2) {
					Player target = Bukkit.getPlayerExact(args[1]);
					if(target != null) {
						
						if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
							p.sendMessage("§e[FunDeads] §9Passage En Mode Survie à §E" + target.getName());
							target.setGameMode(org.bukkit.GameMode.SURVIVAL);
							target.sendMessage("§e[FunDeads] §9Vous avez été mis en Mode Survie Par §e" + p.getName());
						} else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
							p.sendMessage("§e[FunDeads] §9Passage En Mode Créative à §e" + target.getName());
							target.setGameMode(org.bukkit.GameMode.CREATIVE);
							target.sendMessage("§e[FunDeads] §9Vous avez été mis en Mode Creative Par §e" + p.getName());
						} else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
							p.sendMessage("§e[FunDeads] §9Passage En Mode Adventure à §e" + target.getName());
							target.setGameMode(org.bukkit.GameMode.ADVENTURE);
							target.sendMessage("§e[FunDeads] §9Vous avez été mis en Mode Adventure Par §e" + p.getName());
						} else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
							p.sendMessage("§e[FunDeads] §9Passage En Mode Spectateur à §e" + target.getName());
							target.setGameMode(org.bukkit.GameMode.SPECTATOR);
							target.sendMessage("§e[FunDeads] §9Vous avez été mis en Mode Spectateur Par §e" + p.getName());
						} else {
							p.sendMessage("§cUSAGE > /gm <0|1|2|3> <player>");
						}
						
					}
					
				}
				
				if(args.length == 0) {
					p.sendMessage("§cUSAGE > /gm <0|1|2|3> <player>");
				}
			} else {
				
				p.sendMessage("Vous n'avez pas accès à cette commande !");
				
			}
		}
		return false;
	}

}
