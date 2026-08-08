package repository;

public class Disk implements Repository {

    @Override
    public void storeToDisk() {
        System.out.println("Storing cached data to disk");
    }
}
