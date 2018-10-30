package tester;

import tools.AdDisplayBoard.AdDisplayBoard;
import tools.AdDisplayBoard.AdTerminal;
import tools.AdDisplayBoard.Advertisement;
import tools.AdDisplayBoard.PicAdvertisement;

import java.util.Scanner;

public class AdDisplayBoardDemo {
    public static void main(String[] args) {
        AdTerminal adTerminal = AdTerminal.getInstance();
        adTerminal.addAdDisplayBoard(new AdDisplayBoard());
        adTerminal.addAdDisplayBoard(new AdDisplayBoard());
        Advertisement advertisement = new PicAdvertisement();
        System.out.println("Please enter the brand of Ad:\n");
        String brand;
        String slogan;
        Scanner scanner = new Scanner(System.in);
        brand = scanner.nextLine();
        System.out.println("Please enter the slogan of Ad:\n");
        slogan = scanner.nextLine();
        adTerminal.showAd(advertisement);
    }
}
