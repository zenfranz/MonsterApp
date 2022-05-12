public class AttackType {
    static boolean DoCrit;
    static boolean CritMiss;
    public AttackType(){


    }
    static void bodyAttack() {
        DoCrit = Math.random() > 0.4;
        if (DoCrit) {
            System.out.println("Атака в тело");
            Hero.Modyfier = 1;
        } else {
            System.out.println("Атака в голову не удалась");
            Hero.Modyfier = 0;
        }
    }
    static void headAttack() {
        DoCrit = Math.random() > 0.6;
        if (DoCrit) {
            System.out.println("Атака в голову");
            Hero.Modyfier += 3;
        } else {
            System.out.println("Атака по голове не удалась");
            Hero.Modyfier = 0;
            CritMiss = Math.random()>0.7;
            if(CritMiss){
                failedAttack();
            }
        }
    }
    static void eyeAttack() {
        DoCrit = Math.random() > 0.9;
        if (DoCrit) {
            System.out.println("Атака будет критической");
            Hero.Modyfier += 5;
        } else {
            System.out.println("Атака по глазам не удалась");
            Hero.Modyfier = 0;
            CritMiss = Math.random()>0.7;
                    if(CritMiss){
                        failedAttack();
                    }
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
}
