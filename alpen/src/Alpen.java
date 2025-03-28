

// Класс Альпинист
class Climber {
    private String name;
    private int age;
    private String address;

    public Climber(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }


    public String toString() {
        return name + " (" + age + " лет, " + address + ")";
    }
}

// Класс Гора
class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name, String country, int height) {
        this.name = name;
        this.country = country;
        this.height = height;
    }

    public String toString() {
        return name + " (" + country + "), высота: " + height + " м";
    }
}

// Класс Группа для восхождения
class ClimbingGroup {
    private boolean isRecruiting;
    private Climber[] climbers;
    private Mountain mountain;
    private int climberCount;

    public ClimbingGroup(Mountain mountain) {
        this.mountain = mountain;
        this.climbers = new Climber[10]; // Максимум 10 альпинистов в группе
        this.isRecruiting = true;
        this.climberCount = 0;
    }

    public void addClimber(Climber climber) {
        if (!isRecruiting) {
            System.out.println("Набор в группу закрыт!");
            return;
        }
        if (climberCount >= climbers.length) {
            System.out.println("Группа уже заполнена!");
            return;
        }
        climbers[climberCount] = climber;
        climberCount++;
        System.out.println(climber.getName() + " добавлен в группу для восхождения на " + mountain);
    }

    public void closeRecruitment() {
        isRecruiting = false;
        System.out.println("Набор в группу для восхождения на " + mountain + " закрыт");
    }

    public void printGroupInfo() {
        System.out.println("\nИнформация о группе:");
        System.out.println("Гора: " + mountain);
        System.out.println("Статус набора: " + (isRecruiting ? "открыт" : "закрыт"));
        System.out.println("Количество альпинистов: " + climberCount);
        System.out.println("Список альпинистов:");
        for (int i = 0; i < climberCount; i++) {
            System.out.println("  " + (i+1) + ". " + climbers[i]);
        }
    }
}

public class Alpen {
    public static void main(String[] args) {
        Mountain everest = new Mountain("Эверест", "Непал", 8848);
        Mountain elbrus = new Mountain("Эльбрус", "Россия", 5642);
        Mountain kilimanjaro = new Mountain("Килиманджаро", "Танзания", 5895);

        ClimbingGroup group1 = new ClimbingGroup(everest);
        ClimbingGroup group2 = new ClimbingGroup(elbrus);
        ClimbingGroup group3 = new ClimbingGroup(kilimanjaro);

        Climber climber1 = new Climber("Александр Махов", 30, "Москва");
        Climber climber2 = new Climber("Мария Сидорова", 28, "Санкт-Петербург");
        Climber climber3 = new Climber("Илюха Дарков", 17, "Новосибирск");
        Climber climber4 = new Climber("Галина Бундина", 37, "Казань");
        Climber climber5 = new Climber("Дмитрий Венедиктов ", 45, "Екатеринбург");

        group1.addClimber(climber1);
        group1.addClimber(climber2);
        group1.addClimber(climber3);
        group1.closeRecruitment();

        group2.addClimber(climber4);
        // Набор во вторую группу остается открытым

        // Пытаемся добавить в закрытую группу
        group1.addClimber(climber5);

        // Выводим информацию о группах
        group1.printGroupInfo();
        group2.printGroupInfo();
        group3.printGroupInfo();
    }
}