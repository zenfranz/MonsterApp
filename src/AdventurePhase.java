import java.util.Scanner;

public class AdventurePhase {
    Scanner scanner = new Scanner(System.in);
    public AdventurePhase(){
        System.out.println(Hero.Name + " ходит по опушкам и лужайкам "
                + "как вдруг ловит себя на мысли: куда же ему отправиться?");
        System.out.println("Куда же направиться " + Hero.Name + " ?");
        System.out.println();
        System.out.println("1. На север");
        System.out.println("2. На юг");
        System.out.println("3. На восток");
        System.out.println("4. На запад");
        String input = (scanner.next());


    }
}
