public class RequestHandlerFactory {
    public static RequestHandler getRequestHandlerForCreateTodo() {
        return new ValidateBodyHandler(
            new ValidateParamsHandler(
                new AuthenticationHandler(
                    new AuthorisationHandler(
                        new FinishingHandler()
                    )
                )
            )
        );
    }
}
