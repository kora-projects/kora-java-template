package ru.tinkoff.kora.java;

import ru.tinkoff.kora.application.graph.KoraApplication;
import ru.tinkoff.kora.common.KoraApp;
import ru.tinkoff.kora.config.hocon.HoconConfigModule;
import ru.tinkoff.kora.http.server.undertow.UndertowModule;
import ru.tinkoff.kora.logging.logback.LogbackModule;
import ru.tinkoff.kora.micrometer.module.MetricsModule;

@KoraApp
public interface Application extends
        UndertowModule, // only private server for health & metrics
        MetricsModule,
        HoconConfigModule,
        LogbackModule {

    static void main(String[] args) {
        KoraApplication.run(ApplicationGraph::graph);
    }
}
