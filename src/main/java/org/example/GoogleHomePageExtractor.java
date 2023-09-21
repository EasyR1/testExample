package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleHomePageExtractor {
    private static final Pattern PATTERN = Pattern.compile("<title>Google</title>");
    private HttpClient client;

    public GoogleHomePageExtractor() {
        client = HttpClient.newHttpClient();
    }

    public boolean googleResultContainsOraclePage(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        if (HttpURLConnection.HTTP_OK == response.statusCode()) {
            String pageBody = response.body();
            Matcher matcher = PATTERN.matcher(pageBody);
            return matcher.find();
        }
        return false;
    }
}
