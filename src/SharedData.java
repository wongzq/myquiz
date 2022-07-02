
public class SharedData {

    private static ApplicantDetails applicant;

    public static ApplicantDetails getApplicant() {
        return applicant;
    }

    public static void setApplicant(ApplicantDetails a) {
        applicant = a;
    }
}
