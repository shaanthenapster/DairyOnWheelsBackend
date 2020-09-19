package com.dairy.configuration;

import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfig {

    @Bean
    public MongoDatabase getMongoConnection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://rmehub:rmehub@rmehub-aaiym.mongodb.net/dairy?retryWrites=true"));
        MongoDatabase database = mongoClient.getDatabase("dairy").withCodecRegistry(pojoCodecRegistry);
        return database;
    }
}
