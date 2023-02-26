import java.util.*;
import java.io.*;

class User {
    String name;
    String password;
    String phoneNo;

    User(String name, String password, String phoneNo) {
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
    }
}

class Admin {
    String name;
    String password;

    Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

class Car {
    String Company;
    String Model;
    int CarNo;
    int priceperday;
    int avail;

    Car(String Company, String Model, int CarNo, int priceperday, int avail) {
        this.Company = Company;
        this.Model = Model;
        this.CarNo = CarNo;
        this.priceperday = priceperday;
        this.avail = avail;
    }
}

class Car_Rent {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<User> user = new ArrayList<>();
    static ArrayList<Admin> admin = new ArrayList<>();

    static void getAdmins() {
        File myFile = new File(
                "F:\\CV Raman Global University\\2nd year\\4th Sem\\Object Oriented Programming using Java\\Case Study\\Main\\Admins.txt");
        try {
            Scanner fileinput = new Scanner(myFile);
            while (fileinput.hasNextLine()) {
                String line = fileinput.nextLine();
                String[] arrOfStr = line.split("-");

                Admin ad = new Admin(arrOfStr[0], arrOfStr[1]);
                admin.add(ad);
            }
            fileinput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    static void storeAdmins() {
        try {
            FileWriter fileWriter = new FileWriter(
                    "F:\\CV Raman Global University\\2nd year\\4th Sem\\Object Oriented Programming using Java\\Case Study\\Main\\Admins.txt");
            for (Admin a : admin) {
                fileWriter.write(a.name + "-" + a.password + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void getUsers() {
        File myFile = new File(
                "F:\\CV Raman Global University\\2nd year\\4th Sem\\Object Oriented Programming using Java\\Case Study\\Main\\Users.txt");
        try {
            Scanner fileinput = new Scanner(myFile);
            while (fileinput.hasNextLine()) {
                String line = fileinput.nextLine();
                String[] arrOfStr = line.split("-");

                User us = new User(arrOfStr[0], arrOfStr[1], arrOfStr[2]);
                user.add(us);
            }
            fileinput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    static void storeUsers() {
        try {
            FileWriter fileWriter = new FileWriter(
                    "F:\\CV Raman Global University\\2nd year\\4th Sem\\Object Oriented Programming using Java\\Case Study\\Main\\Users.txt");
            for (User u : user) {
                fileWriter.write(u.name + "-" + u.password + "-" + u.phoneNo + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void getCars() {
        File myFile = new File(
                "F:\\CV Raman Global University\\2nd year\\4th Sem\\Object Oriented Programming using Java\\Case Study\\Main\\Cars.txt");
        try {
            Scanner fileinput = new Scanner(myFile);
            while (fileinput.hasNextLine()) {
                String line = fileinput.nextLine();
                String[] arrOfStr = line.split("-");

                String comp = arrOfStr[0];
                String mod = arrOfStr[1];
                int cno = Integer.parseInt(arrOfStr[2]);
                int ppd = Integer.parseInt(arrOfStr[3]);
                int av = Integer.parseInt(arrOfStr[4]);
                Car cr = new Car(comp, mod, cno, ppd, av);
                cars.add(cr);
            }
            fileinput.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    static void storeCars() {
        try {
            FileWriter fileWriter = new FileWriter(
                    "F:\\CV Raman Global University\\2nd year\\4th Sem\\Object Oriented Programming using Java\\Case Study\\Main\\Cars.txt");

            for (Car c : cars) {
                fileWriter.write(c.Company + "-" + c.Model + "-" + c.CarNo + "-" + c.priceperday + "-" + c.avail);
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void adminLogin() {
        int ch = 0;
        while (true) {
            System.out.print("\n");
            System.out.println("\t__________________________________");
            System.out.println("\t----- Welcome to Admin Login -----");
            System.out.println("\t__________________________________");
            System.out.println("\t1. Sign Up.");
            System.out.println("\t2. Sign In.");
            System.out.println("\t3. Exit.");
            System.out.print("\tEnter Choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    final String authToken = "object-oriented-programming";
                    System.out.println("\t\nEnter Authorisation Token : ");
                    sc.nextLine();
                    String enteredAuthToken = sc.nextLine();

                    if (enteredAuthToken.compareTo(authToken) == 0)
                        adminSignUp();
                    else
                        System.out.println("\t\nInvalid Authorisation Token.");
                    System.out.println("\t\nPress enter to continue.");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    adminSignIn();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\tInvalid Input");
                    System.out.println("\t\nPress enter to continue.");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
            }
        }
    }

    static void adminSignUp() {
        System.out.print("\n");
        System.out.println("\t____________________________________");
        System.out.println("\t----- Welcome to Admin Sign Up -----");
        System.out.println("\t____________________________________");
        System.out.print("\tEnter Your Username : ");
        String aName = sc.nextLine();
        boolean flag = true;

        for (Admin a : admin) {
            if (aName == a.name) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.print("\tEnter Your Password : ");
            String aPassword = sc.nextLine();

            Admin newAdmin = new Admin(aName, aPassword);
            admin.add(newAdmin);

            System.out.println("\tAccount Created Successfully!");
            storeAdmins();
        } else
            System.out.println("\tAdmin username is taken!");

        System.out.println("\t\nPress enter to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void adminSignIn() {
        System.out.print("\n");
        System.out.println("\t____________________________________");
        System.out.println("\t----- Welcome to Admin Sign In -----");
        System.out.println("\t____________________________________");
        System.out.print("\tEnter Your Name : ");
        sc.nextLine();
        String aName = sc.nextLine();
        System.out.print("\tEnter Your Password : ");
        String aPassword = sc.nextLine();
        int pro = 0;
        for (Admin a : admin) {
            if (a.name.compareTo(aName) == 0 && a.password.compareTo(aPassword) == 0) {
                adminFunction();
                pro++;
                break;
            }
        }
        if (pro == 0) {
            System.out.println("\tName and Password Mismatch! \n Please Retry!!!");

            System.out.println("\t\nPress enter to continue.");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static void adminFunction() {
        int adCh = 0;
        while (true) {
            System.out.print("\n");
            System.out.println("\t______________________________________");
            System.out.println("\t----- Welcome to Admin Main Menu -----");
            System.out.println("\t______________________________________");
            System.out.println("\t1. View Users");
            System.out.println("\t2. Add Cars");
            System.out.println("\t3. Remove Cars");
            System.out.println("\t4. Edit Car Details");
            System.out.println("\t5. View All Car Details");
            System.out.println("\t6. Exit");
            System.out.print("\tEnter Choice : ");
            adCh = sc.nextInt();

            switch (adCh) {
                case 1:
                    viewUsers();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    removeCar();
                case 4:
                    editCar();
                    break;
                case 5:
                    viewallCars();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("\tInvalid Input");
                    System.out.println("\t\nPress enter to continue.");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
            }
        }
    }

    static void viewUsers() {
        int i = 1;
        System.out.print("\n");
        System.out.println("\t_______________________");
        System.out.println("\t----- User's List -----");
        System.out.println("\t_______________________");
        System.out.println("\tSno.\tUsername\tPhone Number");
        for (User us : user) {
            System.out.println("\t" + i + "\t" + us.name + "\t\t" + us.phoneNo);
        }
        System.out.print("\tEnter 0 to return or any number to remove user : ");
        int ch = sc.nextInt();

        if (ch == 0)
            return;
        else {
            if (0 < ch && ch <= user.size()) {
                user.remove(ch - 1);
                System.out.println("\tUser removed from System.");
                storeUsers();
            } else {
                System.out.println("\tInvalid Input!");
            }
            System.out.println("\t\nPress enter to continue.");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static void removeCar() {
        System.out.print("\n");
        System.out.println("\t______________________________________");
        System.out.println("\t----- Welcome to Remove Car Page -----");
        System.out.println("\t______________________________________");
        viewallCars();
        System.out.print("\tEnter Car to remove : ");
        int ch = sc.nextInt();

        if (0 < ch && ch <= cars.size()) {
            cars.remove(ch - 1);
            System.out.println("\tCar Removed.");
            storeCars();
        } else {
            System.out.println("\tInvalid Input!");
        }
        System.out.println("\t\nPress enter to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void addCar() {
        System.out.print("\n");
        System.out.println("\t___________________________________");
        System.out.println("\t----- Welcome to Add Car Page -----");
        System.out.println("\t___________________________________");
        System.out.print("\tEnter Company Name : ");
        sc.nextLine();
        String com = sc.nextLine();
        System.out.print("\tEnter Model Name : ");
        String Mod = sc.nextLine();
        System.out.print("\tEnter Car Number : ");
        int cnum = sc.nextInt();
        System.out.print("\tEnter Price Per Day for Rent : ");
        int rpd = sc.nextInt();
        System.out.print("\tEnter Car availablity : ");
        int ava = sc.nextInt();
        Car newCar = new Car(com, Mod, cnum, rpd, ava);
        cars.add(newCar);

        System.out.println("\tCar Added.\nPress enter to continue.");
        storeCars();
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void viewallCars() {
        System.out.print("\n");
        System.out.println("\t____________________________________________________________________________");
        int i = 1;
        System.out.println("\tSNo\tCompany\t\tModel\tCar Number\tPrice Per Day\tAvailablity");
        System.out.println("\t____________________________________________________________________________");
        for (Car c : cars) {
            System.out.println("\t" + i + "\t" + c.Company + "\t\t" + c.Model + "\t" + c.CarNo + "\t\t\t"
                    + c.priceperday + "\t" + c.avail);
            i++;
        }
    }

    static void editCar() {
        System.out.print("\n");
        System.out.println("\t____________________________________");
        System.out.println("\t----- Welcome to Edit Car Page -----");
        System.out.println("\t____________________________________");
        viewallCars();

        System.out.print("\tEnter Choice : ");
        int n = sc.nextInt();

        if (0 < n && n <= cars.size()) {

            System.out.println("\t1. Edit Car Company");
            System.out.println("\t2. Edit Car Model");
            System.out.println("\t3. Edit Car Number");
            System.out.println("\t4. Edit Price per day");
            System.out.println("\t5. Edit Availablity");
            System.out.println("\t6. Exit");
            System.out.println("\tEnter Choice : ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("\tEnter New Company Name : ");
                    sc.nextLine();
                    String comp = sc.nextLine();
                    cars.get(n - 1).Company = comp;
                    System.out.println("\tCompany Name Changed to " + comp);
                    break;
                case 2:
                    System.out.print("\tEnter New Model Name : ");
                    sc.nextLine();
                    String mod = sc.nextLine();
                    cars.get(n - 1).Model = mod;
                    System.out.print("\tCar Model Changed to " + mod);
                    break;
                case 3:
                    System.out.print("\tEnter New Car Number : ");
                    int cno = sc.nextInt();
                    cars.get(n - 1).CarNo = cno;
                    System.out.print("\tCar Number Changed to " + cno);
                    break;
                case 4:
                    System.out.print("\tEnter New Price Per Day : ");
                    int ppd = sc.nextInt();
                    cars.get(n - 1).priceperday = ppd;
                    break;
                case 5:
                    System.out.print("\tEnter New Availablity : ");
                    int ava = sc.nextInt();
                    cars.get(n - 1).avail = ava;
                    break;
                case 6:
                    return;
                default:
                    System.out.println("\tInvalid Input");
            }

            if (ch == 1 || ch == 2 || ch == 3 || ch == 4 || ch == 5)
                storeCars();

        } else
            System.out.println("\tInvalid Input!");

        System.out.println("\t\nPress enter to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void userLogin() {
        int usOp = 0;
        while (true) {
            System.out.print("\n");
            System.out.println("\t_________________________________");
            System.out.println("\t----- Welcome to User Login -----");
            System.out.println("\t_________________________________");
            System.out.println("\t1.User Sign Up");
            System.out.println("\t2.User Sign In");
            System.out.println("\t3.Exit");
            System.out.print("\tEnter Choice : ");
            usOp = sc.nextInt();
            if (usOp == 1) {
                userSignUp();
            } else if (usOp == 2) {
                userSignIn();
            } else if (usOp == 3) {
                return;
            } else {
                System.out.println("\tInvalid Input!");
                System.out.println("\t\nPress enter to continue.");
                try {
                    System.in.read();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    static void userSignUp() {
        System.out.print("\n");
        System.out.println("\t___________________________________");
        System.out.println("\t----- Welcome to User Sign Up -----");
        System.out.println("\t___________________________________");
        System.out.println("\tEnter Your Mobile No : ");
        sc.nextLine();
        String uPhoneNo = sc.nextLine();
        boolean flag = true;

        for (User u : user) {
            if (uPhoneNo.equals(u.phoneNo)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("\tEnter Your Name : ");
            String uName = sc.nextLine();
            System.out.println("\tEnter Your Password : ");
            String uPassword = sc.nextLine();

            User us = new User(uName, uPassword, uPhoneNo);
            user.add(us);

            System.out.println("\tAccount Created Successfully!");
            storeUsers();
        } else
            System.out.println("\tThis mobile number already has an account!");

        System.out.println("\nPress enter to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void userSignIn() {
        System.out.print("\n");
        System.out.println("\t___________________________________");
        System.out.println("\t----- Welcome to User Sign In -----");
        System.out.println("\t___________________________________");
        System.out.print("\tEnter Your Phone Number : ");
        sc.nextLine();
        String uPhoneNo = sc.nextLine();
        System.out.print("\tEnter Your Password : ");
        String uPassword = sc.nextLine();
        int pro = 0;
        for (User u : user) {
            if (u.phoneNo.equals(uPhoneNo) && u.password.equals(uPassword)) {
                System.out.println("\tLogged In Successfully!!!");
                UserFunction();
                pro++;
                break;
            }
        }
        if (pro == 0) {
            System.out.println("\tLogin Failed \nPlease Retry!!!");
            System.out.println("\t\nPress enter to continue.");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static void UserFunction() {
        int usCh = 0;
        while (true) {
            System.out.print("\n");
            System.out.println("\t_____________________________________");
            System.out.println("\t----- Welcome to User Main Menu -----");
            System.out.println("\t_____________________________________");
            System.out.println("\t1.View Cars and Availability");
            System.out.println("\t2.Rent a Car");
            System.out.println("\t3.Return a Car");
            System.out.println("\t4.Exit");
            System.out.print("\tEnter Choice : ");
            usCh = sc.nextInt();
            if (usCh == 1) {
                viewallCars();
            } else if (usCh == 2) {
                viewallCars();
                rentCar();
            } else if (usCh == 3) {
                viewallCars();
                returnCar();
            } else if (usCh == 4) {
                return;
            } else {
                System.out.println("Invalid Input");
                System.out.println("\nPress enter to continue.");
                try {
                    System.in.read();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    static void rentCar() {
        System.out.print("\n");
        System.out.println("\t________________");
        System.out.println("\t----- Rent -----");
        System.out.println("\t________________");
        System.out.print("\tEnter Car Serial Number to rent: ");
        int n = sc.nextInt();

        if (0 < n && n <= cars.size()) {
            if (cars.get(n - 1).avail == 0) {
                System.out.println("\tSorry!! Car Is Not Available.");
                System.out.println("\t\nPress enter to continue.");
                try {
                    System.in.read();
                } catch (IOException e) {
                    System.out.println(e);
                }
                return;
            }
            System.out.print("\tEnter Number Cars you want to take : ");

            int noOfCars = sc.nextInt();
            System.out.print("\tEnter Number of days you want to take : ");
            int days = sc.nextInt();
            int noOfavail = cars.get(n - 1).avail;

            if (noOfCars <= noOfavail) {
                System.out.print("\tCar Available.\n1. Continue 2. Exit\nEnter our Choice: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    cars.get(n - 1).avail = cars.get(n - 1).avail - noOfCars;
                    System.out.println("\tRented Successfully ");
                    System.out.println("\tTotal Bill = Rs." + (cars.get(n - 1).priceperday * days * noOfCars));
                } else
                    return;
            }
        }
    }

    static void returnCar() {
        System.out.print("\n");
        System.out.println("\t________________________");
        System.out.println("\t----- Return a Car -----");
        System.out.println("\t________________________");
        System.out.print("\tEnter Serial Number : ");
        int n = sc.nextInt();

        if (0 < n && n <= cars.size()) {

            System.out.println("Enter Number Cars you have taken : ");
            int noOfCars = sc.nextInt();
            cars.get(n - 1).avail = cars.get(n - 1).avail + noOfCars;
            System.out.println("Returned Successfully ");
        } else
            return;
    }

    public static void main(String[] args) {
        getAdmins();
        getUsers();
        getCars();

        int ch = 0;
        while (ch != 3) {
            System.out.print("\n");
            System.out.println("\t________________________________________");
            System.out.println("\t----- Welcome To Car Rental System -----");
            System.out.println("\t________________________________________");
            System.out.println("\t1.Admin Login");
            System.out.println("\t2.User Login");
            System.out.println("\t3.Exit");
            System.out.print("\tEnter Choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    System.out.println("Thanks for Using!");
                    System.exit(1);

                default:
                    System.out.println("Invalid Input");
                    System.out.println("\nPress enter to continue.");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
            }
        }
    }
}
