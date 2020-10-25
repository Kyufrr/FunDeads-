package fr.fundeads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.isOp()) {
					p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
					p.sendMessage("§l§e[FunDeads]§a Le Point Du Spawn à été défini");
				} else {
					p.sendMessage("&l§e[FunDeads]§cVous n'avez pas la permission !");
				}
			}
		}
		
		return true;
	}

}
