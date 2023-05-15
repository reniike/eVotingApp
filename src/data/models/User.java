package data.models;

public class User {
    private int voter_sIdentificationNumber;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String jobDescription;
    private String nationality;
    private int age;
    private String password;
    private String address;
    private int vote;

//    public boolean getVote() {
//        return Poll;
//    }

//    public void setVote(boolean vote) {
//        Poll = vote;
//    }


    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVoter_sIdentificationNumber() {
        return voter_sIdentificationNumber;
    }

    public void setVoter_sIdentificationNumber(int voter_sIdentificationNumber) {
        this.voter_sIdentificationNumber = voter_sIdentificationNumber;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

//    public String getVoter_sIdentificationNumber() {
//        return voter_sIdentificationNumber;
//    }
//
//    public void setVoter_sIdentificationNumber(String voter_sIdentificationNumber) {
//        this.voter_sIdentificationNumber = voter_sIdentificationNumber;
//    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(voter_sIdentificationNumber);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
//        sb.append(", voter_sIdentificationNumber='").append(voter_sIdentificationNumber).append('\'');
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
