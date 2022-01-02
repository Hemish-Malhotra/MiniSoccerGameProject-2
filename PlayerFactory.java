package model.players;
import java.awt.*;

public class PlayerFactory {
	private static PlayerFactory playerFactory;
	private PlayerFactory() {};
	public GamePlayer getPlayer(String player) {
		if (player == null) {
			return null;
		} else if (player.equalsIgnoreCase("striker")) {
			return new Striker(player, Color.BLUE);
		} else if (player.equalsIgnoreCase("goalkeeper")) {
			return new Goalkeeper(player, Color.YELLOW);
		}
		return null;
	}
	public static PlayerFactory getPlayerFactoryInstance() {
		if(playerFactory==null) {
			playerFactory=new PlayerFactory();
		}
		return playerFactory;
	}
	
}
