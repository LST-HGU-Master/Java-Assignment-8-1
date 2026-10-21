# 課題 8-1: クラス型と参照

### 課題の説明
教科書のコード（クラス型と参照）を参考にし、以下の`Hero`クラスと`Matango`クラスに相互攻撃を行う`attack`メソッドを追加しなさい。

また、実行例に合わせて`Prog81`クラスの`main`メソッドを完成させなさい。

なお、キャラクターの初期HPは実行時引数（`args[0]`）で与えるものとする。

#### 【追加するメソッドの仕様】
| クラス名 | メソッド名 | 戻り値の型 | 引数リスト | 処理内容 |
| :--- | :--- | :--- | :--- | :--- |
| `Hero` | `attack` | なし (`void`) | `Matango m` | 「勇者`<name>`はお化けキノコ`<m.suffix>`を攻撃した！」と表示し、相手（`m`）の `hp` を `20` 減らす |
| `Matango` | `attack` | なし (`void`) | `Hero h` | 「お化けキノコ`<suffix>`は勇者`<h.name>`を攻撃した！」と表示し、相手（`h`）の `hp` を `20` 減らす |

#### 【各クラスのコード雛形】
・**Hero.java**
```java
public class Hero
{
    String name;
    int hp;

    // ここに attack メソッドを追加
}
```

・**Matango.java**
```java
public class Matango
{
    char suffix;
    int hp;

    // ここに attack メソッドを追加
}
```

・**Prog81.java**
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
        
        // ここに攻撃処理を追加

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
（注意）
・感嘆符「！」および「お化けキノコ」の表記はすべて【全角文字】を使用すること。

・「勇者のHP: 」などのコロン「:」および直後のスペースは【半角文字】を使用すること。
