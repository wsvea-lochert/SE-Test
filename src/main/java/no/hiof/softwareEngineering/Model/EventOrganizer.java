package no.hiof.softwareEngineering.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class EventOrganizer {
    private String name;
    private String organizerID;
    OrganizerAdminAccount admin;

    private ArrayList<OrganizerAdminAccount> adminAccountList = new ArrayList<>();
    private static ArrayList<EventOrganizer> eventOrganizerList = new ArrayList<>();

    public void createNewAdmin(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Fornavn: ");
        String firstname = userInput.nextLine();
        System.out.print("Etternavn: ");
        String lastname = userInput.nextLine();
        System.out.print("Brukernavn: ");
        String username = userInput.nextLine();
        System.out.print("Password: ");
        String password = userInput.nextLine();

        OrganizerAdminAccount admin = new OrganizerAdminAccount(new Person(firstname, lastname), username, password);
        adminAccountList.add(admin);
        System.out.println("Ny administrator bruker med brukernavn " + username + " er nå laget.");

    }

    public EventOrganizer(String name, String organizerID, OrganizerAdminAccount admin) {
        this.name = name;
        this.organizerID = organizerID;
        this.admin = admin;

        eventOrganizerList.add(this);
        adminAccountList.add(admin);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(String organizerID) {
        this.organizerID = organizerID;
    }

    public ArrayList<OrganizerAdminAccount> getAdminAccountList() {
        return adminAccountList;
    }

    public void setAdminAccountList(ArrayList<OrganizerAdminAccount> adminAccountList) {
        this.adminAccountList = adminAccountList;
    }

    public OrganizerAdminAccount getAdmin() {
        return admin;
    }

    public void setAdmin(OrganizerAdminAccount admin) {
        this.admin = admin;
    }

    public static ArrayList<EventOrganizer> getEventOrganizerList() {
        return eventOrganizerList;
    }

    public static void setEventOrganizerList(ArrayList<EventOrganizer> eventOrganizerList) {
        EventOrganizer.eventOrganizerList = eventOrganizerList;
    }

    @Override
    public String toString() {
        return "Navn: " + name + "\nID: " + organizerID + "Admin brukernavn: " + admin.getUsername()
                + " \nNavn: " + admin.getAdministratorUser().getFirstname() + " " + admin.getAdministratorUser().getLastname();
    }
}
