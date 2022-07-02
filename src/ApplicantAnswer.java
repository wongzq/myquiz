
public class ApplicantAnswer implements Comparable<ApplicantAnswer> {

    private char answers[];
    private ApplicantDetails applicant;

    public ApplicantAnswer(char answers[], ApplicantDetails applicant) {
        this.answers = answers;
        this.applicant = applicant;
    }

    public char[] getAnswers() {
        return answers;
    }

    public ApplicantDetails getApplicant() {
        return applicant;
    }

    @Override
    public int compareTo(ApplicantAnswer comparee) {
        return comparee.getScore() - this.getScore();
    }

    public int getScore() {
        int score = 0;
        char[] correctAnswers = FileReadWrite.readCorrectAnswers();

        for (int i = 0; i < this.answers.length; i++) {
            if (answers[i] == correctAnswers[i]) {
                score++;
            }
        }

        return score;
    }
    
    @Override
    public String toString() {
        return this.getApplicant().getName();
    }
}
