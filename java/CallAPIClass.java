import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class CallAPIClass {

    private static final String ENDPOINT_PATH = System.getenv("API_ENDPOINT");
    private static final String INSTANCE_URL = System.getenv("INSTANCE_URL");
    private static final int HTTP_OK = 200;

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java -cp json-20211205.jar:. CallAPIClass <orderAmount> <salesforceSiteBaseUrl> <sessionId>");
            System.err.println("Example: java -cp json-20211205.jar:. CallAPIClass 26000 "+ INSTANCE_URL + " <sessionId>"); 
            System.exit(1);
        }

        String orderAmount = args[0];
        String baseUrl = args[1];
        String sessionId = args[2];

        try {
            String queryParams = buildQuery(orderAmount);
            URL url = new URL(baseUrl + ENDPOINT_PATH + queryParams);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + sessionId);

            int statusCode = conn.getResponseCode();
            if (statusCode != HTTP_OK) {
                printError(conn, statusCode);
                return;
            }

            String jsonText = readStream(conn);
            conn.disconnect();

            parseAndPrintResult(jsonText);

        } catch (Exception e) {
            System.err.println("Unexpected error:");
            e.printStackTrace();
        }
    }

    private static String buildQuery(String amount) throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode(amount, StandardCharsets.UTF_8.toString());
        return "?amount=" + encoded;
    }

    private static String readStream(HttpURLConnection conn) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

    private static void printError(HttpURLConnection conn, int code) throws IOException {
        System.err.println("HTTP error code: " + code);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8))) {
            String line;
            System.err.println("Error response:");
            while ((line = br.readLine()) != null) {
                System.err.println(line);
            }
        }
        conn.disconnect();
    }

    private static void parseAndPrintResult(String jsonText) {
        JSONObject json = new JSONObject(jsonText);
        String status = json.optString("status", "error");

        if (!"success".equalsIgnoreCase(status)) {
            System.err.println("API call failed: " + jsonText);
            return;
        }

        JSONObject data = json.getJSONObject("data");
        int totalBags = json.optInt("totalBags", -1);
        String message = json.optString("message", "Processed successfully.");

        System.out.println("┌────────────────────────────────────┐");
        System.out.println("│ Fertilizer Bag Distribution Result │");
        System.out.println("└────────────────────────────────────┘");
        System.out.println("Message:      " + message);
        System.out.println("    ┌────────────┬────────────┐");
        System.out.printf("│ %-10s │ %-10s │%n", "Bag Size", "Quantity");
        System.out.println("    ├────────────┼────────────┤");

        Iterator<String> it = data.keys();
        while (it.hasNext()) {
            String size = it.next();
            int qty = data.getInt(size);
            System.out.printf("│ %-10s │ %-10d │%n", size, qty);
        }

        System.out.println("    └────────────┴────────────┘");
        if (totalBags >= 0) {
            System.out.println("    Total Bags: " + totalBags);
            System.out.println("    ────────────────────────");
        }
    }
}

