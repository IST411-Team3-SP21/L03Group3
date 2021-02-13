import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.HttpRequestSender;
import dao.RequestSender;
import entity.DataSets;
import http.Request;
import http.Response;


public class App {

    private static final String API_TOKEN = "owFsOtjHteSENRRmNVgoFoTLWkcFRuHU";
    private static final String DATASET_RESOURCE = "https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets";

    private static RequestSender sender;
    private static Gson gson;

    public static void main(String[] args) {
        sender = new HttpRequestSender(API_TOKEN);
        gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            var dataSets = getResults();
            // As JSON
            System.out.println("Pretty Printed");
            System.out.println("_________________________");
            System.out.println(gson.toJson(dataSets));

            // Logical
            System.out.println("\nLogically Printed");
            System.out.println("_________________________");
            System.out.printf("Offset:\t %d\n", dataSets.getMetadata().getResultSet().getOffset());
            System.out.printf("Count:\t %d\n", dataSets.getMetadata().getResultSet().getCount());
            System.out.printf("Limit:\t %d\n", dataSets.getMetadata().getResultSet().getLimit());

            for (int i = 0; i < dataSets.getResults().size(); i++) {
                System.out.println("\nResult: " + i);
                System.out.println("_________________________");
                System.out.printf("UID:           %14s\n", dataSets.getResults().get(i).getId());
                System.out.printf("Min Date:      %15s\n", dataSets.getResults().get(i).getMindate());
                System.out.printf("Max Date:      %15s\n", dataSets.getResults().get(i).getMaxdate());
                System.out.printf("Name:          %28s\n", dataSets.getResults().get(i).getName());
                System.out.printf("Data Coverage: %13f\n", dataSets.getResults().get(i).getDatacoverage());
                System.out.printf("ID:            %14s\n", dataSets.getResults().get(i).getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }


    public static DataSets getResults() throws Exception {
        Request request = new Request(DATASET_RESOURCE);
        Response response = sender.sendRequest(request);
        return gson.fromJson(response.getBody(), DataSets.class);
    }
}
