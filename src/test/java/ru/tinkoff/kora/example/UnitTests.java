package ru.tinkoff.kora.example;

import org.junit.jupiter.api.Test;
import ru.tinkoff.kora.test.extension.junit5.KoraAppTest;
import ru.tinkoff.kora.test.extension.junit5.TestComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

@KoraAppTest(Application.class)
class UnitTests {

    @TestComponent
    private SomeService service;

    @Test
    void getSomeSuccess() {
        assertEquals("1", service.getSome());
    }
}
