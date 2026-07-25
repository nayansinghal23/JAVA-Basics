public class ValidateParamsHandler implements RequestHandler {
    private final RequestHandler next;

    public ValidateParamsHandler(RequestHandler next) {
        this.next = next;
    }

    @Override
    public void handle(RequestDTO request) {
        System.out.println("Validate request params handler");
        this.next.handle(request);
    }
}
