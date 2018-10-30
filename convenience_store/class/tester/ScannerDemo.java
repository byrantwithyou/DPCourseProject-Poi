package tester;


import tools.Scanner.RealScanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        String scanType;
        String scanObject;
        System.out.println("Please enter the scanType.\n");
        Scanner scanner = new Scanner(System.in);
        scanType = scanner.nextLine();
        System.out.println("Please enter the scanType.\n");
        scanObject = scanner.nextLine();
        tools.Scanner.Scanner realScanner = new RealScanner();
        realScanner.scan(scanType, scanObject);
    }
}
