package no.hiof.softwareEngineering.Model;

import java.util.Scanner;

public class Login {

    public static EventOrganizer logInToSystem(){
        EventOrganizer dummy;
        Scanner userInput = new Scanner(System.in);

        for (int i = 0; i < 3; i++){
            System.out.print("Brukernavn: ");
            String inputUsername = userInput.nextLine();
            System.out.print("Passord: ");
            String inputPassword = userInput.nextLine();
            dummy = organizerValidation(inputUsername, inputPassword);
            if (dummy != null){
                return dummy;
            }
        }
        System.out.println("alle forsøk brukt opp, feil brukernavn eller passord. Prøv igjen senere eller kontakt administrator");
        return null;
    }

    public static EventOrganizer organizerValidation(String username, String password){
        for (EventOrganizer organizer : EventOrganizer.getEventOrganizerList()){
            if(username.equals(organizer.admin.getUsername()) && password.equals(organizer.admin.getPassword())){
                System.out.println("\nDu er nå logget inn!\n");
                return organizer;
            }
        }
        System.out.println("Brukernavn eller passord feil;");
        return null;
    }
}
