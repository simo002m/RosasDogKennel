
    public class Walks {
        private int fldWalksId;       // Identifier for the dog
        private String fldWalksName;  // Name of the Dog
        private String fldWalksBreed; // Name of the Dog Breed

        public int getFldWalksId() {
            return fldWalksId;
        }

        public void setFldDogId(Integer fldDogId) {
            this.fldWalksId = fldDogId;
        }

        public String getFldDogName() {
            return fldWalksName;
        }

        public void setFldDogName(String fldDogName) {
            this.fldDogName = fldDogName;
        }

        public String getFldDogBreed() {
            return fldWalksBreed;
        }

        public void setFldDogBreed(String fldDogBreed) {
            this.fldWalksBreed = fldDogBreed;
        }

        public Walks(int DogId, String DogName, String fldDogBreed) {
            this.fldDogId = fldDogId;
            this.fldDogName = fldDogName;
            this.fldDogBreed = fldDogBreed;

        }

        public Walks() {
        }



    }


