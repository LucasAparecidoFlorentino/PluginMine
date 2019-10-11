package setif.minicurso;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Eventos implements Listener{
	
	@EventHandler
	public void Entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§a" + p.getName()+"§9 Entrou no servidor.");
	}
	@EventHandler
	public void Sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§a" + p.getName()+"§9 Saiu do servidor.");
	}
	@EventHandler
	public void AntiDV(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		for(Player p2 : Bukkit.getOnlinePlayers()) {
			if(p2.isOp()) {
				return;
			}
			if(!p2.isOp()) {
				for(String redes : Main.pl.getConfig().getStringList("IPs_Bloqueados")) {
					if(e.getMessage().contains(redes)) {
						e.setCancelled(true);
						p.sendMessage("§cSem divulgação de ips/sites.");
						
						if(p2.isOp()) {
							p.sendMessage("§7 O jogador §a" + p.getName() + "§7 está divulgando no servidor.");
							p.sendMessage("§7 Mensagem do jogador: §a" + e.getMessage());
						}
					}
				}
			}
		}
	}

}
	