
    public class Dog {
        private Integer fldDogId;       // Identifier for the dog
        private String fldDogName;  // Name of the Dog
        private String fldDogBreed; // Name of the Dog Breed

        public Integer getFldDogId() {
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

        public Dog(Integer DogId, String DogName, String fldDogBreed) {
            this.fldDogId = fldDogId;
            this.fldDogName = fldDogName;
            this.fldDogBreed = fldDogBreed;

        }





    }


