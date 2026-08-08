import enums.EvictionPolicy;
import facade.CacheFacade;

public class Main {
    public static void main() {
        CacheFacade.cache(EvictionPolicy.LRU, 2);
    }   
}
