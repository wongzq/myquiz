
public class Result {

    private final int quesNo;
    private final char appAns;
    private final char correctAns;
    private final String status;

    public Result(int quesNo, char appAns, char correctAns, String status) {
        this.quesNo = quesNo;
        this.appAns = appAns;
        this.correctAns = correctAns;
        this.status = status;

    }

    public int getQuesNo() {
        return quesNo;
    }

    public char getAppAns() {
        return appAns;
    }

    public char getCorrectAns() {
        return correctAns;
    }

    public String getStatus() {
        return status;
    }

}
