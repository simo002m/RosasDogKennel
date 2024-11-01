import java.util.Scanner;

public class Walks {
        private int fldWalksID; // Identifier for Walks
        private String fldStartWalkTime;  // Start time
        private int fldTimeWalked; // Time of the walk
        private int fldKMwalked;// Distance of the walk
        private int fldDogID; //Identifier for Dog
        private String fldDateOfWalk; // Date of walk

        public Walks(int fldWalksID, String fldStartWalkTime, int fldTimeWalked,int fldKMwalked,int fldDogID, String fldDateOfWalk) {
            this.fldWalksID = fldWalksID;
            this.fldStartWalkTime = fldStartWalkTime;
            this.fldTimeWalked = fldTimeWalked;
            this.fldKMwalked = fldKMwalked;
            this.fldDogID = fldDogID;
            this.fldDateOfWalk = fldDateOfWalk;
        }

        public Walks() {
        }

        public int getFldWalksID() {
            return fldWalksID;
        }

        public void setFldWalksID(int fldWalksId) {
            this.fldWalksID = fldWalksId;
        }

        public String getFldStartWalkTime() {
            return fldStartWalkTime;
        }

        public void setFldStartWalkTime(String fldStartWalkTime) {
            this.fldStartWalkTime = fldStartWalkTime;
        }

        public int getFldTimeWalked() {
            return fldTimeWalked;
        }

        public void setFldTimeWalked(int fldTimeWalked) {
            this.fldTimeWalked = fldTimeWalked;
        }

        public int getFldKMwalked() {
            return fldKMwalked;
        }
         public void setFldKMwalked(int fldKMwalked) {
            this.fldKMwalked = fldKMwalked;
        }

        public int getFldDogId() {
            return fldDogID;
        }
         public void setFldDogID(int fldDogID) {
            this.fldDogID = fldDogID;
       }

        public String getFldDateOfWalk() {
            return fldDateOfWalk;
        }

        public void setFldDateOfWalk(String fldDateOfWalk) {
            this.fldDateOfWalk = fldDateOfWalk;
        }

        //Method to Read all Walks
        public static void userInterfaceReadAllWalks() {
            try {
                System.out.println("Viser alle gåture...");
                WalksDao dao2 = new WalksDaoImpl();
                dao2.readAllWalks();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //Method to Read walk information
        public static void userInterfaceReadWalk() {
            try {
                System.out.println("Indtast gåtur Id");
                Scanner sc = new Scanner(System.in);
                int id = sc.nextInt();
                sc.nextLine();
                WalksDao dao = new WalksDaoImpl();
                dao.readWalks(id);

            }catch (Exception f) {
                throw new RuntimeException(f);
            }

        }
        public static void userInterfaceCreateWalk() {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Laver en ny gåtur");
                System.out.println("Skriv gå tur ID");
                int fldwalksID = input.nextInt();
                input.nextLine();

                System.out.println("Skriv start tidspunkt");
                String fldStartWalkTime = input.nextLine();

                System.out.println("Skriv hvor lang tid gåturen varede i minutter");
                int fldTimeWalked = input.nextInt();
                input.nextLine();

                System.out.println("Skriv hvor mange KM");
                int fldKMwalked = input.nextInt();
                input.nextLine();

                System.out.println("Skriv hundens ID");
                int fldDogID = input.nextInt();
                input.nextLine();

                System.out.println("skriv hvilken dato turen blev gået");
                String fldDateOfWalk = input.nextLine();



                WalksDao dao1 = new WalksDaoImpl();
                Walks newWalk = new Walks(fldwalksID, fldStartWalkTime, fldTimeWalked, fldKMwalked, fldDogID,fldDateOfWalk);
                dao1.createWalks(newWalk);


            }catch (Exception g) {
                throw new RuntimeException(g);
            }
        }
}