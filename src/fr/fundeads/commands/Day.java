package fr.fundeads.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day implements CommandExecutor {

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
   
        if(cmd.getName().equalsIgnoreCase("day")){
            Player p = (Player) sender;
       
            if(args.length == 0){
           
                p.getLocation().getWorld().setTime(1000);
                p.sendMessage(ChatColor.GREEN + "Time set to day in world "+ ChatColor.GOLD + p.getLocation().getWorld().getName() + ".");
           
            } else if(args.length == 1){
           
                if(args[0].equalsIgnoreCase("all")){
               
                    for(World world : Bukkit.getServer().getWorlds()){
                   
                        world.setTime(1000);
                    }
                    p.sendMessage(ChatColor.GREEN + "Time set to day in all worlds.");
                   
                }else if(Bukkit.getServer().getWorlds().contains(args[1])){
                   
                    Bukkit.getServer().getWorld(args[1]).setTime(1000);
                   
                    p.sendMessage(ChatColor.GREEN + "Set time to day in world " + ChatColor.GOLD + args[1] );
                }
            }
            return true;
           
        }
   
        return false;
    }
    }