package http;

import java.util.Map;

/**
 * This class represents a response.
 *
 * @author Mark Tripoli
 */
public class Response {

    private Map<String, String> headers;
    private String body;

    /**
     * Constructs a new response.
     *
     * @param headers
     *            the header map
     * @param body
     *            the body.
     */
    public Response(Map<String, String> headers, String body) {
        this.headers = headers;
        this.body = body;
    }


    /**
     * Returns the header map.
     *
     * @return the header map
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Returns the body.
     *
     * @return the body.
     */
    public String getBody() {
        return body;
    }

}
