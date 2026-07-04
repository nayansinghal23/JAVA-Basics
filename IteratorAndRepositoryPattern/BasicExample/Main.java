public class Main {
    /**
     * Flow looks like this: Service layer -> Repository or DAO layer -> Database layer
     * In case the DB is migrated from SQL to NoSQL, we can easily migrate the Repository layer to the new DB layer without changing the Service layer.
     * If we use composition of Repository inside Service like "private final Repository repository;", this violates DIP as one concrete class is directly injected into another concrete class.
     * Instead, we should use abstraction (interface) for the Repository layer and inject the concrete implementation into the Service layer.
     */
    public static void main(String[] args) {
        InMemoryDatabase database = new InMemoryDatabase();
    }
}
