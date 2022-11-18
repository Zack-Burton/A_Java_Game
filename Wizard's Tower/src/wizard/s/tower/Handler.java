package wizard.s.tower;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Handler {

    private Game game;
    public boolean gameActive = true;
    private KeyManager keyManager;
    private boolean InventoryActive = false;

    public Handler(Game game) {
        this.game = game;
        keyManager = new KeyManager();
    }

    public void state() {
        if (State.currentState == game.getGameState()) {
            State.currentState = game.getInventoryState();
        } else {
            State.currentState = game.getGameState();
        }

    }

    public Item getTest() {
        return GameState.getMace();
    }

    public Item getTest2() {
        return GameState.getHammer();
    }

    public State getState() {
        return State.getState();
    }

    public void setState(State e) {
        State.setState(e);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public State getInventoryState() {
        return game.getInventoryState();
    }

    public void setInventoryState(State inventoryState) {
       game.setInventoryState(inventoryState);
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public void setGameActive(boolean gameActive) {
        this.gameActive = gameActive;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public MouseManager getMouseManager() {
        return game.mouseManager;
    }

}
