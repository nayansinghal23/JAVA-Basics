public class AuthenticationHandler implements RequestHandler {
    private final RequestHandler next;

    public AuthenticationHandler(RequestHandler next) {
        this.next = next;
    }

    @Override
    public void handle(RequestDTO request) {
        System.out.println("Authentication handler");
        this.next.handle(request);
    }
}
