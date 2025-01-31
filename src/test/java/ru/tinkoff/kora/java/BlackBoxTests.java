package ru.tinkoff.kora.java;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlackBoxTests {

    private static final AppContainer container = AppContainer.build()
            .withNetwork(org.testcontainers.containers.Network.SHARED);

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(1))
            .build();

    @BeforeAll
    public static void setup() {
        container.start();
    }

    @AfterAll
    public static void cleanup() {
        container.stop();
    }

    @Test
    void serviceReady() throws Exception {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(container.getPrivateURI().resolve("/metrics"))
                .timeout(Duration.ofSeconds(1))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
        assertEquals(200, response.statusCode());
    }
}
