
abstract class Vessel {
    protected String name;
    protected double speed;
    protected boolean isMoving;
    private static int count = 0;

    {
        System.out.println("Vessel created.");
    }
    // конструктор з параметрами
    public Vessel(String name, double speed) {
        this.name = name;
        this.speed = speed;
        this.isMoving = false;
        this.count++;
    }


    abstract void PrepareToMovement();
    abstract void Move();

    // методи доступу до полів
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    protected boolean getIsMoving() {
        return isMoving;
    }

    // статичне поле

    // метод порівняння двох об'єктів
    public boolean equals(Vessel v) {
        if (this.name.equals(v.getName()) && this.speed == v.getSpeed() && this.isMoving == v.getIsMoving()) {
            count--;
            return true;
        } else {
            return false;
        }
    }

    public void printCount() {
        System.out.println("Кількість суден " + count);
    }

}

class SailingVessel extends Vessel {
    private String sailType;
    public SailingVessel(String name, double speed, String sailType) {
        super(name, speed);
        this.sailType = sailType;
    }

    @Override
    void PrepareToMovement() {
        System.out.println("Підготовка вітрильника до руху...");
    }

    @Override
    void Move() {
        System.out.println("Вітрильник рухається...");
        isMoving = true;
    }

    // метод доступу до приватного поля
    public String getSailType() {
        return sailType;
    }

    public void setSailType(String sailType) {
        this.sailType = sailType;
    }

}

class Submarine extends Vessel {
    // захищене поле
    private int depth;

    // конструктор з параметрами та використання ключового слова this
    public Submarine(String name, double speed, int depth) {
        this(name, speed);
        this.depth = depth;
    }

    public Submarine(String name, double speed) {
        super(name, speed);
        this.depth = 0;
    }

    @Override
    void PrepareToMovement() {
        System.out.println("Підготовка підводного човна до руху...");
    }

    @Override
    void Move() {
        System.out.println("Підводний човен рухається...");
        isMoving = true;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

}



public class Main {
    public static void main(String[] args) {

        Vessel submarine1 = new Submarine("Maria", 50.6, 5);
        Vessel submarine2 = new Submarine("Maria", 50.6);
        Vessel sailing1 = new SailingVessel("Red October", 50.6, "Passenger Vessels");
        if (submarine1.equals(submarine2)) {
            System.out.println("Та ж сама субмарина");
            submarine1.PrepareToMovement();
            submarine2.Move();
        }
        sailing1.PrepareToMovement();
        sailing1.Move();
        sailing1.printCount();
    }
}