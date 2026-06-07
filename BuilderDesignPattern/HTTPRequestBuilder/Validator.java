package BuilderDesignPattern.HTTPRequestBuilder;

// Can implement in a better way via Strategy Design Pattern
public class Validator {
    public static void validate(HTTPRequestBuilder builder) {
        Validator.globalValidations(builder);
        if(builder.getMethod() == HTTPMethods.GET) Validator.getMethodValidations(builder);
        if(builder.getMethod() == HTTPMethods.POST) Validator.postMethodValidations(builder);
        if(builder.getMethod() == HTTPMethods.PUT) Validator.putMethodValidations(builder);
        if(builder.getMethod() == HTTPMethods.PATCH) Validator.patchMethodValidations(builder);
        if(builder.getMethod() == HTTPMethods.DELETE) Validator.deleteMethodValidations(builder);
    }

    private static void globalValidations(HTTPRequestBuilder builder) {
        if(builder.getUrl().isEmpty() || !builder.getUrl().startsWith("https://")) throw new IllegalArgumentException("Request must contain valid URL.");
    }

    private static void getMethodValidations(HTTPRequestBuilder builder) {
        if(!builder.getBody().isEmpty()) throw new IllegalArgumentException("GET request does not include a body.");
    }

    private static void postMethodValidations(HTTPRequestBuilder builder) {
        if(builder.getBody().isEmpty()) throw new IllegalArgumentException("POST request must contain some body.");
    }

    private static void putMethodValidations(HTTPRequestBuilder builder) {}

    private static void patchMethodValidations(HTTPRequestBuilder builder) {}

    private static void deleteMethodValidations(HTTPRequestBuilder builder) {}
}
