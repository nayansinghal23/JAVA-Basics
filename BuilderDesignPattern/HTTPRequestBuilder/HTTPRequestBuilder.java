package BuilderDesignPattern.HTTPRequestBuilder;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequestBuilder {
    // required
    private HTTPMethods method = HTTPMethods.GET;
    private String URL = "";
    // optional
    private Map<String, String> headers = new HashMap<>();
    private String body = "";
    private int timeout = 10;

    public HTTPMethods getMethod() {
        return method;
    }

    public String getUrl() {
        return URL;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public int getTimeout() {
        return timeout;
    }

    public HTTPRequestBuilder method(HTTPMethods method) {
        this.method = method;
        return this;
    }

    public HTTPRequestBuilder url(String URL) {
        this.URL = URL;
        return this;
    }

    public HTTPRequestBuilder header(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public HTTPRequestBuilder body(String b) {
        this.body = b;
        return this;
    }

    public HTTPRequestBuilder timeout(int timer) {
        this.timeout = timer;
        return this;
    }

    public HTTPRequest build() {
        Validator.validate(this);
        return new HTTPRequest(this);
    }
}
