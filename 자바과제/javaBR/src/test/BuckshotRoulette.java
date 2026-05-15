package test;

import java.util.*;

public class BuckshotRoulette {

    interface RoundEndEvent {
        void onRoundEnd(String winner, int round);
    }

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int pWin = 0;
    static int dWin = 0;

    public static void main(String[] args) {

        System.out.println("===== BUCKSHOT ROULETTE =====");
        System.out.println("실탄과 공포탄이 섞인 산탄총으로 딜러를 쓰러뜨려라!");
        System.out.println("3라운드 중 더 많이 이긴 쪽이 승리!");
        System.out.println("=============================");
        System.out.print("Enter를 눌러 시작...");
        sc.nextLine();

        Shotgun gun = new Shotgun();

        RoundEndEvent endHandler = new RoundEndEvent() {
            @Override
            public void onRoundEnd(String winner, int round) {
                System.out.println("라운드 " + round + " 종료! 승자: " + winner);
                System.out.println("현재 스코어 -> 플레이어: " + pWin + "승 | 딜러: " + dWin + "승");
            }
        };

        for (int i = 1; i <= 3; i++) {

            GameState.currentRound = i;

            System.out.println("\n=============================");
            System.out.println("         라운드 " + i + " 시작!");
            System.out.println("=============================");

            int hp = 3 + i;

            Player p = new Player("플레이어", hp);
            Dealer d = new Dealer(hp);
            GameState gs = new GameState(gun, p, d);

            String winner = startRound(gs);

            if (winner.equals("플레이어")) {
                pWin++;
            } else {
                dWin++;
            }

            endHandler.onRoundEnd(winner, i);

            if (i < 3) {
                System.out.print("Enter를 눌러 다음 라운드로...");
                sc.nextLine();
            }
        }

        System.out.println("\n=============================");
        System.out.println("          게임 종료!");
        System.out.println("=============================");
        System.out.println("플레이어 승: " + pWin + "라운드");
        System.out.println("딜러     승: " + dWin + "라운드");
        System.out.println("총 발사 횟수: " + Shotgun.getShotsFired() + "발");

        if (pWin > dWin) {
            System.out.println("최종 승자: 플레이어!");
        } else if (dWin > pWin) {
            System.out.println("최종 승자: 딜러!");
        } else {
            System.out.println("무승부!");
        }
    }

    static String startRound(GameState gs) {

        int live = 2 + rand.nextInt(GameState.currentRound + 1);
        int blank = 2 + rand.nextInt(GameState.currentRound + 1);

        gs.getShotgun().load(live, blank);

        ArrayList<Item> pItems = makeItems(2 + GameState.currentRound);
        ArrayList<Item> dItems = makeItems(2 + GameState.currentRound);

        System.out.print("지급 아이템: ");
        for (int i = 0; i < pItems.size(); i++) {
            System.out.print("[" + pItems.get(i).getName() + "] ");
        }
        System.out.println();

        while (gs.getPlayer().isAlive() && gs.getDealer().isAlive()) {

            if (gs.getShotgun().isEmpty()) {
                int l = 1 + rand.nextInt(3);
                int b = 1 + rand.nextInt(3);
                gs.getShotgun().load(l, b);
                pItems.addAll(makeItems(1));

                System.out.print("재장전! 아이템 추가 지급: ");
                for (int i = 0; i < pItems.size(); i++) {
                    System.out.print("[" + pItems.get(i).getName() + "] ");
                }
                System.out.println();
            }

            showStatus(gs);

            boolean isSelf;

            if (gs.isPlayerTurn()) {

                if (gs.isSkipNextTurn()) {
                    System.out.println("플레이어 턴 스킵! 수갑에 묶였다");
                    gs.setSkipNextTurn(false);
                    gs.switchTurn();
                    continue;
                }

                isSelf = doPlayerTurn(gs, pItems);

            } else {

                if (gs.isSkipNextTurn()) {
                    System.out.println("딜러 턴 스킵! 수갑에 묶였다");
                    gs.setSkipNextTurn(false);
                    gs.switchTurn();
                    continue;
                }

                isSelf = doDealerTurn(gs, dItems);
            }

            if (!isSelf) {
                gs.switchTurn();
            }
        }

        if (gs.getPlayer().isAlive()) {
            return "플레이어";
        } else {
            return "딜러";
        }
    }

    static boolean doPlayerTurn(GameState gs, ArrayList<Item> items) {

        System.out.println("\n-- 당신의 턴 --");
        System.out.println("총 상태: " + gs.getShotgun().getStatus());

        if (items.size() > 0) {
            System.out.println("아이템 목록:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". [" + items.get(i).getName() + "] " + items.get(i).getDescription());
            }
            System.out.println("0. 아이템 사용 안 함");
            System.out.print("아이템 선택 (번호 입력): ");

            int pick = readInt(0, items.size());

            if (pick > 0) {
                Item selected = items.remove(pick - 1);
                System.out.println(selected.getName() + " 사용!");
                selected.use(gs);
            }
        }

        System.out.println("누구에게 발사?");
        System.out.println("1. 딜러에게");
        System.out.println("2. 나 자신에게");
        System.out.print("선택: ");
        int aim = readInt(1, 2);

        boolean isSelf = false;
        Damageable obj;

        if (aim == 1) {
            obj = gs.getDealer();
        } else {
            obj = gs.getPlayer();
            isSelf = true;
        }

        String msg = gs.getShotgun().shoot(obj);
        System.out.println("발사! -> " + msg);

        if (isSelf && msg.contains("공포탄")) {
            return true;
        }

        return false;
    }

    static boolean doDealerTurn(GameState gs, ArrayList<Item> items) {

        System.out.println("\n-- 딜러의 턴 --");

        if (items.size() > 0 && rand.nextBoolean()) {
            Item picked = items.remove(0);
            System.out.println("딜러가 [" + picked.getName() + "] 사용!");
            picked.use(gs);
        }

        boolean isSelf = gs.getDealer().decideSelfShoot(gs);
        Damageable obj;

        if (isSelf) {
            obj = gs.getDealer();
            System.out.println("딜러가 자신에게 발사!");
        } else {
            obj = gs.getPlayer();
            System.out.println("딜러가 플레이어에게 발사!");
        }

        String msg = gs.getShotgun().shoot(obj);
        System.out.println("발사! -> " + msg);

        gs.getDealer().clearKnowledge();

        if (isSelf && msg.contains("공포탄")) {
            return true;
        }

        return false;
    }

    static ArrayList<Item> makeItems(int cnt) {

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            int n = rand.nextInt(5);

            if (n == 0) {
                list.add(new Beer());
            } else if (n == 1) {
                list.add(new Magnifier());
            } else if (n == 2) {
                list.add(new Saw());
            } else if (n == 3) {
                list.add(new Cigarette());
            } else {
                list.add(new Handcuff());
            }
        }

        return list;
    }

    static void showStatus(GameState gs) {
        System.out.println("\n-----------------------------");
        System.out.println("플레이어 HP: " + gs.getPlayer().getHP() + "/" + gs.getPlayer().getMaxHP());
        System.out.println("딜러     HP: " + gs.getDealer().getHP() + "/" + gs.getDealer().getMaxHP());
        System.out.println("총 상태: " + gs.getShotgun().getStatus());
        System.out.println("-----------------------------");
    }

    static int readInt(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());

                if (n >= min && n <= max) {
                    return n;
                }

                System.out.print(min + "~" + max + " 사이 숫자를 입력하세요: ");

            } catch (NumberFormatException e) {
                System.out.print("숫자를 입력하세요: ");
            }
        }
    }
}