/* ================================================================
 * Desarrollador: Renato Apaza Tito (renato.apaza@outlook.com)
 * Fecha: 4/7/20 15:20
 * ==============================================================
 */
package com.rapaza.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Value('${kafka.bootstrapserver}')
    String bootstrapServer

    @Bean
    Map<String , Object> consumerConfigs() {
        Map<String , Object> config = new HashMap<String , Object>()

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , bootstrapServer)
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class)
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class)
        config.put(ConsumerConfig.GROUP_ID_CONFIG , "temp-groupid.group")
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG , "latest")

        return config
    }

    @Bean
    ConsumerFactory<String , String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs())
    }

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String , String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String , String> factory = new ConcurrentKafkaListenerContainerFactory<>()
        factory.consumerFactory = consumerFactory()

        return factory
    }
}
