
    public class Walks {
        private int fldWalksId;       // Identifier for the dog
        private String fldWalksName;  // Name of the Dog
        private String fldWalksBreed; // Name of the Dog Breed


        public Walks(int WalksId, String WalksName, String fldDogBreed) {
            this.fldWalksId = fldWalksId;
            this.fldWalksName = fldWalksName;
            this.fldWalksBreed = fldWalksBreed;

        }

        public Walks() {
        }

        public int getFldWalksId() {
            return fldWalksId;
        }

        public void setFldWalksId(int fldWalksId) {
            this.fldWalksId = fldWalksId;
        }

        public String getFldWalksName() {
            return fldWalksName;
        }

        public void setFldWalksName(String fldWalksName) {
            this.fldWalksName = fldWalksName;
        }

        public String getFldWalksBreed() {
            return fldWalksBreed;
        }

        public void setFldWalksBreed(String fldWalksBreed) {
            this.fldWalksBreed = fldWalksBreed;
        }




    }


