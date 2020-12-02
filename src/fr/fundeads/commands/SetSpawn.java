package fr.fundeads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.fundeads.main.Main;

public class SetSpawn implements CommandExecutor {

	public SetSpawn(Main main) {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("fundeads.setspawn")) {
					Main.getInstance().getConfig().set("spawn.world", p.getLocation().getWorld().getName());
					Main.getInstance().getConfig().set("spawn.x", p.getLocation().getX());
					Main.getInstance().getConfig().set("spawn.y", p.getLocation().getY());
					Main.getInstance().getConfig().set("spawn.z", p.getLocation().getZ());
					Main.getInstance().getConfig().set("spawn.yaw", p.getLocation().getYaw());
					Main.getInstance().getConfig().set("spawn.pitch", p.getLocation().getPitch());
					Main.getInstance().saveConfig();
					p.sendMessage("§l§e[FunDeads]§a The Spawn has Been Difined !");
				} else {
					p.sendMessage("§l§e[FunDeads]§cVous n'avez pas la permission !");
				}
			}
		}
		
		return true;
	}

}