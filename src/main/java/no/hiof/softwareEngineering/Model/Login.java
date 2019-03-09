package no.hiof.softwareEngineering.Model;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Login {

    public static void logInToSystem(){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Brukernavn: ");
        String inputUsername = userInput.nextLine();
        System.out.print("Passord: ");
        String inputPassword = userInput.nextLine();

        for (EventOrganizer event : EventOrganizer.getEventOrganizerList()){
            if (inputUsername.equals(event.admin.getUsername()) && inputPassword.equals(event.admin.getPassword())){
                System.out.println("Yea boooiiii");
            }
        }
    }

}
