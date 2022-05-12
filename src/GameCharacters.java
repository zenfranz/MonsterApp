public abstract class GameCharacters {
    public static String Name;
    static int HP, MaxHP;
    public static int Damage;
    static int Defence;
    static int Modyfier;

    public GameCharacters(String Name, int HP, int MaxHP, int Damage, int Defence){
    GameCharacters.Name = Name;
    GameCharacters.HP = HP;
    GameCharacters.MaxHP = MaxHP;
    GameCharacters.Damage = Damage;
    GameCharacters.Defence = Defence;
}

    private void attack(GameCharacters target) {
    boolean DoCrit = Math.random() > 0.7;
    if (DoCrit) {
        System.out.println("Атака будет критической");
        this.Modyfier += 5;
    } else {
        System.out.println("Атака будет обычной");
        this.Modyfier = 1;
    }
    target.HP -= Math.abs(this.Damage * this.Modyfier - target.Defence / 2);
    System.out.println("Персонаж " + this.Name + " наносит " + "\n"
            + (Math.abs(this.Damage * this.Modyfier - target.Defence / 2))
            + " единиц урона персонажу " + target.Name);
    System.out.println("У персонажа " + target.Name + " остается " + target.HP + " из " + target.MaxHP + " единиц здоровья");
}

}