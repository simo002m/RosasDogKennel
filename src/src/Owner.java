import java.util.Date;

public class Owner {
        private int fldOwnerId;
        private String fldOwnerName;
        private Date fldDateOfBirth;
        private String fldEmail;
        private String fldPhoneNumber;
        private String fldZipCode;

    public Owner(String fldOwnerName, Date fldDateOfBirth, String fldEmail, String fldPhoneNumber, String fldZipCode) {
        this.fldOwnerName = fldOwnerName;
        this.fldDateOfBirth = fldDateOfBirth;
        this.fldEmail = fldEmail;
        this.fldPhoneNumber = fldPhoneNumber;
        this.fldZipCode = fldZipCode;
    }

    public Owner() {

    }

    public int getFldOwnerId() {
            return fldOwnerId;
        }

    public Date getFldDogBreed() {
        return fldDogBreed;
    }

    public String getFldDogName() {
            return fldDogName;
        }

    public void setFldDogName(String fldDogName) {
            this.fldDogName = fldDogName;
        }

    public void setFldDogBreed(String fldDogBreed) {
            this.fldDogBreed = fldDogBreed;
        }

}