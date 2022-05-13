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
}