import java.util.Scanner;

public class BattlePhase {
    boolean block = false;
    static byte WinCounter;
    Scanner scanner = new Scanner(System.in);

    public BattlePhase() {
        Monster monster = new Monster("Гоблин Сёма", 100, 100, 7,2);
            while (MobAction.inBattle) {
                System.out.println("\nХод героя : " + Hero.Name);
                MobAction.seeStats();
                System.out.println(Hero.Name + ", какое действие предпринять? ");
                Hero.Desition = scanner.next();
                Hero.heroDesition();
                Monster.monsterDecition();
                MobAction.battleEnd();
                if(!MobAction.inBattle){
                    break;
                }
            }
    }
}