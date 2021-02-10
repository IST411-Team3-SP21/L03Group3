import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.HttpRequestSender;
import dao.RequestSender;
import entity.DataSets;
import http.Request;
import http.Response;


public class App {

    private static final String API_TOKEN = "<ENTER_TOKEN_HERE>";
    private static final String DATASET_RESOURCE = "https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets";

    private static RequestSender sender;
    private static Gson gson;

    public static void main(String[] args) {
        sender = new HttpRequestSender(API_TOKEN);
        gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            var dataSets = getResults();
            System.out.println(gson.toJson(dataSets));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }


    public static DataSets getResults() throws Exception {
        Request request = new Request(DATASET_RESOURCE);

        DataSets dataSets;
        Response response = sender.sendRequest(request);
        dataSets = gson.fromJson(response.getBody(), DataSets.class);

        return dataSets;
    }
}
