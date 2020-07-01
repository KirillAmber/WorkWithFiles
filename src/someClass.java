import java.util.ArrayList;

public class someClass  {
    private String name;
    private int id;
    public someClass(){
        name = null;
        id = -1;
    }
    public someClass(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String toString(){
        return id + " " + name;
    }
    public int testint(int a) {
        return a+=a;
    }
}
