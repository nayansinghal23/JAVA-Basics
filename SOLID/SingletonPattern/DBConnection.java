package SOLID.SingletonPattern;

public class DBConnection {
    static private volatile DBConnection instance; // volatile ensures that objects are not assigned to variable before it is initialized completely.

    private DBConnection(String name) {
        System.out.println("Connection to DB is established by - " + name);
    }

    /*
    Synchronized keyword is used to make the method thread safe. It is a slow operation. Also, we need synchronization for first thread only. For remaining threads, we don't need synchronization.

    public static synchronized DBConnection getInstance(String name) {
        if(instance == null) {
            instance = new DBConnection(name);
        }
        return instance;
    }
    */
   
    // Instead of making the method synchronized, we can make a particular block synchronized - Double Checked Locking.
    public static DBConnection getInstance(String name) {
        if(instance == null) {
            synchronized(DBConnection.class) {
                if(instance == null) {
                    instance = new DBConnection(name);
                }
            }
        }
        return instance;
    }
}
