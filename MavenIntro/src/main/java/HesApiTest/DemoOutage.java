package HesApiTest;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class DemoOutage {

    public static void main(String[] args) throws IOException {
        // Base URL
        String baseUrl = "http://hes-demo.probussense.com:8110/api/outage/data";

        // Parameters
        String searchBy = "IP";
        String searchValue = "2401:4900:982D:260::2"; // No need to encode here, handled below
        String startDateTime = "2024-10-21 00:00:00"; // Keep as is for encoding
        String endDateTime = "2024-10-24 12:35:45"; // Keep as is for encoding
        int page = 0;
        int size = 1000;
        String sortBy = "creation_time";
        String direction = "DESC";
        long timestamp = System.currentTimeMillis(); // Example for dynamic timestamp

        // Construct the full API URL
        String apiUrl = String.format("%s?searchBy=%s&searchValue=%s&startDateTime=%s&endDateTime=%s&page=%d&size=%d&sort_by=%s&direction=%s&_= %d",
                baseUrl,
                URLEncoder.encode(searchBy, StandardCharsets.UTF_8),
                URLEncoder.encode(searchValue, StandardCharsets.UTF_8),
                URLEncoder.encode(startDateTime, StandardCharsets.UTF_8),
                URLEncoder.encode(endDateTime, StandardCharsets.UTF_8),
                page,
                size,
                URLEncoder.encode(sortBy, StandardCharsets.UTF_8),
                URLEncoder.encode(direction, StandardCharsets.UTF_8),
                timestamp); // No space here
            System.out.println(apiUrl);
        // Remove any spaces from the generated API URL
        apiUrl = apiUrl.replaceAll(" ", "");


        // API endpoint that requires authentication
//        String apiUrl = "http://hes-demo.probussense.com:8110/api/outage/data?searchBy=IP&searchValue=2401%3A4900%3A982D%3A260%3A%3A2&startDateTime=2024-10-23%2000%3A00%3A00&endDateTime=2024-10-24%2012%3A35%3A45&page=0&size=20&sort_by=creation_time&direction=DESC&_=1729667140734";
        String username = "probus_admin";
        String password = "probus@123";

        // Fetch JSON data from API with Basic Authentication
        String jsonResponse = fetchDataFromApi(apiUrl, username, password);

        // Parse the JSON data
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode jsonArray = rootNode.get("content"); // Extracting the array under the 'content' key

        // Create JFrame (Window) to display JTable
        JFrame frame = new JFrame("JSON API to JTable with Authentication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Check if JSON array is non-empty
        if (jsonArray != null && jsonArray.isArray() && !jsonArray.isEmpty()) {
            // Get the first object to extract column names (JSON keys)
            JsonNode firstObject = jsonArray.get(0);
            Iterator<String> fieldNames = firstObject.fieldNames();

            // Dynamically create the column names based on the JSON keys
            DefaultTableModel tableModel = new DefaultTableModel();
            while (fieldNames.hasNext()) {
                tableModel.addColumn(fieldNames.next().toUpperCase());
            }

            // Populate rows based on the data
            for (JsonNode node : jsonArray) {
                Object[] rowData = new Object[tableModel.getColumnCount()];
                int i = 0;
                Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    rowData[i++] = entry.getValue().asText(); // or entry.getValue().asSomething() based on data type
                }
                tableModel.addRow(rowData);
            }

            // Create JTable and set its model
            JTable table = new JTable(tableModel);

            // Add the table to the frame
            frame.add(new JScrollPane(table), BorderLayout.CENTER);


            // Create a button to save the table data to an Excel file
            JButton saveButton = new JButton("Save to Excel");
            saveButton.addActionListener(e -> {
                try {
                    saveTableToExcel(table, "output.xlsx");
                    JOptionPane.showMessageDialog(frame, "Data saved to Excel file successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error saving data to Excel.");
                }
            });

            // Add the button to the frame
            frame.add(saveButton, BorderLayout.SOUTH);

            // Set the size of the frame and make it visible
            frame.setSize(1080, 700);
            frame.setVisible(true);
        } else {
            System.out.println("No data to display");
        }
    }

    // Function to fetch data from API with Basic Authentication
    private static String fetchDataFromApi(String apiUrl, String username, String password) throws IOException {
        // Create a credentials provider
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        // Create HttpClient with credentials
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(provider)
                .build();

        // Make GET request
        HttpGet request = new HttpGet(apiUrl);
        HttpResponse response = httpClient.execute(request);

        // Get response body
        String responseBody = EntityUtils.toString(response.getEntity());
        httpClient.close();
        return responseBody;
    }

    // Function to save JTable data to Excel file
    private static void saveTableToExcel(JTable table, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("API Data");

        // Write table header
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < tableModel.getColumnCount(); col++) {
            headerRow.createCell(col).setCellValue(tableModel.getColumnName(col));
        }

        // Write table data
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Row excelRow = sheet.createRow(row + 1);
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                excelRow.createCell(col).setCellValue(tableModel.getValueAt(row, col).toString());
            }
        }

        // Write to Excel file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

}
