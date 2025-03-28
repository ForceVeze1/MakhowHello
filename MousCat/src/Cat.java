import java.util.ArrayList;


class Cat {
    private String name;
    private int speed;
    private int weight;
    private ArrayList<Mouse> caughtMice;

    public Cat(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.caughtMice = new ArrayList<>(100); // Максимум 100 мышей
    }

    public void catchMouse(Mouse mouse) {
        if (caughtMice.size() >= 100) {
            System.out.println(name + " не может поймать больше мышей - лимит!");
            return;
        }

        if (this.speed > mouse.getSpeed()) {
            caughtMice.add(mouse);
            System.out.println(name + " поймал мышь!");
        } else {
            System.out.println(name + " не смог догнать мышь!");
        }
    }

    public void attackCat(Cat otherCat) {
        if (this.weight > otherCat.weight) {
            System.out.println(name + " напал на " + otherCat.name + " и победил!");

            // Переносим мышей от проигравшего к победителю
            for (Mouse mouse : otherCat.caughtMice) {
                if (this.caughtMice.size() < 100) {
                    this.caughtMice.add(mouse);
                } else {
                    break; // Не превышаем лимит
                }
            }

            // Очищаем список мышей проигравшего
            otherCat.caughtMice.clear();
        } else {
            System.out.println(name + " проиграл в схватке с " + otherCat.name);
        }
    }

    // Информация о коте
    public void printInfo() {
        System.out.println("Котяра " + name + ":");
        System.out.println("Скорость: " + speed);
        System.out.println("Вес: " + weight);
        System.out.println("Поймано мышей: " + caughtMice.size());
        System.out.println();
    }
}

