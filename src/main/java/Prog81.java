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

		System.out.println("勇者のHP: " + h.hp);
		System.out.println("お化けキノコAのHP: " + mA.hp);
		System.out.println("お化けキノコBのHP: " + mB.hp);
	}

}

