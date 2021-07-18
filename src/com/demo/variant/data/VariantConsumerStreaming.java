package com.demo.variant.data;

import java.util.*;
import org.apache.spark.SparkConf;
import org.apache.spark.TaskContext;
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.kafka010.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import scala.Tuple2;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;


public class VariantConsumerStreaming {
	public static void main(String[] args) throws InterruptedException{
		SparkConf conf = new SparkConf().setAppName("variantinfo-streaming").setMaster("local[4]");
		JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(5));
        //JavaSparkContext sc = new JavaSparkContext(conf);
		
		Map<String, Object> kafkaParams = new HashMap<>();
		kafkaParams.put("bootstrap.servers", "localhost:9092, anotherhost:9092");
		kafkaParams.put("key.deserializer", StringDeserializer.class);
		kafkaParams.put("value.deserializer", StringDeserializer.class);
		kafkaParams.put("group.id", "variantgroup");
		kafkaParams.put("auto.offset.reset", "earliest");
		kafkaParams.put("enable.auto.commit", false);
	
		Collection<String> topics = Arrays.asList("varianttopic"); //", "topicB");
	
		JavaInputDStream<ConsumerRecord<String, String>> stream = KafkaUtils.createDirectStream(
			jssc,
		    LocationStrategies.PreferConsistent(),
		    ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
		);
		
		JavaPairDStream<String, String> records = stream.mapToPair(record -> new Tuple2<>(record.key(), record.value()));
		
		records.print();
		jssc.start();
		jssc.awaitTermination();
		jssc.close();
	}

}