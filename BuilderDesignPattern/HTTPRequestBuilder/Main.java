package BuilderDesignPattern.HTTPRequestBuilder;

public class Main {
    public void main() {
        HTTPRequest request = HTTPRequest.builder().method(HTTPMethods.GET).url("https://www.xyz.com").header("Content-Type", "application/json").build();
        request.printRequest();
    }
}
