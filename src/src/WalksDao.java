public interface WalksDao {
        void readDog(int no) throws Exception;
        void readAllDogs() throws Exception;
        void createdog(Dog dog) throws Exception;
    }


