import java.util.List;

public interface WalksDao {
        void readWalks(int no) throws Exception;
        void readAllWalks() throws Exception;
        void createWalks(Walks walks) throws Exception;
}



