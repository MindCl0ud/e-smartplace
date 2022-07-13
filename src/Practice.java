import java.io.*;

class Practice implements Serializable {
    private String PrtcName, PrtcID;
    private int PrintPrtcPrice, ElecPrtcPrice,NumPrtc;

    public String getPrtcID() {
        return PrtcID;
    }

    public void setPrtcID(String prtcID) {
        this.PrtcID = prtcID;
    }

    public int getNumPrtc() {
        return NumPrtc;
    }

    public void setNumPrtc(int numPrtc) {
        this.NumPrtc = numPrtc;
    }

    public String getPrtcName() {
        return PrtcName;
    }

    public void setPrtcName(String prtcName) {
        this.PrtcName = prtcName;
    }

    public int getPrintPrtcPrice() {
        return PrintPrtcPrice;
    }

    public void setPrintPrtcPrice(int printPrtcPrice) {
        this.PrintPrtcPrice = printPrtcPrice;
    }

    public int getElecPrtcPrice() {
        return ElecPrtcPrice;
    }

    public void setElecPrtcPrice(int elecPrtcPrice) {
        this.ElecPrtcPrice = elecPrtcPrice;
    }

    Practice (String PrtcId, String PrtcName, int PrintPrtcPrice, int ElecPrtcPrice, int NumPrtc){
        this.PrtcID = PrtcId;
        this.PrtcName = PrtcName;
        this.PrintPrtcPrice = PrintPrtcPrice;
        this.ElecPrtcPrice = ElecPrtcPrice;
        this.NumPrtc = NumPrtc;
    }

    public void showPractice (){
        System.out.print("   " + this.PrtcID + "\t\t\t" + this.PrtcName + "\t\t\t" + this.NumPrtc + "\t\t\t\t" + this.PrintPrtcPrice + "\t\t\t" + this.ElecPrtcPrice + "\n\n");
    }
}

