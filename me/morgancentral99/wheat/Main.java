package me.morgancentral99.wheat;

import java.io.File;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	Logger log = Bukkit.getLogger();
	int Most = 3;
	int Smallest = 1;
	Random r = new Random();
	FileConfiguration config = getConfig();
	File file;

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		if(!(getDataFolder().exists())) {
			config.addDefault("enabled", true);
			config.options().copyDefaults(true);
			saveConfig();
		}
	//	this.getCommand("Wheat").setExecutor(new Command());
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	
	public void getClick(PlayerInteractEvent event) {
		Block block = event.getClickedBlock();
		if(getConfig().getBoolean("enabled")) {
		//System.out.println("Clicked " + event.getClickedBlock().getData() + "" + block.getType());
			Player p = event.getPlayer();

			Location loc = event.getClickedBlock().getLocation();
			if(event.getAction() == Action.RIGHT_CLICK_AIR) return;
			World w = event.getPlayer().getWorld();
			if(block.getType() == Material.CROPS) {
				
				System.out.println("Clicked Wheat");
				if(block.getData() == 7) {
					block.setData((byte) 0);
					w.dropItem(loc, new ItemStack(Material.WHEAT, 1));
				}
				
			} else if(block.getType() == Material.POTATO) {
				
				if(block.getData() == 7) {
					block.setData((byte) 0);
					w.dropItem(loc, new ItemStack(Material.POTATO_ITEM, 2));
				}
				
			} else if(block.getType() == Material.CARROT) {
				if(block.getData() == 7) {
					block.setData((byte) 0);
					w.dropItem(loc, new ItemStack(Material.CARROT_ITEM, 2));
				}
				
			} else if(block.getType() == Material.BEETROOT_BLOCK) {
				if(block.getData() == 3) {
					block.setData((byte) 0);
					w.dropItem(loc, new ItemStack(Material.BEETROOT, 1));
				}
				
			}
		}
		
	}
	
	public int getRandom() {
		Random random = new Random();
		int rand = random.nextInt(Most - Smallest) + Smallest;
		return rand;
		
	}
	

}
