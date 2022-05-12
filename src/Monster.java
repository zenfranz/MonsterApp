public class Monster{
    public static int Modyfier;
    static String Name;
    static int HP, MaxHP;
    static int Damage;
    static int Defence;
    boolean block;

    public Monster(String Name, int HP, int MaxHP, int Damage, int Defence) {
        Monster.Name = Name;
        Monster.HP = HP;
        Monster.MaxHP = MaxHP;
        Monster.Damage = Damage;
        Monster.Defence = Defence;
    }
    public static void monsterAttack() {
        boolean DoCrit = Math.random() > 0.8;
        if (DoCrit) {
            System.out.println("Атака будет критической");
            Monster.Modyfier += 5;
        } else {
            System.out.println("Атака будет обычной");
            Monster.Modyfier = 1;
        }
        Hero.HP -= Math.abs(Monster.Damage * Monster.Modyfier - Hero.Defence / 2);
        System.out.println("Персонаж " + Monster.Name + " наносит " + "\n"
                + (Math.abs(Monster.Damage * Monster.Modyfier - Hero.Defence / 2))
                + " единиц урона персонажу " + Hero.Name);
    }
    public static void monsterHeal(){
        boolean DoCrit = Math.random() > 0.5;
        if (DoCrit) {
            System.out.println("Критическое лечение");
            Monster.HP += 30;
        } else{
            System.out.println("Обычное лечение");
            Monster.HP += 10;
        }
        if(Monster.HP > Monster.MaxHP){
            Monster.HP = Monster.MaxHP;
        }
        if(Monster.HP > Monster.MaxHP){
            Monster.HP = Monster.MaxHP;
        }
    }
    public static void monsterDecition() {
        if ((!MobAction.frends)|(MobAction.inBattle)) {
            System.out.println("\nХод героя : " + Monster.Name);
            if (Math.random() > 0.4) {
                System.out.println(Monster.Name + " решает Атаковать");
                Monster.monsterAttack();
            } else {
                System.out.println(Monster.Name + " решает подлечить себя");
                Monster.monsterHeal();
                System.out.println(Monster.Name + " теперь имеет " + Monster.HP + " из " + Monster.MaxHP + " очков здоровья");
            }
        }
        else {
            MobAction.battleEnd();
        }
    }
}
