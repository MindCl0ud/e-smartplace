import java.io.*;

class Checkout implements Serializable {
    private String ItemName, EmailUser, AddressUser;
    private int PrintPrice, ElecPrice, Total, PostalCode, NumItem;

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        this.PostalCode = postalCode;
    }

    public String getEmailUser() {
        return EmailUser;
    }

    public void setEmailUser(String emailUser) {
        this.EmailUser = emailUser;
    }

    public String getAddressUser() {
        return AddressUser;
    }

    public void setAddressUser(String addressUser) {
        this.AddressUser = addressUser;
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

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        this.Total = total;
    }

    Checkout(String ItemName, String EmailUser, String AddressUser, int PostalCode, int PrintPrice, int ElecPrice, int Total, int NumItem){
        this.ItemName = ItemName;
        this.EmailUser = EmailUser;
        this.AddressUser = AddressUser;
        this.PostalCode = PostalCode;
        this.PrintPrice = PrintPrice;
        this.ElecPrice = ElecPrice;
        this.Total = Total;
        this.NumItem = NumItem;
    }

    public void showCheckout(){
        System.out.print("   " + this.ItemName + "\t\t\t" + this.EmailUser + "\t\t\t" + this.AddressUser + "\t\t\t\t" + this.PrintPrice + "\t\t\t" + this.ElecPrice + "\t\t\t" + this.Total + "\t\t\t" + this.NumItem);
    }
}
