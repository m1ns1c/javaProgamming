package test;

public class GameState {

    private Shotgun gun;
    private Player p;
    private Dealer d;
    private boolean myTurn;
    private boolean skipTurn;

    public static int currentRound = 0;

    public GameState(Shotgun gun, Player p, Dealer d) {
        this.gun = gun;
        this.p = p;
        this.d = d;
        this.myTurn = true;
        this.skipTurn = false;
    }

    public Shotgun getShotgun() {
        return gun;
    }

    public Player getPlayer() {
        return p;
    }

    public Dealer getDealer() {
        return d;
    }

    public boolean isPlayerTurn() {
        return myTurn;
    }

    public boolean isSkipNextTurn() {
        return skipTurn;
    }

    public void setSkipNextTurn(boolean b) {
        skipTurn = b;
    }

    public void switchTurn() {
        myTurn = !myTurn;
    }
}