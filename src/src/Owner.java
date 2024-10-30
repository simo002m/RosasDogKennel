import java.sql.Date;

public class Owner {
    private int fldOwnerID;
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
            return fldOwnerID;
        }

    public void setFldOwnerID(int fldOwnerID) {
        this.fldOwnerID = fldOwnerID;
    }

    public String getFldOwnerName() {
        return fldOwnerName;
    }

    public void setFldOwnerName(String fldOwnerName) {
        this.fldOwnerName = fldOwnerName;
    }

    public Date getFldDateOfBirth() {
        return fldDateOfBirth;
    }

    public void setFldDateOfBirth(Date fldDateOfBirth) { this.fldDateOfBirth = fldDateOfBirth; }

    public String getFldEmail() {
        return fldEmail;
    }

    public void setEmail(String fldEmail) { this.fldEmail = fldEmail; }

    public String getFldPhoneNumber() {
        return fldPhoneNumber;
    }

    public void setFldPhoneNumber(String fldPhoneNumber) { this.fldPhoneNumber = fldPhoneNumber; }

    public String getFldZipCode() {
        return fldZipCode;
    }

    public void setFldZipCode(String fldZipCode) { this.fldZipCode = fldZipCode; }

}