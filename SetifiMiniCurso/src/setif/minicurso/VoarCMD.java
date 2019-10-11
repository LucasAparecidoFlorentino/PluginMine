package setif.minicurso;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoarCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lb, String[] args) {
		if(!(s instanceof Player)) {
			return true;
		}
		if(lb.equalsIgnoreCase("voar")) {
			Player p = (Player)s;
			if(!p.isOp()) {
				p.sendMessage("§cPermissão insuficiente.");
				return true;
			}
			if(p.getAllowFlight() == true) {
				p.setAllowFlight(false);
				p.sendMessage("§aFly desativado.");
			}else if(p.getAllowFlight() == false) {
				p.setAllowFlight(true);
				p.sendMessage("§aFly ativado.");
			}
		}
		return false;
	}

}
