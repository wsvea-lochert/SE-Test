package no.hiof.softwareEngineering;

import no.hiof.softwareEngineering.Model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       /* Event soppturMedKarpe = new Event("Sopptur med Karpe","Musikk", "En fin konsert med bra musikk", 18, 150, LocalDate.of(2019, 06, 19), new Location("Halden", "B R A veien 6d"));*/

        OrganizerAdminAccount admin = new OrganizerAdminAccount(new Person("William", "Svea-Lochert"), "admin", "admin");
        EventOrganizer test = new EventOrganizer("Karpe", "KarpeD1112", admin);

        // System.out.println(test);

        //test.createNewAdmin();
        /*

        tempOrganizer = Login.logInToSystem();
        tempOrganizer.createNewAdmin();

        System.out.println(tempOrganizer);*/
        runAppliocationV2();

      //  runApplication();
    }

    private static void runAppliocationV2(){
        EventOrganizer tempOrganizer;
        Scanner userInput = new Scanner(System.in);
        int option = 0;

        while(option < 3){
            System.out.print("1: login // 2: donno yet // 3 donno yet: ");
            option = userInput.nextInt();
            switch (option){
                case 1:
                    tempOrganizer = Login.logInToSystem();
                    if (tempOrganizer != null){
                        tempOrganizer.manageOrganizer();
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }
}
