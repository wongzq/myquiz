public class ApplicantDetails extends Applicant {
    private int age;
    private String gender;
    private String nationality;
    private String appClass;
    private String id;
    private String course;

    public ApplicantDetails(String name,
            String password,
            int age,
            String gender,
            String nationality,
            String appClass,
            String id,
            String course) {
        super(name, password);
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.appClass = appClass;
        this.id = id;
        this.course = course;

    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getAppClass() {
        return appClass;
    }

    public String getID() {
        return id;
    }

    public String getCourse() {
        return course;
    }

}