
    public class Owner {
        private int fldOwnerId;       // Identifier for the dog
        private String fldOwnerName;  // Name of the Dog
        private String fldDogBreed; // Name of the Dog Breed

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

        public Owner(int DogId, String DogName, String fldDogBreed) {
            this.fldDogId = fldDogId;
            this.fldDogName = fldDogName;
            this.fldDogBreed = fldDogBreed;

        }

        public Owner() {
        }



    }


