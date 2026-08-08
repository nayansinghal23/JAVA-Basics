import enums.EvictionPolicy;
import facade.CacheFacade;

public class Main {
    public static void main(String[] args) {
        CacheFacade.cache(EvictionPolicy.LRU, 2);
    }   
}
