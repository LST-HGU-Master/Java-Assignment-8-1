public class Hero
{
    String name;
    int hp;
    
    public void attack(Matango mt)
    {
        System.out.println(
            "勇者" + this.name + "はお化けキノコ" + mt.suffix + "を攻撃した!");
        mt.hp -= 20;
    }
}
