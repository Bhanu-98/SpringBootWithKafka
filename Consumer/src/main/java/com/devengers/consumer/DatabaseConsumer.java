package com.devengers.consumer;

import com.devengers.consumer.entity.WikimediaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConsumer.class);
    private WikimediaDataRepository wikimediaDataRepository;

    public DatabaseConsumer(WikimediaDataRepository wikimediaDataRepository){
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroupId")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message received -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikieventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}
