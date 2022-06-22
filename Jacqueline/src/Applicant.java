public class Applicant {
    private String name;
    private String password;
    
    
    public Applicant(String name, String password ) {
        this.name = name;
        this.password = password;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isCorrectPassword(String password){
        return this.password == password;
    }      
    
    
}