package dtos.requests;

public class RegisterUserRequest {

    private String firstName;
    private String lastName;
    private String homeAddress;
    private String emailAddress;
    private String phoneNumber;
    private String nationality;
    private int age;
//    private String voter_sIdentificationNumber;
    private String password;


    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    private String jobDescription;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getVoter_sIdentificationNumber() {
//        return voter_sIdentificationNumber;
//    }

//    public void setVoter_sIdentificationNumber(String voter_sIdentificationNumber) {
//        this.voter_sIdentificationNumber = voter_sIdentificationNumber;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }


//    public String getJobDescription() {
//    }
}
