import java.sql.Date;

public class Dog {
    private int fldDogId;       // Identifier for the dog
    private String fldDogName;  // Name of the Dog
    private String fldDogBreed; // Name of the Dog Breed
    private int fldOwnerID; //Dogs owner ID
    private int fldYearBorn; //Dogs year of birth
    private double fldWeight; // dogs weight
    private String fldSpecialNeeds; // comments if it needs medication or other type of special needs
    private String fldDateArrived; // the Date the dog arrives
    private int fldExpectedStayDays; //the days the dog is expected to stay
    private String fldVaccinated; // is it Vaccinated
    private String fldFleeTreatment; //has it gotten Flee treatment
    private String fldInsured; //is it insured
    private String fldPrefferedVet; // who is the vet that should be called if the dog gets sick
    private String fldFoodType; //what kind of food should the dog get
    private int fldRecAmountInGram; //How much food should the dog get

    public String getFldFoodType() {
        return fldFoodType;
    }

    public void setFldFoodType(String fldFoodType) {
        this.fldFoodType = fldFoodType;
    }

    public int getFldYearBorn() {
        return fldYearBorn;
    }

    public void setFldYearBorn(int fldYearBorn) {
        this.fldYearBorn = fldYearBorn;
    }

    public int getFldOwnerID() {
        return fldOwnerID;
    }

    public void setFldOwnerID(int fldOwnerID) {
        this.fldOwnerID = fldOwnerID;
    }

    public double getFldWeight() {
        return fldWeight;
    }

    public void setFldWeight(double fldWeight) {
        this.fldWeight = fldWeight;
    }

    public String getFldSpecialNeeds() {
        return fldSpecialNeeds;
    }

    public void setFldSpecialNeeds(String fldSpecialNeeds) {
        this.fldSpecialNeeds = fldSpecialNeeds;
    }

    public String getFldDateArrived() {
        return fldDateArrived;
    }

    public void setFldDateArrived(String fldDateArrived) {
        this.fldDateArrived = fldDateArrived;
    }

    public int getFldExpectedStayDays() {
        return fldExpectedStayDays;
    }

    public void setFldExpectedStayDays(int fldExpectedStayDays) {
        this.fldExpectedStayDays = fldExpectedStayDays;
    }

    public String getFldVaccinated() {
        return fldVaccinated;
    }

    public void setFldVaccinated(String fldVaccinated) {
        this.fldVaccinated = fldVaccinated;
    }

    public String getFldFleeTreatment() {
        return fldFleeTreatment;
    }

    public void setFldFleeTreatment(String fldFleeTreatment) {
        this.fldFleeTreatment = fldFleeTreatment;
    }

    public String getFldInsured() {
        return fldInsured;
    }

    public void setFldInsured(String fldInsured) {
        this.fldInsured = fldInsured;
    }

    public String getFldPrefferedVet() {
        return fldPrefferedVet;
    }

    public void setFldPrefferedVet(String fldPrefferedVet) {
        this.fldPrefferedVet = fldPrefferedVet;
    }

    public int getFldRecAmountInGram() {
        return fldRecAmountInGram;
    }

    public void setFldRecAmountInGram(int fldRecAmountInGram) {
        this.fldRecAmountInGram = fldRecAmountInGram;
    }

    public int getFldDogId() {
        return fldDogId;
    }

    public void setFldDogId(Integer fldDogId) {
        this.fldDogId = fldDogId;
    }

    public String getFldDogName() {
        return fldDogName;
    }

    public void setFldDogName(String fldDogName) {
        this.fldDogName = fldDogName;
    }

    public String getFldDogBreed() {
        return fldDogBreed;
    }

    public void setFldDogBreed(String fldDogBreed) {
        this.fldDogBreed = fldDogBreed;
    }

    public Dog(int fldOwnerID, int fldDogId, String fldDogName, int fldYearBorn, float fldWeight,
               String fldDogBreed, String fldSpecialNeeds, String fldDateArrived, int fldExpectedStayDays,
               String fldVaccinated, String fldFleeTreatment, String fldInsured, String fldPrefferedVet, String fldFoodType, int fldRecAmountInGram) {
        this.fldDogId = fldDogId;
        this.fldDogName = fldDogName;
        this.fldDogBreed = fldDogBreed;
        this.fldOwnerID = fldOwnerID;
        this.fldYearBorn = fldYearBorn;
        this.fldWeight = fldWeight;
        this.fldSpecialNeeds = fldSpecialNeeds;
        this.fldDateArrived = fldDateArrived;
        this.fldExpectedStayDays = fldExpectedStayDays;
        this.fldVaccinated = fldVaccinated;
        this.fldFleeTreatment = fldFleeTreatment;
        this.fldInsured = fldInsured;
        this.fldPrefferedVet = fldPrefferedVet;
        this.fldFoodType = fldFoodType;
        this.fldRecAmountInGram = fldRecAmountInGram;


    }

    public Dog() {
    }
}



