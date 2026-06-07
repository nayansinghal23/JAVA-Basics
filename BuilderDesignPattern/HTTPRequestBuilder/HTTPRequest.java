package BuilderDesignPattern.HTTPRequestBuilder;

import java.util.Map;

public class HTTPRequest {
    // required
    private final HTTPMethods method;
    private final String url;
    // optional
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;
    
    public HTTPRequest(HTTPRequestBuilder httpRequestBuilder) {
        this.method = httpRequestBuilder.getMethod();
        this.url = httpRequestBuilder.getUrl();
        this.headers = httpRequestBuilder.getHeaders();
        this.body = httpRequestBuilder.getBody();
        this.timeout = httpRequestBuilder.getTimeout();
    }

    public static HTTPRequestBuilder builder() {
        return new HTTPRequestBuilder();
    }

    public void printRequest() {
        System.out.println("Method : " + method);
        System.out.println("URL : " + url);
        System.out.println("Headers : " + headers);
        System.out.println("Body : " + body);
        System.out.println("Timeout : " + timeout);
    }
}
