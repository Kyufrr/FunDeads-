package fr.fundeads.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.fundeads.main.Main;

public class Home implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("sethome")) {
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				if(args.length == 0) {
					p.sendMessage("§cUSAGE > /sethome <name>");
					return false;
				}
				
				if(args.length == 1) {
					
					Main.getInstance().getConfig().set("home." + p.getUniqueId().toString() + "." + args[0] + ".world", p.getLocation().getWorld().getName());
					Main.getInstance().getConfig().set("home." + p.getUniqueId().toString() + "." + args[0] + ".x", p.getLocation().getX());
					Main.getInstance().getConfig().set("home." + p.getUniqueId().toString() + "." + args[0] + ".y", p.getLocation().getY());
					Main.getInstance().getConfig().set("home." + p.getUniqueId().toString() + "." + args[0] + ".z", p.getLocation().getZ());
					Main.getInstance().getConfig().set("home." + p.getUniqueId().toString() + "." + args[0] + ".pitch", p.getEyeLocation().getPitch());
					Main.getInstance().getConfig().set("home." + p.getUniqueId().toString() + "." + args[0] + ".yaw", p.getEyeLocation().getYaw());
					Main.getInstance().saveConfig();
					p.sendMessage("§aVotre Home " + args[0] + " à bien été défini !");
					return false;
				}
				
				if(args.length >= 2) {
					p.sendMessage("�cUSAGE > /sethome <name>");
					return false;
				}
				
			}
		}
		
		if(label.equalsIgnoreCase("home")) {
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				if(args.length == 0) {
					p.sendMessage("§cUSAGE > /home <name>");
					return false;
				}
				
				if(args.length == 1) {
					
					if(Main.getInstance().getConfig().contains("home."+ p.getUniqueId().toString() +"."+ args[0])) {
						World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("home."+ p.getUniqueId().toString() +"."+ args[0] + ".world"));
						
						double x = Main.getInstance().getConfig().getDouble("home."+ p.getUniqueId().toString() +"."+ args[0] + ".x");
						double y = Main.getInstance().getConfig().getDouble("home."+ p.getUniqueId().toString() +"."+ args[0] + ".y");
						double z = Main.getInstance().getConfig().getDouble("home."+ p.getUniqueId().toString() +"."+ args[0] + ".z");
						double pitch = Main.getInstance().getConfig().getDouble("home."+ p.getUniqueId().toString() +"."+ args[0] + ".pitch");
						double yaw = Main.getInstance().getConfig().getDouble("home."+ p.getUniqueId().toString() +"."+ args[0] + ".yaw");
						
						p.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
						p.sendMessage("§aVous avez Bien été Téléporté Au Home §e" + args[0] + "§c !");
						return false;
						
					} else {
						p.sendMessage("§cL'home " + args[0] + " n'existe pas !");
						return false;
					}
					
				}
				
				if(args.length >= 2) {
					p.sendMessage("§cUSAGE > /home <name>");
					return false;
				}
				
			}
		}
		
		if(label.equalsIgnoreCase("delhome")) {
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				if(args.length == 0) {
					p.sendMessage("§cUSAGE > /delhome <name>");
					return false;
				}
				
				if(args.length == 1) {
					if(Main.getInstance().getConfig().contains("home."+ p.getUniqueId().toString() +"."+ args[0])) {
						Main.getInstance().getConfig().set("home."+ p.getUniqueId().toString() +"."+ args[0], null);
						Main.getInstance().saveConfig();
						p.sendMessage("§aL'Home " + args[0] + "à bien été retirer !");
					} else {
						p.sendMessage("§cL'home " + args[0] + " n'existe pas !");
						return false;
					}
				}
				
				if(args.length >= 2) {
					p.sendMessage("§cUSAGE > /delhome <name>");
					return false;
				}
				
			}
		}
		
		return false;
	}

}