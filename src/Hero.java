import java.util.Scanner;

public class Hero{
    public static String Name;
    public static String Desition;
    static int HP, MaxHP;
    public static int Damage;
    static int Defence;
    public static int Modyfier;


    public Hero(String Name, int HP, int MaxHP, int Damage, int Defence) {
        Hero.Name = Name;
        Hero.HP = HP;
        Hero.MaxHP = MaxHP;
        Hero.Damage = Damage;
        Hero.Defence = Defence;
    }
    public static void heroDesition(){
        switch (Desition){
            case "ударить":
                System.out.println("Куда нанести удар?");
                Scanner scanner = new Scanner(System.in);
                String TargetChoise = scanner.next();
                switch (TargetChoise) {
                    case "глаза":
                        AttackType.eyeAttack();
                        AttackType.heroAttackCalculation();
                        break;
                    case "голова":
                        AttackType.headAttack();
                        AttackType.heroAttackCalculation();
                        break;
                    case "тело":
                        AttackType.bodyAttack();
                        AttackType.heroAttackCalculation();
                        break;
                }
                break;

            case "лечить":
                Hero.heroHeal();
                System.out.println("После лечения у персонажа " + Hero.Name + " " + Hero.HP + " очков здоровья");
                break;
            case "дружить":
                MobAction.inBattle = false;
                MobAction.frendship();
                MobAction.battleEnd();
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

