package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.security.HashFunction;

public class User {



    private String lastName;
    private String firstName;
    private String password;
    private String emailAddress;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = HashFunction.sha(password);
    }

    public String getPassword() {
        return password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
