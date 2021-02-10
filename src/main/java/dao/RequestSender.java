package dao;

import http.Request;
import http.Response;

import java.io.IOException;

/**
 * An RequestSender is able to send a request by passing the URL to it. After
 * processing the request a response is returned.
 *
 * @author Mark Tripoli
 */
public interface RequestSender {

    /**
     * Sends the request and returns the received response.
     *
     * @param request the request which will be send
     * @return the received response
     * @throws IOException if an error occurred
     */
    Response sendRequest(Request request) throws IOException;
}