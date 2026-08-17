import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Inventory {
    private int availableRooms;
    private final Lock lock = new ReentrantLock(true);

    public Inventory(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public boolean tryReserveRoom() {
        System.out.println(Thread.currentThread().getName() + " is trying to reserve a room");
        lock.lock();
        try {
            if(availableRooms <= 0) return false;
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
            availableRooms--;
            System.out.println(Thread.currentThread().getName() + " has reserved a room");
            return true;
        } catch (Exception e) {
            lock.unlock();
            return false;
        }
    }
}

public class Demo2 {
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
