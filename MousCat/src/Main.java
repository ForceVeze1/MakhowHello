// Traevsky

public class Main {
    public static void main(String[] args) {

        Cat tom = new Cat("Илюха", 10, 5);
        Cat garfield = new Cat("Махов", 100, 100);

        Mouse jerry = new Mouse(9);
        Mouse speedy = new Mouse(12);

        tom.catchMouse(jerry);
        tom.catchMouse(speedy);

        garfield.catchMouse(jerry); // Гарфилд уже не поймает Джерри (его поймал Том)

        tom.printInfo();
        garfield.printInfo();

        garfield.attackCat(tom);

        tom.printInfo();
        garfield.printInfo();
    }
}