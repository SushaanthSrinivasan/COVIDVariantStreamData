package com.demo.variant.data;

import static com.demo.variant.data.GenerateVariantInfo.generatevariant;
import static com.demo.variant.data.GenerateVariantInfo.generateconfirmedCaseNumber;
import static com.demo.variant.data.GenerateVariantInfo.generateprobableCaseNumber;
import static com.demo.variant.data.GenerateVariantInfo.generatetotalCaseNumber;
import static com.demo.variant.data.GenerateVariantInfo.generatecaseProportion;
import static com.demo.variant.data.GenerateVariantInfo.generatedeaths;
import static com.demo.variant.data.GenerateVariantInfo.generateCaseFatality;
import static com.demo.variant.data.GenerateVariantInfo.generateCaseFatality28;

import java.util.Random;

import org.apache.spark.rdd.*;

public class SendVariantDataToKafka {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			int records = new Random().nextInt(5);
			for (int i = 1; i <= records; i++) {
				VariantInfo variantInfo = new VariantInfo();
				variantInfo.setVariant(generatevariant());
				variantInfo.setConfirmedCaseNumber(generateconfirmedCaseNumber(7,219570));
				variantInfo.setProbableCaseNumber(generateprobableCaseNumber(0,41773));
				variantInfo.setTotalCaseNumber(generatetotalCaseNumber(7,225085));
				variantInfo.setCaseProportion(generatecaseProportion(0,70.3));
				variantInfo.setDeaths(generatedeaths(0,21950));
				variantInfo.setCaseFatality(generateCaseFatality(0,50000));
				variantInfo.setCaseFatality28(generateCaseFatality28(0,50000));
				SimpleKafkaProducer.sendDataToKafkaSingleBroker(variantInfo.toString(),"varianttopic");
				//SimpleKafkaProducer.sendDataToKafkaMultipleBroker(variantInfo.toString(), "varianttopic", vehicleInfo.getVariant());
			}
			System.out.println("Written " + records + " to Kafka..");
			Thread.sleep(3000);
		}

	}

}

