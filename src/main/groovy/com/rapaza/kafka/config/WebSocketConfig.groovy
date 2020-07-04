/* ================================================================
 * Desarrollador: Renato Apaza Tito (renato.apaza@outlook.com)
 * Fecha: 4/7/20 15:31
 * ==============================================================
 */
package com.rapaza.kafka.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/live-temperature").withSockJS()
    }

    @Override
    void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/topic")
    }
}
