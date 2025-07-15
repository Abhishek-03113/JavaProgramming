import java.util.Date;

class Car{
    private String Type;
    private String Model;
    private  String color;
    private int maxSpeed;
    public String Year;

    public Car(String type, String model, String color, int maxSpeed){
        this.Type = type;
        this.Model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.Year = "2020";
    }

    public void setType(String type){
        this.Type = type;
    }
    public void setModel(String model){
        this.Model = model;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    public String getType(){
        return this.Type;
    }
    public String getModel(){
        return this.Model;
    }
    public String getColor(){
        return this.color;
    }
    public int getMaxSpeed(){
        return this.maxSpeed;
    }
}

class Audi extends Car{
    private String model;
    private String Year;

    public Audi(String type, String model, String color, int maxSpeed){
        super(type, model, color, maxSpeed);
        this.model = model;
        this.Year = "2020";

    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Car car = new Car("SUV", "XyZ","red", 160);

        car.setType("Sedan");

        System.out.println(car.getType());
        System.out.println(car.getModel());
        System.out.println(car.getColor());
        System.out.println(car.getMaxSpeed());

    }
}