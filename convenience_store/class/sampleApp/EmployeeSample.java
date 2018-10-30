package sampleApp;

import workers.Manager;
import workers.Staff;

import java.util.Scanner;

public class EmployeeSample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Manager manager = new Manager("45530","Gary");
        manager.printOut();
        System.out.println("Please enter the staff you want to add, id and name: ");

        String id = "";
        String name = "";
        char choice = 'y';
        while (choice == 'y'){
            String s = in.nextLine();
            String[] ss = s.split(" ");
            id = ss[0];
            name = ss[1];
            Staff newStaff = manager.addFollower(id,name);
            manager.printOut();
            System.out.println("Continue to add? [y/n]");
            choice = in.nextLine().charAt(0);
        }
    }
}
