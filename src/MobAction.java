public class MobAction {
    public MobAction() {
    }

    static boolean frends = false;
    static boolean inBattle = true;

    public static void frendship() {
        frends = true;
        inBattle = false;
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

    public static void battleEnd() {
        if (Hero.HP <= 0) {
            inBattle = false;
            System.out.println(Monster.Name + " победил персонажа " + Hero.Name);
            System.out.println("Игра окончена");
        }
        if (Monster.HP <= 0) {
            inBattle = false;
            System.out.println(Hero.Name + " победил персонажа " + Monster.Name);
            System.out.println(Hero.Name + " получает награду в виде +1 к максимальному здоровью");
            BattlePhase.WinCounter++;
            Hero.MaxHP++;
            Hero.HP = Hero.MaxHP;
        }
        if (frends) {
            inBattle = false;
        }
    }

    public static void seeStats() {
        System.out.println(Hero.Name + " имеет " + Hero.HP + " из " + Hero.MaxHP
                + " очков здоровья, ");
    }
}

