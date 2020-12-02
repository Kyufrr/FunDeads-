package fr.fundeads.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.fundeads.main.Main;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase("spawn")) {
					
					World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("spawn.world"));
					
					double x = Main.getInstance().getConfig().getDouble("spawn.x", p.getLocation().getX());
					double y = Main.getInstance().getConfig().getDouble("spawn.y", p.getLocation().getY());
					double z = Main.getInstance().getConfig().getDouble("spawn.z", p.getLocation().getZ());
					double pitch = Main.getInstance().getConfig().getDouble("spawn.pitch", p.getLocation().getPitch());
					double yaw = Main.getInstance().getConfig().getDouble("spawn.yaw", p.getLocation().getYaw());
					
					p.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
					
			p.sendMessage("§e[FunDeads]§aYou have been teleported to Spawn !");
		} else {
			p.sendMessage("§cThe Spawn has not difined");
		}
		}
		return false;
	}

}
