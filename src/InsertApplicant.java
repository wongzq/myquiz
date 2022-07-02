import java.io.*; 
import java.util.*;
public class InsertApplicant{
   
    private static final int REC_SIZE = 84;
    private static final int NAME_SIZE = 20;
    private static final int PASSWORD_SIZE = 20;
    private static int stuPos = 0;
    private static String stuName;
    private static String stuPassword;

    // This class is for inserting the applicants' username and password into the serialized file
    public static void main(String[] args) throws IOException {
        RandomAccessFile rafFile = new RandomAccessFile("src/TextFiles/applicants.dat", "rw");
        String reply = "N";
        Scanner input = new Scanner(System.in);
        do {
            stuPos++;
            System.out.print("Enter Applicant's Name >> ");
            stuName = input.nextLine();
            System.out.print("Enter Applicant's Password >> ");
            stuPassword = input.nextLine();
            saveRecord(rafFile);
            System.out.print("Enter More (Y/N) ? ");
            reply = (input.nextLine()).toUpperCase();
        } while (reply.equals("Y"));
        displayRecords(rafFile);
        rafFile.close();
    }

    public static void saveRecord(RandomAccessFile file) throws IOException {
        int filePosition = (stuPos - 1) * REC_SIZE;
        file.seek(filePosition);
        file.writeInt(stuPos);
        writeString(file, stuName, NAME_SIZE);
        writeString(file, stuPassword, PASSWORD_SIZE);
    }

    public static void writeString(RandomAccessFile file, String text, int fixedSize) throws IOException {
        int size = text.length();
        if (size <= fixedSize) {
            file.writeChars(text);
            for (int i = size; i < fixedSize; i++) {
                file.writeChar(' ');
            }
        } else {
            file.writeChars(text.substring(0, fixedSize));
        }
    }

    public static void displayRecords(RandomAccessFile file) throws IOException {
        long numRecords = file.length() / REC_SIZE;
        file.seek(0);
        for (int i = 0; i < numRecords; i++) {
            stuPos = file.readInt();
            stuName = readString(file, NAME_SIZE);
            stuPassword = readString(file, PASSWORD_SIZE);
            System.out.println("POS : " + stuPos + " APPLICANT NAME : " + stuName + " PASSWORD : " + stuPassword);
        }
    }

    public static String readString(RandomAccessFile file, int fixedSize) throws IOException {
        String value = "";
        char c;
        for (int i = 0; i < fixedSize; i++) {
            c = file.readChar();
            //Ignore empty space at the back
            if(c != ' '){
                value += c;
            }
        }
        return value;
    }
    
    public static int getRecSize(){
        return REC_SIZE;
    }
    
    public static int getNameSize(){
        return NAME_SIZE;
    }
    
    public static int getPasswordSize(){
        return PASSWORD_SIZE;
    }
}