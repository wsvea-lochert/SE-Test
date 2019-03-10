package no.hiof.softwareEngineering.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EventOrganizer {
    private String name;
    private String organizerID;
    OrganizerAdminAccount admin;

    private ArrayList<OrganizerAdminAccount> adminAccountList = new ArrayList<>();
    private static ArrayList<EventOrganizer> eventOrganizerList = new ArrayList<>();
    private ArrayList<Event> organizerEvents = new ArrayList<>();

    public EventOrganizer(String name, String organizerID, OrganizerAdminAccount admin) {
        this.name = name;
        this.organizerID = organizerID;
        this.admin = admin;

        eventOrganizerList.add(this);
        adminAccountList.add(admin);
    }

    public EventOrganizer() {
    }

    /* ====== Getters and Setters ====== */
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

    /* ====== deffined functions ====== */

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

    public void createEvent(){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Event navn: ");
        String eventName = userInput.nextLine();
        System.out.print("Kategori: ");
        String category = userInput.nextLine();
        System.out.print("Beskrivelse: ");
        String description = userInput.nextLine();

        System.out.print("Dato(YYYY-MM-DD): ");
        String date = userInput.nextLine();

        System.out.print("By: ");
        String city = userInput.nextLine();
        System.out.print("Gate: ");
        String street = userInput.nextLine();

        System.out.print("Aldersgrense: ");
        int ageLimit = userInput.nextInt();
        System.out.print("Antall billetter: ");
        int tickets = userInput.nextInt();



        Event event = new Event(eventName, category, description, ageLimit, tickets, LocalDate.parse(date), new Location(city, street));
        organizerEvents.add(event);
        System.out.println(eventName + " er nå laget.");
    }

    public void printEvents(){
        for (Event event : organizerEvents){
            System.out.println(event + "\n");
        }
    }

    public void manageOrganizer(){

        Scanner userInput = new Scanner(System.in);
        int option = 0;

        while(option < 4){
            System.out.print("1: Lag nytt arrangement // 2: Lag ny administrator bruker // 3 print alle arrangementer: ");
            option = userInput.nextInt();
            switch (option){
                case 1:
                    createEvent();
                    break;
                case 2:
                    createNewAdmin();
                    break;
                case 3:
                    printEvents();
                    break;
            }
        }
    }


    @Override
    public String toString() {
        return "Navn: " + name + "\nArrangørID: " + organizerID + "\nHoved Admin brukernavn: " + admin.getUsername()
                + " \nNavn: " + admin.getAdministratorUser().getFirstname() + " " + admin.getAdministratorUser().getLastname();
    }
}
