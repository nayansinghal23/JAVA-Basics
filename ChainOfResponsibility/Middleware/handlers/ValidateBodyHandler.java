public class ValidateBodyHandler implements RequestHandler {
    private final RequestHandler next;

    public ValidateBodyHandler(RequestHandler next) {
        this.next = next;
    }

    @Override
    public void handle(RequestDTO request) {
        System.out.println("Validate body handler");
        this.next.handle(request);
    }
}
