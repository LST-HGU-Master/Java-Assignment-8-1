# 課題 8-1: クラス型と参照

### 課題の説明
以下のHeroクラスとMatangoクラスにattackメソッドを追加しなさい。ただし、それぞれ他方のクラスのインスタンスを指定して攻撃し、
20のダメージを与えるものとする。またattackメソッドの中では「お化けキノコAは勇者ミナトを攻撃した！」などの表示をおこなうこと。
さらに実行例にあわせてmain()メソッドにもプログラムコードを追加しなさい。なお、初期HPは実行時引数で与えること。

- Heroクラスの雛形
```java
public class Hero
{
    String name;
    int hp;
}
```

- Matangoクラスの雛形
```java
public class Matango
{
    char suffix;
    int hp;
}
```

- Prog81クラスの雛形
```java
public class Prog81 {

    public static void main(String[] args) {
        int hp = Integer.parseInt(args[0]);

        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = hp;
        Matango mA = new Matango();
        mA.suffix = 'A';
        mA.hp = hp;
        Matango mB = new Matango();
        mB.suffix = 'B';
        mB.hp = hp;
        
        // ここにプログラム追加

        System.out.println("勇者のHP: " + h.hp);
        System.out.println("お化けキノコAのHP: " + mA.hp);
        System.out.println("お化けキノコBのHP: " + mB.hp);
    }

}
```

### 実行例（実行時引数が　120　の場合）
```
勇者ミナトはお化けキノコAを攻撃した！
勇者ミナトはお化けキノコBを攻撃した！
お化けキノコAは勇者ミナトを攻撃した！
勇者のHP: 100
お化けキノコAのHP: 100
お化けキノコBのHP: 100
```
