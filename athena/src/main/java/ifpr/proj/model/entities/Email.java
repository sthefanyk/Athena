package ifpr.proj.model.entities;

public class Email {

    private int emailID;
    private String email;
    
    public Email() {
    }
    public Email(int emailID, String email) {
        this.emailID = emailID;
        this.email = email;
    }
    public int getEmailID() {
        return emailID;
    }
    public void setEmailID(int emailID) {
        this.emailID = emailID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
