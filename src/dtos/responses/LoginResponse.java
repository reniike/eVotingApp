package dtos.responses;

public class LoginResponse {
    private int voter_sIdentificationNumber;
    private String name;
    private String emailAddress;
//    private String votersIdentificationNumber;
    private String phoneNumber;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoter_sIdentificationNumber() {
        return voter_sIdentificationNumber;
    }

    public void setVoter_sIdentificationNumber(int voter_sIdentificationNumber) {
        this.voter_sIdentificationNumber = voter_sIdentificationNumber;
    }

//    public String getVotersIdentificationNumber() {
//        return votersIdentificationNumber;
//    }
//
//    public void setVotersIdentificationNumber(String votersIdentificationNumber) {
//        this.votersIdentificationNumber = votersIdentificationNumber;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        String response = "LoginResponse{" + "voter's identification number=" + voter_sIdentificationNumber +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
//                ", votersIdentificationNumber='" + votersIdentificationNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
        return response;
    }
}
