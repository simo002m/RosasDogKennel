package dog;

import java.util.Scanner;


public class Dog {
    //Attributes for Dog Class, describing the dogs properties
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


    //Getters and setters for all the properties
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

    //Constructor to initialize a Dog Object with all attributes
    public Dog(int fldOwnerID, int fldDogId, String fldDogName, int fldYearBorn, double fldWeight,
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
    //empty constructor if attributes isn't known when made. (used in DogDaoImpl)
    public Dog() {
    }

    //Method to Read all Dogs
    public static void userInterfaceReadAllDogs() {
        try {
            System.out.println("Viser alle hunde");
            DogDao dao2 = new DogDaoImpl();// makes a new DogDao implementation
            dao2.readAllDogs();//method to read all dogs
        } catch (Exception e) {
            throw new RuntimeException(e);//handles the exceptions
        }
    }

        //Method to Read a dogs information
        public static void userInterfaceReadDog() {
            try {
                System.out.println("Indtast hundens Id");//prompt
                Scanner sc = new Scanner(System.in);
                int id = sc.nextInt();
                sc.nextLine();//clears line break
                DogDao dao = new DogDaoImpl();
                dao.readDog(id);

            }catch (Exception f) {
                throw new RuntimeException(f);//handles the exceptions
            }

        }
        //method to create a dog
        public static void userInterfaceCreateDog() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Laver en ny hund");
            //asks the user for all necessary data
            System.out.println("Skriv ejerens Id");
            int fldOwnerID = input.nextInt();
            input.nextLine();

            System.out.println("Skriv hundens ID");
            int fldDogId = input.nextInt();
            input.nextLine();

            System.out.println("Skriv hundens navn");
            String fldDogName = input.nextLine();

            System.out.println("Skriv hundens fødselsårstal");
            int fldYearBorn = input.nextInt();
            input.nextLine();

            System.out.println("Skriv hundens vægt i kg");
            double fldWeight = input.nextDouble();
            input.nextLine();

            System.out.println("Skriv hundens race");
            String fldDogBreed = input.nextLine();

            System.out.println("Skriv hvis din hund har nogle speicelle behov");
            String fldSpecialNeeds = input.nextLine();

            System.out.println("Skriv hvilken Dato hunden ankommer");
            String fldDateArrived = input.nextLine();

            System.out.println("Skriv hvor mange dage hunden skal blive her");
            int fldExpectedStayDays = input.nextInt();
            input.nextLine();

            System.out.println("Er hunden vaccineret?");
            String fldVaccinated = input.nextLine();

            System.out.println("Er hunden loppe behandlet?");
            String fldFleeTreatment = input.nextLine();

            System.out.println("Er hunden forsikret?");
            String fldInsured = input.nextLine();

            System.out.println("Hvilken læge skal der ringes til hvis der sker noget?");
            String fldPrefferedVet = input.nextLine();

            System.out.println("Hvilken slags foder skal hunden have under opholdet?");
            System.out.println("Vælg mellem Standard tørfoder, tørfoder til unge hunde, tørfoder til gamlehunde, luksusfoder eller diætfoder ");
            String fldFoodType = input.nextLine();

            System.out.println("Hvor meget skal din hund have at spise om dagen i gram");
            int fldRecAmountInGram = input.nextInt();
            input.nextLine();

            //Makes a Dog-object with the given data
            DogDao dao1 = new DogDaoImpl();
            Dog newDog = new Dog(fldOwnerID, fldDogId, fldDogName, fldYearBorn, fldWeight, fldDogBreed,
                    fldSpecialNeeds, fldDateArrived, fldExpectedStayDays, fldVaccinated, fldFleeTreatment,
                    fldInsured, fldPrefferedVet, fldFoodType, fldRecAmountInGram);
            dao1.createDog(newDog);//Saves the dog in the database

        }catch (Exception g) {
            throw new RuntimeException(g);//handles the exceptions
        }
    }
}



