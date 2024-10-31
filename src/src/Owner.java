import java.util.Scanner;

public class Owner {
    static OwnerDao dao = new OwnerDaoImpl();

    // Instance variables
    private int fldOwnerID;
    private String fldOwnerName;
    private String fldDateOfBirth;
    private String fldEmail;
    private String fldPhoneNumber;
    private String fldZipCode;

    public Owner(int fldOwnerID ,String fldOwnerName, String fldDateOfBirth, String fldEmail, String fldPhoneNumber, String fldZipCode) {
        this.fldOwnerID = fldOwnerID;
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

    public String getFldDateOfBirth() {
        return fldDateOfBirth;
    }

    public void setFldDateOfBirth(String fldDateOfBirth) { this.fldDateOfBirth = fldDateOfBirth; }

    public String getFldEmail() {
        return fldEmail;
    }

    public void setFldEmail(String fldEmail) { this.fldEmail = fldEmail; }

    public String getFldPhoneNumber() {
        return fldPhoneNumber;
    }

    public void setFldPhoneNumber(String fldPhoneNumber) { this.fldPhoneNumber = fldPhoneNumber; }

    public String getFldZipCode() {
        return fldZipCode;
    }

    public void setFldZipCode(String fldZipCode) { this.fldZipCode = fldZipCode; }


    public static void interfaceReadOwner() throws Exception {
        Scanner choice = new Scanner(System.in);

        System.out.println("Vælg en ejer");
        int ownerChoice = choice.nextInt();

        dao.readOwner(ownerChoice);
    }

    public static void interfaceCreateOwner() throws Exception {
        Scanner choice = new Scanner(System.in);

        System.out.println("Lav en ny ejer\n");

        System.out.print("Indtast ID: ");
        int ownerID = choice.nextInt();
        choice.nextLine();

        System.out.print("Indtast navn: ");
        String ownerName = choice.nextLine();

        System.out.print("Indtast fødselsdag: ");
        String ownerBirthday = choice.nextLine();

        System.out.print("indtast email: ");
        String ownerEmail = choice.nextLine();

        System.out.print("Indtast ejer telefonnummer: ");
        String ownerPhoneNr = choice.nextLine();

        System.out.print("Indtast ejer post nr: ");
        String ownerZipcode = choice.nextLine();

        dao.createOwner(new Owner(ownerID, ownerName, ownerBirthday, ownerEmail, ownerPhoneNr, ownerZipcode));
    }

}