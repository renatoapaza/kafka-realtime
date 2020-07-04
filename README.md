
# kafka-realtime
Ejemplo SpringBoot WebSocket y Apache Kafka Dibujando una grafico en tiempo real

## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --bootstrap-server localhost:9092  --repliction-factor 1 --partitions 1 --topic livetemperature`

## Publish to the Kafka Topic via Console
- `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic livetemperature`

# Resultado
http://localhost:8081

![Alt text](asset/grafico.png?raw=true "Temperatura")
