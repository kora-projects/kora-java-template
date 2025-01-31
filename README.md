[![GitHub Action](https://github.com/kora-projects/kora-java-template/workflows/Build%20Master/badge.svg)](https://github.com/kora-projects/kora-java-template/actions?query=workflow%3A%22Build%20Master%22++)

# Шаблон приложения Kora Java

Шаблон для быстрого старта нового проекта на Java и Kora.

## Build

Собрать классы:

```shell
./gradlew classes
```

Собрать артефакт:

```shell
./gradlew distTar
```

### Image

Собрать образ приложения:
```shell
docker build -t kora-java-template .
```

## Run

Перед запуском локально требуется запустить базу Postgres и накатить миграции.

Запустить локально:
```shell
./gradlew run
```

## Run Docker-Compose

Требуется сначала собрать артефакт.

Запустить как docker-compose:
```shell
docker-compose up
```

## Test

Протестировать локально:
```shell
./gradlew test
```
