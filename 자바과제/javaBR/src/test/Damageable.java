package test;

public interface Damageable {
    void takeDamage(int amount);
    void heal(int amount);
    int getHP();
    int getMaxHP();
    boolean isAlive();
    String getName();
}

class Player implements Damageable {

    private String name;
    private int hp;
    private int maxHp;

    public Player(String name, int maxHp) {
        this.name = name;
        this.hp = maxHp;
        this.maxHp = maxHp;
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    @Override
    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHp;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Dealer implements Damageable {

    private String name;
    private int hp;
    private int maxHp;
    private boolean knowsShell;
    private String shellType;

    public Dealer(int maxHp) {
        this.name = "딜러";
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.knowsShell = false;
        this.shellType = "";
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    @Override
    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHp;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean decideSelfShoot(GameState state) {

        int live = state.getShotgun().getLiveCount();
        int blank = state.getShotgun().getBlankCount();
        int total = live + blank;

        if (total == 0) {
            return false;
        }

        if (knowsShell && shellType.equals("공포탄")) {
            return true;
        }

        double blankRate = (double) blank / total;

        if (blankRate >= 0.7) {
            return true;
        }

        return false;
    }

    public void setKnownNextShell(String shell) {
        this.knowsShell = true;
        this.shellType = shell;
    }

    public void clearKnowledge() {
        this.knowsShell = false;
        this.shellType = "";
    }
}