package me.kaboomb52.voice;

import com.cheatbreaker.api.CheatBreakerAPI;
import com.cheatbreaker.api.voice.VoiceChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Voice extends JavaPlugin {
    public void onEnable(){
        CheatBreakerAPI.getInstance().voiceEnabled(true);
        final VoiceChannel publicVoiceChannel = new VoiceChannel("Voice");

        getServer().getPluginManager().registerEvents(
                new Listener() {

                    @EventHandler
                    public void onPlayerJoin(PlayerJoinEvent event) {

                        publicVoiceChannel.addPlayer(event.getPlayer());
                        CheatBreakerAPI.getInstance().setActiveChannel(event.getPlayer(), publicVoiceChannel);

                    }

                    @EventHandler
                    public void onPlayerLeave(PlayerQuitEvent event){
                        publicVoiceChannel.removePlayer(event.getPlayer());}

                }, this
        );
    }
}
