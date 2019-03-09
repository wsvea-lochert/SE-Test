package no.hiof.softwareEngineering.Model;

public class OrganizerAdminAccount {
    private Person administratorUser;
    private String username;
    private String password;

    public OrganizerAdminAccount(Person administratorUser, String username, String password) {
        this.administratorUser = administratorUser;
        this.username = username;
        this.password = password;
    }

    public Person getAdministratorUser() {
        return administratorUser;
    }

    public void setAdministratorUser(Person admin) {
        this.administratorUser = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
