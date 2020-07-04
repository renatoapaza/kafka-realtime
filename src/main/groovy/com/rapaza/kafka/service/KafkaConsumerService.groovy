/* ================================================================
 * Desarrollador: Renato Apaza Tito (renato.apaza@outlook.com)
 * Fecha: 4/7/20 15:31
 * ==============================================================
 */
package com.rapaza.kafka.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    @Autowired
    SimpMessagingTemplate template

    @KafkaListener(topics = '${kafka.topic}')
    void consume(@Payload String message) {
        if(isNumeric(message)) {
            template.convertAndSend("/topic/temperature" , message)
        }
    }

    private boolean isNumeric(String str) {
        try {
            @SuppressWarnings("unused")
            double d = Double.parseDouble(str)
        } catch( NumberFormatException nfe ) {
            return false
        }

        return true
    }
}
