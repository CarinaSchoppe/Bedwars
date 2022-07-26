package gamestates;

import java.util.ArrayList;

import main.BedWars;
import util.methods.Settings;

public class GameStateHandler {

	private static GameState current;
	private static final ArrayList<GameState> states = new ArrayList<>();

	public GameStateHandler() {
		if (!Settings.editmode) {
			states.add(new LobbyState());
			states.add(new IngameState(BedWars.getPlugin()));
		}
	}

	public static void setGameState(int id) {
		if (!Settings.editmode) {
			if (current != null)
				current.end();
			current = states.get(id);
			current.init();

		}
	}
	
	
	public static GameState getCurrentState() {
		return current;
	}

}
