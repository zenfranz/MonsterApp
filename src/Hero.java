import java.util.Scanner;

public class Hero extends GameCharacters{
    public static String Desition;



    public Hero(String Name, int HP, int MaxHP, int Damage, int Defence) {
        super(Name,HP,MaxHP,Damage,Defence);
    }
    public static void heroDesition(){
        switch (Desition){
            case "ударить":
                System.out.println("Куда нанести удар?");
                Scanner scanner = new Scanner(System.in);
                String TargetChoise = scanner.next();
                switch (TargetChoise) {
                    case "глаза":
                        ActionList.eyeAttack();
                        ActionList.heroAttackCalculation();
                        break;
                    case "голова":
                        ActionList.headAttack();
                        ActionList.heroAttackCalculation();
                        break;
                    case "тело":
                        ActionList.bodyAttack();
                        ActionList.heroAttackCalculation();
                        break;
                }
                break;

            case "лечить":
                Hero.heroHeal();
                System.out.println("После лечения у персонажа " + Hero.Name + " " + Hero.HP + " очков здоровья");
                break;
            case "дружить":
                ActionList.InBattleState = false;
                ActionList.frendship();
                ActionList.stopbattle();
                break;
            default:
                System.out.println("Вы пропускаете ход. Возможно вы ввели команду неверно");
                break;
        }
    }

    public static void heroHeal(){
        boolean DoCrit = Math.random() > 0.5;
        if (DoCrit) {
            System.out.println("Критическое лечение");
            Hero.HP += 30;
        } else{
            System.out.println("Обычное лечение");
            Hero.HP += 10;
        }
        if(Hero.HP > Hero.MaxHP){
            Hero.HP = Hero.MaxHP;
        }
        if(Monster.HP > Monster.MaxHP){
            Monster.HP = Monster.MaxHP;
        }

    }
}

