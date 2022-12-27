package com.viettel.statisticservice.comon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class Beans {

//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;

    @Bean
    public JsonMessageConverter getJsonMessageConverter(){
        return new JsonMessageConverter();
    }

    // This bean is for solving error while consumming event from kafka broker.
//    if there are 5 event comming, but event 3th get trouble after 1th, 2th successfull consumed
//    Then kafka will stop consumming
//    and try to re-send that failed data every 1s, max is 2 times to kafka-broker by param: KafkaTemplate above
//    (this is reason why i use producer config in application.yml)
//    if still failed, kafkaTempalte will push that event to        DTL topic
//    and continue comsuming 4th and 5th events

//    We can read this dtl-topic to reconsume or annalize cause why thet get failed.
    @Bean
    public DefaultErrorHandler getDefaultErrorHandler(KafkaTemplate kafkaTemplate){
        return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate)
                , new FixedBackOff(1000, 2));
    }


}
