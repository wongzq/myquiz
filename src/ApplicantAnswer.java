public class ApplicantAnswer {
    private char[] answers;
    private ApplicantDetails applicant;
    
    
    public ApplicantAnswer(char[] answer, ApplicantDetails applicant ) {
    this.answers = answers;
    this.applicant = applicant;
         

    }
    
    
    public char[] getAnswers(){
        return answers;
    }
    
    public ApplicantDetails getApplicant(){
        return applicant;
    }

}