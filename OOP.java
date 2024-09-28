package Second;

public class OOP {
    public static void main(String[] args) {
        Chair chair1 = new Chair(0.15f, 0.3f, 0.35f, "Wood", "Brown", "StandartChair", 4);
        Chair chair2 = new Chair(0.3f, 0.6f, 0.76f, "Metal", "Yellow", "OfficeChair", 1);
        Table table1 = new Table(0.45f, 0.5f, 0.75f, "Plastic", "Red", "ChildTable", 13, true);
        Table table2 = new Table(0.75f, 0.3465f, 0.79f, "Wood", "Green", "TableForStudy", 4, false);
        Bed bed1 = new Bed(1f, 5f, 1f, "Wood", "Orange", 2, "Poor");
        Bed bed2 = new Bed(2f, 0.75f, 2f, "Metal", "Blue", 1, "Rich");


        chair1.info();
        chair2.info();
        table1.info();
        table2.info();
        bed1.info();
        bed2.info();

        System.out.println("Сумма кроватей: " + Bed.getCountOfBeds());
        System.out.println("Сумма стульев: " + Chair.getChairCount());
        System.out.println("Сумма столов: " + Table.getTableCount());
        System.out.println("Сумма ножек у стульев: " + Chair.getAllLegs());
        System.out.println("Сумма площадей столов: " + Table.getAllSquare());
    }
}


abstract class Furniture {
    private float lenX;
    private float lenY;
    private float lenZ;
    private String material;
    private String color;

    public Furniture() {
        this.lenX = 0;
        this.lenY = 0;
        this.lenZ = 0;
        this.material = "Unknown";
        this.color = "Unknown";
    }

    public Furniture(float lenX, float lenY, float lenZ, String material, String color) {
        this.lenX = lenX;
        this.lenY = lenY;
        this.lenZ = lenZ;
        this.material = material;
        this.color = color;
    }

    public float getX() {
        return lenX;
    }

    public void setX(float lenX) {
        this.lenX = lenX;
    }

    public float getY() {
        return lenY;
    }

    public void setY(float lenY) {
        this.lenY = lenY;
    }

    public float getZ() {
        return lenZ;
    }

    public void setZ(float lenZ) {
        this.lenZ = lenX;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void info();

}

class Bed extends Furniture {
    private int levels;
    private String typeOfMattress;
    private static int countOfBeds;

    public Bed(float lenX, float lenY, float lenZ, String material, String color, int levels, String typeOfMattress) {
        super(lenX, lenY, lenZ, material, color);
        this.levels = levels;
        this.typeOfMattress = typeOfMattress;
        countOfBeds++;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public String getTypeOfMattress() {
        return typeOfMattress;
    }

    public void setTypeOfMattress(String typeOfMattress) {
        this.typeOfMattress = typeOfMattress;
    }

    @Override
    public void info() {
        System.out.println("Размер: " + getX() + "x" + getY() + "x" + getZ() + ", Материал: " + getMaterial() +
                ", Цвет: " + getColor() + ", Сколько-уровненая кровать: " + levels + ", Тип матраса: " + typeOfMattress);
    }

    public static int getCountOfBeds() {
        return countOfBeds;
    }
}

class Chair extends Furniture {
    private String typeOfChair;
    private int legs;
    private static int chairCount = 0;
    private static int allLegs = 0;

    public Chair(float lenX, float lenY, float lenZ, String material, String color, String typeOfChair, int legs) {
        super(lenX, lenY, lenZ, material, color);
        this.typeOfChair = typeOfChair;
        this.legs = legs;
        chairCount++;
        allLegs+= legs;
    }

    public String getTypeOfChair() {
        return typeOfChair;
    }

    public void setTypeOfChair(String typeOfChair) {
        this.typeOfChair = typeOfChair;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public void info() {
        System.out.println("Размер: " + getX() + "x" + getY() + "x" + getZ() + ", Материал: " + getMaterial() +
                ", Цвет: " + getColor() + " Тип стула:" + typeOfChair + " Сколько ножек у стула:" + legs);
    }
    public static int getChairCount() {
        return chairCount;
    }
    public static float getAllLegs() {
        return allLegs;
    }
}

class Table extends Furniture {
    private String typeOfTable;
    private int objects;
    private boolean fold;
    private static int tableCount = 0;
    private static float allSquare = 0;


    public Table(float lenX, float lenY, float lenZ, String material, String color, String typeOfTable, int objects, boolean fold) {
        super(lenX, lenY, lenZ, material, color);
        this.typeOfTable = typeOfTable;
        this.objects = objects;
        this.fold = fold;
        tableCount++;
        allSquare+= lenX * lenZ;

    }

    public String getTypeOfTable() {
        return typeOfTable;
    }

    public void setTypeOfTable(String typeOfTable) {
        this.typeOfTable = typeOfTable;
    }

    public int getObjects() {
        return objects;
    }

    public void setObjects(int objects) {
        this.objects = objects;
    }

    public boolean getBold() {
        return fold;
    }

    public void setHour(boolean fold) {
        this.fold = fold;
    }

    public static int getTableCount() {
        return tableCount;
    }
    public static float getAllSquare() {
        return allSquare;
    }


    @Override
    public void info() {
        System.out.println("Размер: " + getX() + "x" + getY() + "x" + getZ() + " Площадь поверхности: " + getX() * getZ() + ", Материал: " + getMaterial() +
                ", Цвет: " + getColor() + " Тип стола:" + typeOfTable + " Сколько объектов на столе:" + objects + " Складываемый ли:" + fold);
    }
}
