class Inventory {
    private int availableRooms;

    public Inventory(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    // Take intrensic lock to prevent double book
    public synchronized boolean tryReserveRoom() {
        if(availableRooms <= 0) return false;
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        availableRooms--;
        return true;
    }
}

// Simulating 2 users trying to book the same room at same time - double book by multiple users
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory(1);
        Runnable book = () -> inventory.tryReserveRoom();
        
        Thread thread1 = new Thread(book, "Thread-1");
        Thread thread2 = new Thread(book, "Thread-2");
        
        thread1.start();
        thread2.start();

        thread1.join(); // join() means Main thread, wait until thread1 is done
        thread2.join(); // join() means Main thread, wait until thread2 is done
        
        System.out.println("Available rooms : " + inventory.getAvailableRooms());
    }
}