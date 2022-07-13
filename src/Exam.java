import java.io.*;

class Exam implements Serializable{
    private String ExamName, ExamID;
    private int PrintExamPrice, ElecExamPrice, NumExam;

    public String getExamID() {
        return ExamID;
    }

    public void setExamID(String ExamID) {
        this.ExamID = ExamID;
    }

    public int getPrintExamPrice() {
        return PrintExamPrice;
    }

    public void setPrintExamPrice(int PrintExamPrice) {
        this.PrintExamPrice = PrintExamPrice;
    }

    public int getElecExamPrice() {
        return ElecExamPrice;
    }

    public void setElecExamPrice(int ElecExamPrice) {
        this.ElecExamPrice = ElecExamPrice;
    }

/*
    public String getId() {
        return idExam;
    }

    public void setId(int id) {
        this.idExam = idExam;
    }
*/
    public int getNumExam() {
        return NumExam;
    }

    public void setNumExam(int NumExam) {
        this.NumExam = NumExam;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String ExamName) {
        this.ExamName = ExamName;
    }

    Exam (String ExamID, String ExamName, int PrintExamPrice, int ElecExamPrice, int NumExam){
        this.ExamID= ExamID;
        this.ExamName = ExamName;
        this.PrintExamPrice = PrintExamPrice;
        this.ElecExamPrice = ElecExamPrice;
        this.NumExam = NumExam;
    }

    public void showExam (){
        System.out.print("   " + this.ExamID + "\t\t\t" + this.ExamName + "\t\t\t" + this.NumExam + "\t\t\t\t" + this.PrintExamPrice + "\t\t\t" + this.ElecExamPrice + "\n\n");
    }
}


