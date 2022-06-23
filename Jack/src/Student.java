public class Student {
    
    private String name;
    private String clss;
    private String id;
    private String course;
    private String nation;
    
    public Student(String n, String c, String i, String s, String t){
        name = n;
        clss = c;
        id = i;
        course = s;
        nation = t;
    }

    
    public String getName(){
            return name;
    }
    
    public String getClss(){
        return clss;
    }
    
    public String getID(){
            return id;
    }
    
    public String getCourse(){
        return course;
    }
    
    public String getNation(){
        return nation;
    }
    
}
