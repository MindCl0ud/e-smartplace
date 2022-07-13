import java.io.*;

class Cart implements Serializable{
    private String ItemID, ItemName;
    private int PrintPrice, ElecPrice, PrintTotal, ElecTotal, NumItem;

    public int getPrintTotal() {
        return PrintTotal;
    }

    public void setPrintTotal(int printTotal) {
        this.PrintTotal = printTotal;
    }

    public int getElecTotal() {
        return ElecTotal;
    }

    public void setElecTotal(int elecTotal) {
        this.ElecTotal = elecTotal;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        this.ItemID = itemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        this.ItemName = itemName;
    }

    public int getNumItem() {
        return NumItem;
    }

    public void setNumItem(int numItem) {
        this.NumItem = numItem;
    }

    public int getPrintPrice() {
        return PrintPrice;
    }

    public void setPrintPrice(int printPrice) {
        this.PrintPrice = printPrice;
    }

    public int getElecPrice() {
        return ElecPrice;
    }

    public void setElecPrice(int elecPrice) {
        this.ElecPrice = elecPrice;
    }

    Cart(String ItemID, String ItemName, int PrintPrice, int ElecPrice, int PrintTotal, int ElecTotal, int NumItem){
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.PrintPrice = PrintPrice;
        this.ElecPrice = ElecPrice;
        this.PrintTotal = PrintTotal;
        this.ElecTotal = ElecTotal;
        this.NumItem = NumItem;
    }
    public void showCart(){
        System.out.print("   " + this.ItemID + "\t\t\t" + this.ItemName + "\t\t\t" + this.NumItem + "\t\t\t\t" + this.PrintPrice + "\t\t\t" + this.ElecPrice + "\n\n");
    }
}