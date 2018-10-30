package tester;


import tools.Scanner.RealScanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        String scanType;
        String scanObject;
        System.out.println("Please enter the scanType.");
        Scanner scanner = new Scanner(System.in);
        scanType = scanner.nextLine();
        System.out.println("Please enter the scanObject.");
        scanObject = scanner.nextLine();
        tools.Scanner.Scanner realScanner = new RealScanner();
        realScanner.scan(scanType, scanObject);
    }
}
