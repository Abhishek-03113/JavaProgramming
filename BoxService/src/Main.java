import java.util.ArrayList;

abstract class Animal{
    String name;

    public Animal(String name){
        this.name=name;
    }
}
interface flyable{
    void fly();


}
class duck extends Animal implements flyable{
    String name;
    int duckID;
    public duck(String name,int duckID){
        super(name);
        this.duckID=duckID;
    }

    @Override
    public void fly() {
        System.out.println("I can fly ");
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Animal[] animals=new Animal[3];
        ArrayList<Animal> animalList=new ArrayList<>();

        duck dk = new duck("badak", 1);
        animalList.add(dk);
        animals[0] = dk;
        animals[0] = dk;

        ArrayList<flyable> flying = new ArrayList<>();

        flying.add(dk);
        System.out.println(flying);
        System.out.println(animalList);
        System.out.println(animals[0]);
    }
}