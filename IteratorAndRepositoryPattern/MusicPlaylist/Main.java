import iterators.BackwardIterator;
import iterators.ForwardIterator;

public class Main {
    public static void main()  {
        ForwardIterator forwardIterator = new ForwardIterator();
        BackwardIterator backwardIterator = new BackwardIterator();
        System.out.println(forwardIterator.next().getTitle());
        System.out.println(backwardIterator.next().getTitle());
        System.out.println(forwardIterator.next().getTitle());
        System.out.println(forwardIterator.next().getTitle());
        System.out.println(forwardIterator.next().getTitle());
        System.out.println(forwardIterator.next().getTitle());
        System.out.println(forwardIterator.next().getTitle());
        System.out.println(forwardIterator.next().getTitle());
    }
}
