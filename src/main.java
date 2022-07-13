import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        File LecFile = new File("lecture.txt");
        ArrayList<Lecture> LectureList = new ArrayList<Lecture>();
        ObjectOutputStream oosLec =  null;
        ObjectInputStream oisLec = null;
        ListIterator Li = null;

        if (LecFile.isFile()){
            oisLec = new ObjectInputStream(new FileInputStream(LecFile));
            LectureList = (ArrayList<Lecture>)oisLec.readObject();
            oisLec.close();
        }

        File ExamFile = new File("exampap.txt");
        ArrayList<Exam> ExamList = new ArrayList<Exam>();
        ObjectOutputStream oosEx =  null;
        ObjectInputStream oisEx = null;

        if (ExamFile.isFile()){
            oisEx = new ObjectInputStream(new FileInputStream(ExamFile));
            ExamList = (ArrayList<Exam>)oisEx.readObject();
            oisEx.close();
        }

        File PrtcFile = new File("practice.txt");
        ArrayList<Practice> PracticeList = new ArrayList<Practice>();
        ObjectOutputStream oosPra =  null;
        ObjectInputStream oisPra = null;

        if (PrtcFile.isFile()){
            oisPra = new ObjectInputStream(new FileInputStream(PrtcFile));
            PracticeList = (ArrayList<Practice>)oisPra.readObject();
            oisPra.close();
        }

        File CartFile = new File("cart.txt");
        ArrayList<Cart> cartList = new ArrayList<Cart>();
        ObjectOutputStream oosKer =  null;
        ObjectInputStream oisKer = null;

        if (CartFile.isFile()){
            oisKer = new ObjectInputStream(new FileInputStream(CartFile));
            cartList = (ArrayList<Cart>)oisKer.readObject();
            oisKer.close();
        }

        File CheckoutFile = new File("checkout.txt");
        ArrayList<Checkout> CheckoutList = new ArrayList<Checkout>();
        ObjectInputStream oisBay = null;

        if (CheckoutFile.isFile()){
            oisBay = new ObjectInputStream(new FileInputStream(CheckoutFile));
            CheckoutList = (ArrayList<Checkout>)oisBay.readObject();
            oisBay.close();
        }

        int plhrole = 0;
        Scanner role = new Scanner(System.in);
        boolean runrole = true;
        while (runrole){
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print(">> ");
            plhrole = role.nextInt();
                if(plhrole == 1){
                    int plhAdmin = 0;
                    Scanner admin = new Scanner(System.in);
                    boolean runadmin = true;
                    while (runadmin){
                        System.out.println("===ADMIN===");
                        System.out.println("1. Lecture Module");
                        System.out.println("2. Previous Exam");
                        System.out.println("3. Practice Paper");
                        System.out.println("4. Exit");
                        System.out.print(">> ");
                        plhAdmin = admin.nextInt();
                            if (plhAdmin == 1) {
                                int plhLec = 0;
                                boolean lecmodule = true;
                                Scanner Lecslct = new Scanner(System.in);
                                while (lecmodule) {
                                    System.out.println("|==================================================================================|");
                                    System.out.println("| ID.\t|\t\t\tSubject Name\t\t|\tModul Amount\t|\tPrinted\t|  Electronic  |");
                                    System.out.println("|==================================================================================|");
                                    if (LectureList.isEmpty()) {
                                        System.out.println("empty");
                                    }
                                    else {
                                        int count = 0;
                                        while (count < LectureList.size()) {
                                            LectureList.get(count).showLecture();
                                            count++;
                                        }
                                    }
                                    System.out.println("1. Add Lecture Module");
                                    System.out.println("2. Delete Lecture Module");
                                    System.out.println("3. Exit");
                                    System.out.print(">> ");
                                    plhLec = Lecslct.nextInt();
                                        if (plhLec == 1) {
                                            String LecID;
                                            String SubjectName;
                                            int NumModul;
                                            int PrintedLecPrice, ElecLecPrice;
                                            Scanner LecIDScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Lecture ID [LC____]: ");
                                                LecID = LecIDScan.nextLine();
                                            } while (!LecID.contains("LC") || LecID.isEmpty());
                                            Scanner SubjectNameScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Subject Name [can not be empty]: ");
                                                SubjectName = SubjectNameScan.nextLine();
                                            } while (SubjectName.isEmpty());
                                            Scanner NumModulScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Numbers of Modul [10 - 12]: ");
                                                NumModul = NumModulScan.nextInt();
                                            } while (NumModul > 12 || NumModul < 10);
                                            Scanner PrintedLecPriceScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Price Printed [can not be empty]: ");
                                                PrintedLecPrice = PrintedLecPriceScan.nextInt();
                                            } while (PrintedLecPrice <= 0);
                                            Scanner ElecLecPriceScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Price Electronic [value can not be less than Printed]: ");
                                                ElecLecPrice = ElecLecPriceScan.nextInt();
                                            } while (ElecLecPrice <= 0 || ElecLecPrice > PrintedLecPrice);

                                            LectureList.add(new Lecture(LecID, SubjectName, PrintedLecPrice, ElecLecPrice, NumModul));
                                            oosLec = new ObjectOutputStream(new FileOutputStream(LecFile));
                                            oosLec.writeObject(LectureList);
                                            oosLec.close();
                                        }

                                        else if (plhLec == 2) {
                                            if (LecFile.isFile()) {
                                                oisLec = new ObjectInputStream(new FileInputStream(LecFile));
                                                LectureList = (ArrayList<Lecture>) oisLec.readObject();
                                                oisLec.close();
                                                boolean found = false;
                                                Scanner DeleteLecIDScan = new Scanner(System.in);
                                                System.out.print("Enter ID You Want to Delete: ");
                                                String DeleteLec = DeleteLecIDScan.nextLine();
                                                Li = LectureList.listIterator();
                                                while (Li.hasNext()) {
                                                    Lecture leclist = (Lecture) Li.next();
                                                    if (leclist.getLecID().equals(DeleteLec)) {
                                                        Li.remove();
                                                        found = true;
                                                    }
                                                }
                                                if (!found) {
                                                    System.out.println("ID not Found!");
                                                }
                                                else {
                                                    oosLec = new ObjectOutputStream(new FileOutputStream(LecFile));
                                                    oosLec.writeObject(LectureList);
                                                    oosLec.close();
                                                    System.out.println("Success Delete Lecture");
                                                }
                                            }
                                            else {
                                                System.out.println("File not Found");
                                            }
                                        }
                                        else if (plhLec == 3) {
                                            lecmodule = false;
                                        }
                                    }
                                }
                            else if(plhAdmin == 2) {
                                int plhExam = 0;
                                boolean PrevExam = true;
                                while (PrevExam) {
                                    System.out.println("|==================================================================================|");
                                    System.out.println("| ID. |\t\tExam Name\t\t|\tExam Amount\t|\tPrinted\t|\tElectronic\t|");
                                    System.out.println("|==================================================================================|");
                                    if (ExamList.isEmpty()) {
                                        System.out.println("empty");
                                    }
                                    else {
                                        int count = 0;
                                        while (count < ExamList.size()) {
                                            ExamList.get(count).showExam();
                                            count++;
                                        }
                                    }
                                    Scanner ExmSlct = new Scanner(System.in);
                                    System.out.println("1. Add Previous Exam");
                                    System.out.println("2. Delete Previous Exam");
                                    System.out.println("3. Exit");
                                    System.out.print(">> ");
                                    plhExam = ExmSlct.nextInt();
                                        if (plhExam == 1) {
                                            String ExamId;
                                            String ExamName;
                                            int NumExam;
                                            int PrintedExmPrice, ElecExmPrice;
                                            Scanner ExamIDScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Exam ID [EX____]: ");
                                                ExamId = ExamIDScan.nextLine();
                                            } while (!ExamId.contains("EX") || ExamId.isEmpty());
                                            Scanner PrevExamNameScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Previous Exam Paper Name [can not be empty]: ");
                                                ExamName = PrevExamNameScan.nextLine();
                                            } while (ExamName.isEmpty());
                                            Scanner NumberExamScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Numbers of Previous Exam Paper [can not be empty]: ");
                                                NumExam = NumberExamScan.nextInt();
                                            } while (NumExam <= 0);
                                            Scanner PrintedExmPriceScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Price of Printed Exam [can not be empty]: ");
                                                PrintedExmPrice = PrintedExmPriceScan.nextInt();
                                            } while (PrintedExmPrice <= 0);
                                            Scanner ElecExmPriceScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Price of Electronic Exam [value can not be less than printred]: ");
                                                ElecExmPrice = ElecExmPriceScan.nextInt();
                                            } while (ElecExmPrice <= 0 || ElecExmPrice > PrintedExmPrice);

                                            ExamList.add(new Exam(ExamId, ExamName, PrintedExmPrice, ElecExmPrice, NumExam));
                                            oosEx = new ObjectOutputStream(new FileOutputStream(ExamFile));
                                            oosEx.writeObject(ExamList);
                                            oosEx.close();
                                        }
                                        else if (plhExam == 2) {
                                            if (ExamFile.isFile()) {
                                                oisEx = new ObjectInputStream(new FileInputStream(ExamFile));
                                                ExamList = (ArrayList<Exam>) oisEx.readObject();
                                                oisEx.close();
                                                boolean found = false;
                                                Scanner DeleteExamScan = new Scanner(System.in);
                                                System.out.print("Enter ID You Want to Delete: ");
                                                String delete = DeleteExamScan.nextLine();
                                                Li = ExamList.listIterator();
                                                while (Li.hasNext()) {
                                                    Exam b = (Exam) Li.next();
                                                    if (b.getExamID().equals(delete)) {
                                                        Li.remove();
                                                        found = true;
                                                    }
                                                }
                                                if (!found) {
                                                    System.out.println("ID not Found");
                                                }
                                                else {
                                                    oosEx = new ObjectOutputStream(new FileOutputStream(ExamFile));
                                                    oosEx.writeObject(ExamList);
                                                    oosEx.close();
                                                    System.out.println("Success Delete Exam");
                                                }
                                            } else {
                                                System.out.println("File not Found");
                                            }
                                        }
                                        else if (plhExam == 3) {
                                            PrevExam = false;
                                        }
                                    }
                                }
                            else if(plhAdmin == 3) {
                                int plhPractice = 0;
                                boolean PracticeAdmin = true;
                                while (PracticeAdmin) {
                                    System.out.println("+==================================================================================+");
                                    System.out.println("| ID. |\t\tPractice Name\t\t|\tPractice Amount\t|\tPrinted\t|\tElectronic\t|");
                                    System.out.println("+==================================================================================+");
                                    if (PracticeList.isEmpty()) {
                                        System.out.println("empty");
                                    }
                                    else {
                                        int count = 0;
                                        while (count < PracticeList.size()) {
                                            PracticeList.get(count).showPractice();
                                            count++;
                                        }
                                    }
                                    Scanner plhPracticeScan = new Scanner(System.in);
                                    System.out.println("1. Add Practice Paper");
                                    System.out.println("2. Delete Practice Paper");
                                    System.out.println("3. Exit");
                                    System.out.print(">> ");
                                    plhPractice = plhPracticeScan.nextInt();
                                        if (plhPractice == 1) {
                                            String PrtcID;
                                            String PrtcName;
                                            int NumPrtc;
                                            int PrintedPrtcPrice, ElecPrtcPrice;
                                            Scanner PrtcIDScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter ID [PT____]: ");
                                                PrtcID = PrtcIDScan.nextLine();
                                            } while (!PrtcID.contains("PT") || PrtcID.isEmpty());
                                            Scanner PrtcNameScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Practice Paper Name [can not be empty]: ");
                                                PrtcName = PrtcNameScan.nextLine();
                                            } while (PrtcName.isEmpty());
                                            Scanner NumPrtcScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Amount of Practice Paper [can not be empty]: ");
                                                NumPrtc = NumPrtcScan.nextInt();
                                            } while (NumPrtc <= 0);
                                            Scanner PrintedPrtcPriceScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Printed Price of Practice Paper [can not be empty]: ");
                                                PrintedPrtcPrice = PrintedPrtcPriceScan.nextInt();
                                            } while (PrintedPrtcPrice <= 0);
                                            Scanner ElecPrtcPriceScan = new Scanner(System.in);
                                            do {
                                                System.out.print("Enter Electronic Price of Practice Paper [value can not be less than printred]: ");
                                                ElecPrtcPrice = ElecPrtcPriceScan.nextInt();
                                            } while (ElecPrtcPrice <= 0 || ElecPrtcPrice > PrintedPrtcPrice);

                                            PracticeList.add(new Practice(PrtcID, PrtcName, PrintedPrtcPrice, ElecPrtcPrice, NumPrtc));
                                            oosPra = new ObjectOutputStream(new FileOutputStream(PrtcFile));
                                            oosPra.writeObject(PracticeList);
                                            oosPra.close();
                                        }
                                        else if (plhPractice == 2) {
                                            if (PrtcFile.isFile()) {
                                                oisPra = new ObjectInputStream(new FileInputStream(PrtcFile));
                                                PracticeList = (ArrayList<Practice>) oisPra.readObject();
                                                oisPra.close();
                                                boolean found = false;
                                                Scanner DeletePrtcScan = new Scanner(System.in);
                                                System.out.print("Enter ID You Want to Delete: ");
                                                String DeletePrtc = DeletePrtcScan.nextLine();
                                                Li = PracticeList.listIterator();
                                                while (Li.hasNext()) {
                                                    Practice b = (Practice) Li.next();
                                                    if (b.getPrtcID().equals(DeletePrtc)) {
                                                        Li.remove();
                                                        found = true;
                                                    }
                                                }
                                                if (!found) {
                                                    System.out.println("ID not Found");
                                                }
                                                else {
                                                    oosEx = new ObjectOutputStream(new FileOutputStream(ExamFile));
                                                    oosEx.writeObject(ExamList);
                                                    oosEx.close();
                                                    System.out.println("Success Delete Practice");
                                                }
                                            } else {
                                                System.out.println("File not Found");
                                            }
                                        }
                                        else if (plhPractice == 3){
                                            PracticeAdmin = false;
                                        }
                                }
                            }
                            else if (plhAdmin == 4){
                                runadmin = false;
                        }
                    }
                    }
                    else if(plhrole == 2){
                    int plhUser = 0;
                    boolean runuser = true;
                    Scanner plhUserScan = new Scanner(System.in);
                    while (runuser){
                        System.out.println("===USER===");
                        System.out.println("1. Buy Lecture Module");
                        System.out.println("2. Buy Previous Exam");
                        System.out.println("3. Buy Practice Paper");
                        System.out.println("4. Check Cart");
                        System.out.println("5. Check Receipt");
                        System.out.println("6. Exit");
                        System.out.print(">> ");
                        plhUser = plhUserScan.nextInt();
                            if (plhUser == 1) {
                                System.out.println("|==================================================================================|");
                                System.out.println("| ID. |\t\t\tSubject Name\t\t\t|\tModul Amount\t|\tPrinted\t|\tElectronic\t|");
                                System.out.println("|==================================================================================|");
                                if (LectureList.isEmpty()) {
                                    System.out.println("empty");
                                }
                                else {
                                    int count = 0;
                                    while (count < LectureList.size()) {
                                        LectureList.get(count).showLecture();
                                        count++;
                                    }
                                }
                                if (LecFile.isFile()) {
                                    oisLec = new ObjectInputStream(new FileInputStream(LecFile));
                                    LectureList = (ArrayList<Lecture>) oisLec.readObject();
                                    oisLec.close();
                                    boolean found = false;
                                    Scanner BuyLecIDScan = new Scanner(System.in);
                                    System.out.print("Select ID: ");
                                    String BuyLecID = BuyLecIDScan.nextLine();
                                    Li = LectureList.listIterator();
                                    while (Li.hasNext()) {
                                        Lecture readLec = (Lecture) Li.next();
                                        if (readLec.getLecID().equals(BuyLecID)) {
                                            Scanner NumLecScan = new Scanner(System.in);
                                            System.out.print("Amount to buy: ");
                                            int NumLec = NumLecScan.nextInt();
                                            cartList.add(new Cart(readLec.getLecID(), readLec.getSubjectName(), readLec.getPrintLecPrice(), readLec.getElecLecPrice(), readLec.getPrintLecPrice() * NumLec, readLec.getElecLecPrice() * NumLec, NumLec));
                                            oosKer = new ObjectOutputStream(new FileOutputStream(CartFile));
                                            oosKer.writeObject(cartList);
                                            oosKer.close();
                                            found = true;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("ID not Found");
                                    }
                                    else {
                                        oosEx = new ObjectOutputStream(new FileOutputStream(ExamFile));
                                        oosEx.writeObject(ExamList);
                                        oosEx.close();
                                        System.out.println("Success to buy and added to cart");
                                    }
                                }
                                else {
                                    System.out.println("File not Found");
                                }
                            }
                            else if(plhUser == 2) {
                                System.out.println("|==================================================================================|");
                                System.out.println("| ID. |\t\tExam Name\t\t|\tExam Amount\t|\tPrinted\t|\tElectronic\t|");
                                System.out.println("|==================================================================================|");
                                if (ExamList.isEmpty()) {
                                    System.out.println("empty");
                                }
                                else {
                                    int count = 0;
                                    while (count < ExamList.size()) {
                                        ExamList.get(count).showExam();
                                        count++;
                                    }
                                }
                                if (ExamFile.isFile()) {
                                    oisEx = new ObjectInputStream(new FileInputStream(ExamFile));
                                    ExamList = (ArrayList<Exam>) oisEx.readObject();
                                    oisEx.close();
                                    boolean found = false;
                                    Scanner BuyExamIDScan = new Scanner(System.in);
                                    System.out.print("Select ID: ");
                                    String BuyExamID = BuyExamIDScan.nextLine();
                                    Li = ExamList.listIterator();
                                    while (Li.hasNext()) {
                                        Exam readExam = (Exam) Li.next();
                                        if (readExam.getExamID().equals(BuyExamID)) {
                                            System.out.print("Amount to buy: ");
                                            Scanner NumExamScan = new Scanner(System.in);
                                            int NumExam = NumExamScan.nextInt();
                                            cartList.add(new Cart(readExam.getExamID(), readExam.getExamName(), readExam.getPrintExamPrice(), readExam.getElecExamPrice(), readExam.getPrintExamPrice() * NumExam, readExam.getElecExamPrice() * NumExam, NumExam));
                                            oosKer = new ObjectOutputStream(new FileOutputStream(CartFile));
                                            oosKer.writeObject(cartList);
                                            oosKer.close();
                                            int jumlahTotal = readExam.getNumExam() - NumExam;
                                            readExam.setNumExam(jumlahTotal);
                                            oosEx = new ObjectOutputStream(new FileOutputStream(ExamFile));
                                            oosEx.writeObject(ExamList);
                                            oosEx.close();
                                            found = true;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("ID not Found");
                                    }
                                    else {
                                        oosEx = new ObjectOutputStream(new FileOutputStream(ExamFile));
                                        oosEx.writeObject(ExamList);
                                        oosEx.close();
                                        System.out.println("Success to buy and added to cart");
                                    }
                                }
                                else {
                                    System.out.println("File not Found");
                                }
                            }
                            else if(plhUser == 3) {
                                System.out.println("|==================================================================================|");
                                System.out.println("| ID. |\t\tPractice Name\t\t|\tPractice Amount\t|\tPrinted\t|\tElectronic\t|");
                                System.out.println("|==================================================================================|");
                                if (PracticeList.isEmpty()) {
                                    System.out.println("empty");
                                }
                                else {
                                    int count = 0;
                                    while (count < PracticeList.size()) {
                                        PracticeList.get(count).showPractice();
                                        count++;
                                    }
                                }
                                if (PrtcFile.isFile()) {
                                    oisPra = new ObjectInputStream(new FileInputStream(PrtcFile));
                                    PracticeList = (ArrayList<Practice>) oisPra.readObject();
                                    oisPra.close();
                                    boolean found = false;
                                    Scanner BuyPrtcIDScan = new Scanner(System.in);
                                    System.out.print("Select ID: ");
                                    String BuyPrtcID = BuyPrtcIDScan.nextLine();
                                    Li = PracticeList.listIterator();
                                    while (Li.hasNext()) {
                                        Practice readPrtc = (Practice) Li.next();
                                        if (readPrtc.getPrtcID().equals(BuyPrtcID)) {
                                            System.out.print("Amount to buy: ");
                                            Scanner NumPrtcScan = new Scanner(System.in);
                                            int NumPrtc = NumPrtcScan.nextInt();
                                            cartList.add(new Cart(readPrtc.getPrtcID(), readPrtc.getPrtcName(), readPrtc.getPrintPrtcPrice(), readPrtc.getElecPrtcPrice(), readPrtc.getPrintPrtcPrice() * NumPrtc, readPrtc.getElecPrtcPrice() * NumPrtc, NumPrtc));
                                            oosKer = new ObjectOutputStream(new FileOutputStream(CartFile));
                                            oosKer.writeObject(cartList);
                                            oosKer.close();
                                            int jumlahTotal = readPrtc.getNumPrtc() - NumPrtc;
                                            readPrtc.setNumPrtc(jumlahTotal);
                                            oosPra = new ObjectOutputStream(new FileOutputStream(PrtcFile));
                                            oosPra.writeObject(PracticeList);
                                            oosPra.close();
                                            found = true;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("ID not Found");
                                    }
                                    else {
                                        oosPra = new ObjectOutputStream(new FileOutputStream(PrtcFile));
                                        oosPra.writeObject(PracticeList);
                                        oosPra.close();
                                        System.out.println("Success to buy and added to cart");
                                    }
                                }
                                else {
                                    System.out.println("File not Found");
                                }
                            }
                            else if(plhUser == 4) {
                                int plhCart = 0;
                                boolean runcart = true;
                                Scanner plhCartScan = new Scanner(System.in);
                                while (runcart) {
                                    System.out.println("|==================================================================================|");
                                    System.out.println("| ID. |\t\t\tItem Name\t\t\t|\tAmount\t|\tPrinted\t|\tElectronic\t|");
                                    System.out.println("|==================================================================================|");
                                    if (cartList.isEmpty()) {
                                        System.out.println("empty");
                                    } else {
                                        int count = 0;
                                        while (count < cartList.size()) {
                                            cartList.get(count).showCart();
                                            count++;
                                        }
                                    }
                                    System.out.println("1. Continue to Checkout");
                                    System.out.println("2. Delete Item on Cart");
                                    System.out.println("3. Exit");
                                    System.out.print(">> ");
                                    plhCart = plhCartScan.nextInt();
                                        if (plhCart == 1) {
                                            int plhCheckout = 0;
                                            boolean runcheckout = true;
                                            Scanner plhCheckoutScan = new Scanner(System.in);
                                            while (runcheckout) {
                                                System.out.println("1. Printed Version");
                                                System.out.println("2. Electronic Version");
                                                System.out.println("3. Exit");
                                                System.out.print(">> ");
                                                plhCheckout = plhCheckoutScan.nextInt();
                                                if (plhCheckout == 1) {
                                                    String address;
                                                    int PostalCode;
                                                    Scanner addressScan = new Scanner(System.in);
                                                    do {
                                                        System.out.print("Enter Address: ");
                                                        address = addressScan.nextLine();
                                                    } while (address.isEmpty());
                                                    Scanner PostalCodeScan = new Scanner(System.in);
                                                    do {
                                                        System.out.print("Enter Postal Code: ");
                                                        PostalCode = PostalCodeScan.nextInt();
                                                    } while (PostalCode > 0);
                                                } else if (plhCheckout == 2) {

                                                } else if (plhCheckout == 3) {
                                                    runcheckout = false;
                                                }
                                            }
                                        }
                                        else if (plhCart == 2) {
                                            if (CartFile.isFile()) {
                                                oisKer = new ObjectInputStream(new FileInputStream(CartFile));
                                                cartList = (ArrayList<Cart>) oisKer.readObject();
                                                oisKer.close();
                                                boolean found = false;
                                                Scanner DeleteItemCartScan = new Scanner(System.in);
                                                System.out.print("Select ID: ");
                                                String DeleteItemCart = DeleteItemCartScan.nextLine();
                                                Li = cartList.listIterator();
                                                while (Li.hasNext()) {
                                                    Cart b = (Cart) Li.next();
                                                    if (b.getItemID().equals(DeleteItemCart)) {
                                                        Li.remove();
                                                        found = true;
                                                    }
                                                }
                                                if (!found)
                                                    System.out.println("ID not Found");
                                                else {
                                                    oosKer = new ObjectOutputStream(new FileOutputStream(CartFile));
                                                    oosKer.writeObject(cartList);
                                                    oosKer.close();
                                                    System.out.println("Success Delete");
                                                }
                                            }
                                            else {
                                                System.out.println("File not Found");
                                            }
                                        }
                                        else if(plhCart == 3){
                                            runcart = false;
                                        }
                                    }
                                }
                            else if (plhUser == 5){
                                if (CheckoutList.isEmpty()){
                                    System.out.println("empty");
                                }
                                else {
                                    int count = 0;
                                    while (count < CheckoutList.size()){
                                        CheckoutList.get(count).showCheckout();
                                        count++;
                                    }
                                }
                            }
                    }
            }
            else if (plhrole == 3){
                    runrole = false;
            }
        }
    }
}
