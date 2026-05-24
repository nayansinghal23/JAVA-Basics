package SOLID.RepositoryPattern;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final int totalRecords = 2000;
    private List<String> users = new ArrayList<>();

    Database() {
        this.seeder();
    }

    private void seeder() {
        for(int i = 1; i <= this.totalRecords; i++) {
            this.users.add("User " + i);
        }
    }

    public List<String> getUsers(int limit, int offset) {
        if(limit + offset > totalRecords) return new ArrayList<>();

        return this.users.subList(offset, offset + limit);
    }
}
