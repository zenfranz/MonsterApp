public class Monster extends GameCharacters{
    static boolean DoCrit;

    Monster(String Name, int HP, int MaxHP, int Damage, int Defence) {
        super(Name,HP,MaxHP,Damage,Defence);
    }
    public static void monsterAttack() {
        double MonsterChoise = Math.random()*9;

        switch ((int) MonsterChoise){
            case 1:
            case 2:
            case 3: {
                ActionList.eyeAttack();
                ActionList.monsterAattackCalculation();
                break;
            }
            case 4:
            case 5:
            case 6:{
                ActionList.headAttack();
                ActionList.monsterAattackCalculation();
                break;
            }
            case 7:
            case 8:
            case 9:{
                ActionList.bodyAttack();
                ActionList.monsterAattackCalculation();
                break;
            }
            default:
                ActionList.bodyAttack();
                ActionList.monsterAattackCalculation();

        }
        }
    public static void monsterHeal(){
        boolean DoCrit = Math.random() > 0.8;
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
        if ((!ActionList.FriendState)|(ActionList.InBattleState)) {
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
            ActionList.stopbattle();
        }
    }
}
