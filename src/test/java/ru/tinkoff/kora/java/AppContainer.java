package ru.tinkoff.kora.java;

import java.net.URI;
import java.nio.file.Paths;
import java.time.Duration;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.utility.DockerImageName;

public final class AppContainer extends GenericContainer<AppContainer> {

    private AppContainer() {
        super(new ImageFromDockerfile("kora-java")
                .withDockerfile(Paths.get("Dockerfile").toAbsolutePath()));
    }

    private AppContainer(DockerImageName image) {
        super(image);
    }

    public static AppContainer build() {
        final String appImage = System.getenv("IMAGE_KORA_JAVA");
        return (appImage != null && !appImage.isBlank())
                ? new AppContainer(DockerImageName.parse(appImage))
                : new AppContainer();
    }

    @Override
    protected void configure() {
        super.configure();
        withExposedPorts(8085);
        withStartupTimeout(Duration.ofSeconds(120));
        withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(AppContainer.class)));
        waitingFor(Wait.forHttp("/system/readiness").forPort(8085).forStatusCode(200));
    }

    public int getPrivatePort() {
        return getMappedPort(8085);
    }

    public URI getPrivateURI() {
        return URI.create(String.format("http://%s:%s", getHost(), getPrivatePort()));
    }
}
