package ru.tinkoff.kora.java;

import ru.tinkoff.kora.common.Component;
import ru.tinkoff.kora.common.annotation.Root;

@Root
@Component
public final class SomeService {

    public String getSome() {
        return "1";
    }
}
