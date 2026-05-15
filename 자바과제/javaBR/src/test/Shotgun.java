package test;

import java.util.*;

public class Shotgun {

    public static class Chamber {

        private ArrayList<String> bulletList;
        private int liveCount;
        private int blankCount;

        public Chamber(int live, int blank) {
            this.liveCount = live;
            this.blankCount = blank;
            bulletList = new ArrayList<>();

            for (int i = 0; i < live; i++) {
                bulletList.add("실탄");
            }

            for (int i = 0; i < blank; i++) {
                bulletList.add("공포탄");
            }

            Collections.shuffle(bulletList, new Random());
        }

        public String ejectNext() {
            if (bulletList.size() == 0) {
                return "없음";
            }

            String bullet = bulletList.remove(0);

            if (bullet.equals("실탄")) {
                liveCount--;
            } else {
                blankCount--;
            }

            return bullet;
        }

        public String peekNext() {
            if (bulletList.size() == 0) {
                return "없음";
            }
            return bulletList.get(0);
        }

        public boolean isEmpty() {
            return bulletList.size() == 0;
        }

        public int getLiveCount() {
            return liveCount;
        }

        public int getBlankCount() {
            return blankCount;
        }
    }

    private Chamber chamber;
    private boolean isCut;
    private static int totalShots = 0;

    public Shotgun() {
        this.isCut = false;
    }

    public void load(int live, int blank) {
        chamber = new Chamber(live, blank);
        isCut = false;
        System.out.println("약실 장전: 실탄 " + live + "발 + 공포탄 " + blank + "발");
    }

    public String shoot(Damageable target) {
        return shoot(target, false);
    }

    public String shoot(Damageable target, boolean forceCut) {

        if (chamber == null || chamber.isEmpty()) {
            return "불발 (탄 없음)";
        }

        String bullet = chamber.ejectNext();
        totalShots++;

        boolean doubled = isCut || forceCut;

        if (bullet.equals("실탄")) {
            int dmg = 1;

            if (doubled) {
                dmg = 2;
            }

            target.takeDamage(dmg);
            isCut = false;

            if (doubled) {
                return "실탄! (톱질 x2) -> " + target.getName() + " -" + dmg + "HP";
            } else {
                return "실탄! -> " + target.getName() + " -" + dmg + "HP";
            }

        } else {
            isCut = false;
            return "공포탄! -> " + target.getName() + " 무사";
        }
    }

    public String ejectNext() {
        if (chamber == null) {
            return "없음";
        }
        return chamber.ejectNext();
    }

    public String peekNext() {
        if (chamber == null) {
            return "없음";
        }
        return chamber.peekNext();
    }

    public boolean isEmpty() {
        if (chamber == null) {
            return true;
        }
        return chamber.isEmpty();
    }

    public int getLiveCount() {
        if (chamber == null) {
            return 0;
        }
        return chamber.getLiveCount();
    }

    public int getBlankCount() {
        if (chamber == null) {
            return 0;
        }
        return chamber.getBlankCount();
    }

    public void setSawed(boolean b) {
        this.isCut = b;
    }

    public boolean isSawed() {
        return isCut;
    }

    public static int getShotsFired() {
        return totalShots;
    }

    public String getStatus() {
        if (chamber == null) {
            return "장전 안 됨";
        }

        String msg = "실탄 " + chamber.getLiveCount() + "발 / 공포탄 " + chamber.getBlankCount() + "발 남음";

        if (isCut) {
            msg = msg + " [톱질됨]";
        }

        return msg;
    }
}