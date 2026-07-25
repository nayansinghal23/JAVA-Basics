public class TodoController {
    private Todo createTodo(RequestDTO request) {
        RequestHandlerFactory.getRequestHandlerForCreateTodo().handle(request);
        return new Todo();
    }
}
