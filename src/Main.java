import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Приветствую в вашем новом приключении.");
        System.out.println("Введите имя героя ");
        Hero.Name = ("Лорд " + scanner.next());
        Hero hero = new Hero(Hero.Name, 100, 100, 5,2);

        System.out.println("Вам предстоит управлять героем по имени " + Hero.Name);
        System.out.println();
        AdventurePhase adventurePhase = new AdventurePhase();
        Monster.Name = "Гоблин Сёма";
        System.out.println("Внезапно на вас нападает " + Monster.Name);
        System.out.println("Начинается бой");
        BattlePhase battlePhase = new BattlePhase();



    }
}
