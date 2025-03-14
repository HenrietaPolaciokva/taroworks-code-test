import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallAPIClass {

    private static final String API_MAIN_URL = "https://fun-momentum-8899-dev-ed.scratch.my.salesforce-sites.com/services/apexrest/ClientOrderProcessor";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a name as the first argument.");
            return;
        }
        String name = args[0];
        String apiUrl = API_MAIN_URL + "?name=" + name;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    // Print the response
                    System.out.println("Response: " + response.toString());
                }
            } else {
                System.out.println("POST request did not work");
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}