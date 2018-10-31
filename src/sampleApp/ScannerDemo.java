package sampleApp;
//设计模式:Adapter

import java.util.Scanner;

import tools.scanner.RealScanner;

public class ScannerDemo {
    public static void main(String[] args) {
        String scanType;
        String scanObject;
        System.out.println("Please enter the scanType.");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        scanType = scanner.nextLine();
        System.out.println("Please enter the scanObject.");
        scanObject = scanner.nextLine();
        tools.scanner.Scanner realScanner = new RealScanner();
        realScanner.scan(scanType, scanObject);
    }
}
