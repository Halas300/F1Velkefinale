package PřidanéVěci;
import java.util.ArrayList;

public class Místnosti {
    private String id;
    private String name;
    private String description;
    public ArrayList<String> neighbors;
    public ArrayList<String> lootTable;

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

}
