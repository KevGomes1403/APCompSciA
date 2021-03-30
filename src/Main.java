import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What class do you want to test out? ");
        System.out.println("  1. PivotString ");
        System.out.println("  2. BinarytoString ");
        System.out.println("  3. Vehicle ");
        System.out.println("  4. Dashboard ");
        System.out.println("  5. Boxcar ");
        System.out.println("  6. FreightTrain ");
        System.out.println("  7. Checker Board ");

        int user = sc.nextInt();

        if (user == 1) {
            pivotStringTest();
        } else if (user == 2) {
            binaryToStringTest();
        } else if (user == 3) {
            vehicleTest();
        } else if (user == 4) {
            dashboardTest();
        } else if (user == 5) {
            boxcarTest();
        } else if (user == 6) {
            freightTrainTest();
        } else if (user == 7) {
            checkersTest();
        }
    }

    public static void checkersTest() {
        Gameboard blank = new Gameboard(false);
        System.out.println("Printing blank gameboard:\n" + blank + "\n");

        Gameboard filled = new Gameboard(true);
        System.out.println("Printing game-ready gameboard:\n" + filled + "\n");

        System.out.println("Testing move method for both colors:");
        System.out.println("Testing move left:");
        filled.move(5,2,true);
        filled.move(2,5,true);
        System.out.println(filled.toString());
        System.out.println("Testing move right:");
        filled.move(6,1,false);
        filled.move(1,6,false);
        System.out.println(filled.toString());
        System.out.println("Testing can't move:");
        System.out.println("" + filled.move(5,0,false));
        System.out.println("" + filled.move(2,7,false));

        System.out.println("Testing jump:");
        Gameboard a = new Gameboard(false);
        a.board[7][0] = 'w'; a.board[6][1] = 'r'; a.board[0][7] = 'r'; a.board[1][6] = 'w';
        a.jump(7,0); a.jump(0,7);
        System.out.println(a.toString());

        System.out.println("Testing multiple jumps:");
        Gameboard b = new Gameboard(false);
        b.board[7][0] = 'w'; b.board[6][1] = 'r'; b.board[0][7] = 'r'; b.board[1][6] = 'w';
        b.board[4][1] = 'r'; b.board[3][6] = 'w'; b.board[2][1] = 'r';
        b.jump(7,0); b.jump(0,7);
        System.out.println(b.toString());

        System.out.println("Testing kingMe:");
        Gameboard c = new Gameboard(false);
        c.board[7][2] = 'r'; c.board[0][5] = 'w';
        c.kingMe(7,2); c.kingMe(0,5);
        System.out.println(c.toString());
    }

    public static void pivotStringTest() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input String: ");
        String test = sc.nextLine();

        System.out.println("Pivot String: ");
        String pivot = sc.nextLine();

        String output = PivotString.pivoting(test, pivot);
        System.out.println("Output String: " + output + "\n");
    }

    public static void binaryToStringTest() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Binary: ");
        String bin = sc.nextLine();

        String txt = BinarytoString.binaryToText(bin);
        System.out.println("Text: " + txt + "\n");
    }

    public static void vehicleTest() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Location of Vehicle (-20 to 20): ");
        int loc = sc.nextInt();

        Vehicle veh = new Vehicle(loc);
        System.out.println("\n" + veh);

        while (true) {
            System.out.println("\n1. Move Forward\n2. Move Backward\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                veh.forward();
            } else if (choice == 2){
                veh.backward();
            } else {
                break;
            }

            System.out.println("\n" + veh);
        }

    }

    public static void dashboardTest() {
        Dashboard a = new Dashboard(1250, 50);
        Dashboard b = new Dashboard(1250, 60);
        Dashboard c = new Dashboard(99999, 75);
        Dashboard d = new Dashboard(99999, 75);
        Dashboard e = new Dashboard(0, 75);

        System.out.println("Printing Dashboard:\n" + a + "\n");

        System.out.println("Comparing two dashboards:");
        System.out.println("" + b.compareTo(c)); //b is less than c
        System.out.println("" + b.compareTo(a)); //b is greater than a
        System.out.println("" + c.compareTo(d)); //c and d are equal
        c.drive(60); //c stalls because total milage is over 100,000; odometer set to 0, checkEngine set to true
        System.out.println("" + e.compareTo(c)); //e is less than c because c's checkEngine is on

        System.out.println("\nTesting race:");
        System.out.println("\nRace 1: Car 1 stalls");
        Dashboard racer1 = new Dashboard(1250, 50);
        Dashboard racer2 = new Dashboard(1250, 50);
        System.out.println(racer1.race(racer2, 55, 30));

        System.out.println("\nRace 2: Both cars stall");
        Dashboard racer3 = new Dashboard(1250, 50);
        Dashboard racer4 = new Dashboard(1250, 50);
        System.out.println(racer3.race(racer4, 55, 60));

        System.out.println("\nRace 3: Neither car stalls");
        Dashboard racer5 = new Dashboard(1250, 50);
        Dashboard racer6 = new Dashboard(1250, 50);
        System.out.println(racer5.race(racer6, 30, 20));

        System.out.println("\nRace 4: Neither car stalls, both have same speed");
        Dashboard racer7 = new Dashboard(1250, 50);
        Dashboard racer8 = new Dashboard(1250, 50);
        System.out.println(racer7.race(racer8, 20, 20));

        System.out.println("\nTesting difference:");
        Dashboard car1 = new Dashboard(1500, 50);
        Dashboard car2 = new Dashboard(1250, 50);
        Dashboard car3 = new Dashboard(1190, 60);

        System.out.println(car1.difference(car2));
        System.out.println(car3.difference(car2));
    }

    public static void boxcarTest() {
        //Testing various required behaviors of the Boxcar constructor
        System.out.println("Testing Boxcar constructors:");
        Boxcar car1 = new Boxcar();
        System.out.println("Printing Boxcar():\n" + car1 + "\n");
        Boxcar car2 = new Boxcar("widgets", 7, false);
        System.out.println("Printing Boxcar(\"widgets\", 7, false):\n" + car2 + "\n");
        Boxcar car3 = new Boxcar("WaDGeTs", 7, true);
        System.out.println("Testing lowercase cargo and setting cargo to 0 if in repair.\n");
        System.out.println("Printing Boxcar(\"WaDGeTs\", 7, true):\n" + car3 + "\n");
        Boxcar car4 = new Boxcar("OtherStuff", 7, false);
        System.out.println("Testing cargo other than accepted values.\n");
        System.out.println("Printing Boxcar(\"OtherStuff\", 7, true):\n" + car4 + "\n");

        // car2 is not burnt out. Lets call callForRepair on car2 and make sure it
        // gets marked for repair and set to 0 units.
        System.out.println("Testing callForRepair:");
        car2.callForRepair();
        System.out.println("Printing Boxcar called for repair:\n" + car2 + "\n");

        // Let's test the loadCargo() method. We'll make a new Boxcar with 7 gadgets, then load cargo until it reaches maximum capacity.
        Boxcar car5 = new Boxcar("gadgets", 7, false);
        car5.loadCargo();
        //car5 should print out with 8 gadgets
        System.out.println("Printing Boxcar with 8 gadgets:\n" + car5 + "\n");
        //now let's load cargo three more times. This should put the car over maximum capacity and should keep the cargo size at 10.
        car5.loadCargo();
        car5.loadCargo();
        car5.loadCargo();
        System.out.println("Printing Boxcar with 10 gadgets, tried to overload:\n" + car5 + "\n");
        //lastly, let's test to make sure we can't load cargo onto a Boxcar that is in repair, using car2.
        car2.loadCargo();
        System.out.println("Printing Boxcar in repair, can't load (0 cargo):\n" + car2 + "\n");

        System.out.println("Testing isFull:");
        //Let's test a full car and a non-full car to make sure they return true and false, respectively.
        Boxcar car6 = new Boxcar("gizmos", 10, false);
        Boxcar car7 = new Boxcar("widgets", 7, false);
        System.out.println("Printing isFull on full car:\n" + car6.isFull() + "\n");
        System.out.println("Printing isFull on non-full car:\n" + car7.isFull() + "\n");

        System.out.println("Testing getCargo:");
        //Let's make sure car7 returns "widgets" as its cargo.
        System.out.println("Printing getCargo on a \"widgets\" car:\n" + car7.getCargo() + "\n");

        System.out.println("Testing setCargo:");
        //Making sure it can set cargo to "gadgets"
        car7.setCargo("gadgets");
        System.out.println("Setting cargo to gadgets:\n" + car7 + "\n");
        //Testing it will convert cargo to lowercase
        car7.setCargo("WADGetS");
        System.out.println("Testing lowercase conversion (WADGetS -> wadgets):\n" + car7 + "\n");
        //Testing it will set cargo to "gizsmos" if a nonvalid cargo is entered
        car7.setCargo("onions");
        System.out.println("Testing invalid cargo type sets to gizmos (onions -> gizmos):\n" + car7 + "\n");
    }

    public static void freightTrainTest() {
        System.out.println("1. Test the default constructor FreightTrain()");
        FreightTrain train1 = new FreightTrain();
        System.out.println("Printing FreightTrain():\n" + train1 + "\n");

        System.out.println("\n2. Test the constructor FreightTrain(n)");
        FreightTrain emptyTrain = new FreightTrain(0);
        System.out.println("Printing emptyTrain (n=0):\n" + emptyTrain + "\n");
        FreightTrain negativeTrain = new FreightTrain(-7);
        System.out.println("Printing negativeTrain (n=-7):\n" + emptyTrain + "\n");
        FreightTrain trainWithFiveCars = new FreightTrain(5);
        System.out.println("Printing trainWithFiveCars (n=5):\n" + trainWithFiveCars + "\n");

        System.out.println("\n3. Test setCargo(String)");
        //trainWithFiveCars currently has all cars carrying gizmos. Change them to gadgets
        trainWithFiveCars.setCargo("gadgets");
        System.out.println("Printing trainWithFiveCars with cargo now gadgets:\n" + trainWithFiveCars + "\n");
        //now set trainWithFiveCars to cargo of "onions". Since this is invalid, it should set the cargo back to gizmos.
        trainWithFiveCars.setCargo("onions");
        System.out.println("Printing trainWithFiveCars with cargo of onions (back to gizmos):\n" + trainWithFiveCars + "\n");

        System.out.println("\n4. Test fillTrain()");
        //Let's fill train 1. All Boxcars should now contain a cargo of size 10.
        trainWithFiveCars.fillTrain();
        System.out.println("Printing trainWithFiveCars with all Boxcars full:\n" + trainWithFiveCars + "\n");

        System.out.println("\n5. Test callForRepair(n)");
        //Let's set the second car (index 1) of trainWithFiveCars to in repair.
        trainWithFiveCars.callForRepair(1);
        System.out.println("Printing trainWithFiveCars with second car in repair:\n" + trainWithFiveCars + "\n");

        System.out.println("\n6. Test setMultiCargo()");
        //Let's make a train of length 8, setMultiCargo on it, and make sure the cargo type alternates appropriately
        FreightTrain trainWithEightCars = new FreightTrain(8);
        trainWithEightCars.setMultiCargo();
        System.out.println("Printing multi Cargo 8-car train:\n" + trainWithEightCars + "\n");

    }
}