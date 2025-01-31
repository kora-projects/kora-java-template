package ru.tinkoff.kora.java;

import org.junit.jupiter.api.Test;
import ru.tinkoff.kora.test.extension.junit5.KoraAppTest;
import ru.tinkoff.kora.test.extension.junit5.TestComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

@KoraAppTest(Application.class)
class UnitTests {

    @TestComponent
    private SomeService someService;

    @Test
    void getSomeSuccess() {
        assertEquals("1", someService.getSome());
    }
}
