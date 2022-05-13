public class ActionList {
    static boolean CritState;
    static boolean CritMissState;
    static boolean FriendState = false;
    static boolean InBattleState = true;
    public ActionList(){


    }
    static void bodyAttack() {
        CritState = Math.random() > 0.4;
        if (CritState) {
            System.out.println("Атака в тело");
            Hero.Modyfier = 1;
        } else {
            System.out.println("Атака в тело не удалась");
            Hero.Modyfier = 0;
        }
    }
    static void headAttack() {
        CritState = Math.random() > 0.6;
        if (CritState) {
            System.out.println("Атака в голову");
            Hero.Modyfier += 3;
        } else {
            System.out.println("Атака по голове не удалась");
            Hero.Modyfier = 0;
        }
    }
    static void eyeAttack() {
        CritState = Math.random() > 0.9;
        if (CritState) {
            System.out.println("Атака будет критической");
            Hero.Modyfier += 5;
        } else {
            System.out.println("Атака по глазам не удалась");
            Hero.Modyfier = 0;
        }

    }
    public static void heroAttackCalculation(){
        Monster.HP -= Math.abs((Hero.Damage - (Monster.Defence / 2)) * Hero.Modyfier );
        System.out.println("Персонаж " + Hero.Name + " наносит " + "\n"
                + (Math.abs(Hero.Damage * Hero.Modyfier - Monster.Defence / 2))
                + " единиц урона персонажу " + Monster.Name);
        System.out.println("У персонажа " + Monster.Name + " остается " + Monster.HP + " из " + Monster.MaxHP + " единиц здоровья");
    }
    public static void monsterAattackCalculation(){
        Hero.HP -= Math.abs((Monster.Damage - (Hero.Defence / 2)) * Monster.Modyfier );
        System.out.println("Персонаж " + Monster.Name + " наносит " + "\n"
                + (Math.abs(Monster.Damage * Monster.Modyfier - Hero.Defence / 2))
                + " единиц урона персонажу " + Hero.Name);
        System.out.println("У персонажа " + Hero.Name + " остается " + Hero.HP + " из " + Hero.MaxHP + " единиц здоровья");
    }
    public static void failedAttack(){
        System.out.println("Критический промах! Персонажу " + GameCharacters.Name + " будет нанесено " + (GameCharacters.Damage + 10) + " очков урона");
    }
    public static void frendship() {
        FriendState = true;
        InBattleState = false;
        System.out.println("Вы решили подружиться с " + Monster.Name);
        System.out.println(Monster.Name + " тоже решает подружиться с " + Hero.Name);
        Hero.HP = Hero.MaxHP;
        System.out.println("Ваше здоровье восстановлено");
        Monster.HP = Monster.MaxHP;
        Hero.Defence += Monster.Defence;
        System.out.println(Monster.Name + " решил отдать свои доспехи " + Hero.Name);
        System.out.println("Показатели брони увеличены на " + Monster.Defence + " очков");
        return;
    }

    public static void stopbattle() {
        if (Hero.HP <= 0) {
            InBattleState = false;
            System.out.println(Monster.Name + " победил персонажа " + Hero.Name);
            System.out.println("Игра окончена");
        }
        if (Monster.HP <= 0) {
            InBattleState = false;
            System.out.println(Hero.Name + " победил персонажа " + Monster.Name);
            System.out.println(Hero.Name + " получает награду в виде +1 к максимальному здоровью");
            BattlePhase.WinCounter++;
            Hero.MaxHP++;
            Hero.HP = Hero.MaxHP;
        }
        if (FriendState) {
            InBattleState = false;
        }
    }

    public static void seeHeroStats() {
        System.out.println(Hero.Name + " имеет " + Hero.HP + " из " + Hero.MaxHP
                + " очков здоровья, ");
    }
}
