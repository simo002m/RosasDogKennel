import java.util.Date;

public class Walks {
        private int fldWalksID; // Identifier for Walks
        private String fldStartWalkTime;  // Start time
        private int fldTimeWalked; // Time of the walk
        private int fldKMwalked;// Distance of the walk
        private int fldDogID; //Identifier for Dog
        private Date fldDateOfWalk; // Date of walk

        public Walks(int WalksID, String StartWalkTime, int fldTimeWalked,int fldKMwalked,int fldDogID, Date fldDateOfWalk) {
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

        public int getFldDogID() {
            return fldDogID;
        }

        public Date getFldDateOfWalk() {
            return fldDateOfWalk;
        }
}


