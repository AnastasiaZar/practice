package ru.stqa.pft.addressbook;

public class NewUsersData {
    private final String newusersfirstname;
    private final String newuserslastname;
    private final String newusersemail;

    public NewUsersData(String newusersfirstname, String newuserslastname, String newusersemail) {
        this.newusersfirstname = newusersfirstname;
        this.newuserslastname = newuserslastname;
        this.newusersemail = newusersemail;
    }

    public String getNewusersfirstname() {
        return newusersfirstname;
    }

    public String getNewuserslastname() {
        return newuserslastname;
    }

    public String getNewusersemail() {
        return newusersemail;
    }
}
