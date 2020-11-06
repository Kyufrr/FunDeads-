package fr.fundeads.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.fundeads.main.Main;
 
public class Freeze implements CommandExecutor {
    
	private Main main;

	public Freeze(Main main) {
		this.main = main;
	}
    
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1){
        	
        	Player p = (Player) sender;
        	
            String targetName = args[0];
            if(Bukkit.getOfflinePlayer(targetName).getPlayer() != null){
                Player target = Bukkit.getPlayer(targetName);
                if(main.frozenPlayers.containsKey(target)){
                    main.frozenPlayers.remove(target);
                    target.sendMessage("§aYou Have Been UnFreezed by "+ p.getName());
                    p.sendMessage("§aYou Have Been UnFreezed " + target.getName());
                } else {
                    main.frozenPlayers.put(target, target.getLocation().clone());
                    target.sendMessage("§aYou Have Been Freezed By "+ p.getName());
                    p.sendMessage("§aYou Have Been Freezed " + target.getName());
                }
            }
        }
        if(args.length == 0) {
        	
        	Player p = (Player) sender;
        	
        	p.sendMessage("§cUSAGE > /freeze <player>");
        }
        return false;
    }
 
}
