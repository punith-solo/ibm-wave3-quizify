package com.stackroute.quizify.gamemanager.producer;

import com.stackroute.quizify.gamemanager.domain.Game;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class GameProducer {
    public static Game produce(Game game, String bootstrapServer, String topicName) {
        Logger logger = LoggerFactory.getLogger(GameProducer.class);
        Gson gson = new Gson();

        /* Step 1. Create Producer Properties */
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        /* Step 2. Create The Producer */
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        /* Step 3. Create Producer Record */
        String key = game.getName();
        String value = gson.toJson(game);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);

        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Key : " + key);
        logger.info("Value : " + value);
        logger.info("------------------------------------------------------------------------------------------------");

        /* Step 4. Send Data -async */
//        producer.send(record);

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {
                    logger.info(
                            "Received MetaData : \n" +
                                    "Topic : " + recordMetadata.topic() + "\n" +
                                    "Partition : " + recordMetadata.partition() + "\n" +
                                    "Offset : " + recordMetadata.offset() + "\n" +
                                    "Timestamp : " + recordMetadata.timestamp()
                    );
                } else {
                    logger.error("Error While Producing : " + e);
                }
            }
        });

        /* FLush Data */
        producer.flush();

        /* Flush and Close */
        producer.close();

        return game;

    }
}
