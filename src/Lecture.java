import java.io.*;

class Lecture implements Serializable{
    private String SubjectName, LecID;
    private int PrintLecPrice, ElecLecPrice, NumModul;

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public int getNumModul() {
        return NumModul;
    }

    public void setNumModul(int NumModul) {
        this.NumModul = NumModul;
    }

    public String getLecID() {
        return LecID;
    }

    public void setLecID(String LecID) {
        this.LecID = LecID;
    }

    public int getPrintLecPrice() {
        return PrintLecPrice;
    }

    public void setPrintLecPrice(int PrintLecPrice) {
        this.PrintLecPrice = PrintLecPrice;
    }

    public int getElecLecPrice() {
        return ElecLecPrice;
    }

    public void setElecLecPrice(int ElecLecPrice) {
        this.ElecLecPrice = ElecLecPrice;
    }

    Lecture (String LecID, String SubjectName, int PrintLecPrice, int ElecLecPrice, int NumModul){
        this.LecID = LecID;
        this.SubjectName = SubjectName;
        this.PrintLecPrice = PrintLecPrice;
        this.ElecLecPrice = ElecLecPrice;
        this.NumModul = NumModul;
    }

    public void showLecture (){
        System.out.print(" " + this.LecID + "\t\t\t" + this.SubjectName + "\t\t\t\t\t\t\t" + this.NumModul + "\t\t\t\t" + this.PrintLecPrice + "\t\t\t" + this.ElecLecPrice + "\n\n");
    }
}


