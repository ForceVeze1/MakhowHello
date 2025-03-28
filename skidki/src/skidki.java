import java.util.Scanner;

public class skidki {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите сумму: ");
            double sum = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Введите Промик: ");
            String promoCode = scanner.nextLine();

            double discountedSum = calculateDiscount(sum, promoCode);

            System.out.println("Итоговая сумма со скидкой с промика: " + discountedSum);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Ошибка, введите число!");
        }

    }

    public static double calculateDiscount(double sum, String promoCode) {
        double discount = 0.0; // cначала будет  0 скидка


        if (promoCode.equals("1010")) {
            discount = 0.10;
        } else if (promoCode.equals("2020") || promoCode.equals("2024") || promoCode.equals("2030")) {
            discount = 0.20;
        } else if (promoCode.equals("3030") || promoCode.equals("3333")) {
            discount = 0.30;
        } else {
            System.out.println("Недействительный промокод.");
            return sum; // Возвращаем сумму без скидки
        }

        //  итог сумму
        return sum * (1 - discount);
    }
}