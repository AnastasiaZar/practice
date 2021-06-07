package ru.stqa.pft.addressbook;

public class newuserdata {
    private final String userfirstname;
    private final String userlastname;
    private final String useremail;

    public newuserdata(String userfirstname, String userlastname, String useremail) {
        this.userfirstname = userfirstname;
        this.userlastname = userlastname;
        this.useremail = useremail;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public String getUseremail() {
        return useremail;
    }
}