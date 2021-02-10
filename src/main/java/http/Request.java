package http;

/**
 * This class represents a request.
 *
 * @author Mark Tripoli
 */
public class Request {

    private String url;

    /**
     * Constructs a new request object.
     *
     * @param url the URL.
     */
    public Request(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}