package fr.fundeads.commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.fundeads.main.Main;

public class SetHome implements CommandExecutor {

	private Main main;
	
	public SetHome(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("sethome")) {
			
			if(args.length == 0) {
				
				Player p = (Player) sender;
				p.sendMessage("§cUSAGE > /sethome <name>");
				
			}
			
			if(args.length >= 2) {
				
				Player p = (Player) sender;
				p.sendMessage("§cUSAGE > /sethome <name>");
				
			}
			
			if(args.length == 1) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					UUID uuid = p.getUniqueId();
					Location Loc = p.getLocation();
					
					File file = new File(main.getDataFolder(), "homes.yml");
					
					YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
					
					String user = "players." + uuid.toString();
					
					config.set(user + ".world", Loc.getWorld().getName());
					config.set(user + ".x", Loc.getX());
					config.set(user + ".y", Loc.getY());
					config.set(user + ".z", Loc.getZ());
					config.set(user + ".yaw", Loc.getYaw());
					config.set(user + ".pitch", Loc.getPitch());
					
					
					try {
						config.save(file);
						p.sendMessage("§aVotre Home §e"+ args[0] +" defini !");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					
				}
			}
			
		}
		return false;
	}

}
