package dao;

import http.Request;
import http.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * This class provides methods to send request to the web.
 *
 * @author Mark Tripoli
 */
public class HttpRequestSender implements RequestSender {

    /**
     * Default encoding is set to UTF-8.
     */
    public static final String ENCODING = "UTF-8";

    /**
     * Default timeout is set to 10 seconds.
     */
    public static final int TIMEOUT = 10000;

    /**
     * Default send method is set to GET.
     */
    public static final String SEND_METHOD = "GET";

    private final String apiToken;

    public HttpRequestSender(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public Response sendRequest(Request request) throws IOException {

        HttpURLConnection connection = createConnection(request);

        return send(connection);
    }

    /**
     * Creates an {@link HttpURLConnection} with connection parameters
     * @param request {@link Request}
     * @return {@link HttpURLConnection} Connection
     * @throws IOException
     */
    private HttpURLConnection createConnection(Request request) throws IOException {
        URL url = new URL(request.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(TIMEOUT);
        connection.setReadTimeout(TIMEOUT);
        connection.setRequestMethod(SEND_METHOD);
        connection.setRequestProperty("TOKEN", this.apiToken);
        return connection;
    }

    /**
     *
     * @param connection {@link HttpURLConnection}
     * @return
     * @throws IOException
     */
    private Response send(HttpURLConnection connection) throws IOException {
        connection.connect();
        if (connection.getResponseCode() != 200) {
            throw new IOException("Bad response! Code: " + connection.getResponseCode());
        }

        Map<String, String> headers = new HashMap<>();
        for (String key : connection.getHeaderFields().keySet()) {
            headers.put(key, connection.getHeaderFields().get(key).get(0));
        }

        String body;
        try (InputStream inputStream = connection.getInputStream()) {

            String encoding = connection.getContentEncoding();
            encoding = encoding == null ? ENCODING : encoding;
            body = toString(inputStream, encoding);
        } catch (IOException e) {
            throw new IOException(e);
        }

        if (body == null) {
            throw new IOException("Unparseable response body! \n {" + body + "}");
        }

        return new Response(headers, body);
    }

    /**
     * Converts a input stream to string with a given encoding type
     * @param inputStream input stream for the {@link HttpURLConnection}
     * @param encoding The encoding type of the input
     * @return the input stream and a string
     * @throws UnsupportedEncodingException
     */
    private String toString(InputStream inputStream, String encoding) throws UnsupportedEncodingException {
        return new BufferedReader(
                new InputStreamReader(inputStream, encoding))
                .lines()
                .collect(Collectors.joining("\n"));
    }

}
