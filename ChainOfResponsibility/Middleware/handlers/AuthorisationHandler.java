public class AuthorisationHandler implements RequestHandler {
    private final RequestHandler next;

    public AuthorisationHandler(RequestHandler next) {
        this.next = next;
    }

    @Override
    public void handle(RequestDTO request) {
        System.out.println("Authorisation handler");
        this.next.handle(request);
    }
}
