package PřidanéVěci;

public class NPC {
    private String id;
    private String name;
    private String role;
    private String homeLocationId;
    private String notes;

    public String getName(){
        return name;
    }

    public String getHomeLocationId(){
        return homeLocationId;
    }

    public String getNotes(){
        return notes;
    }
}
