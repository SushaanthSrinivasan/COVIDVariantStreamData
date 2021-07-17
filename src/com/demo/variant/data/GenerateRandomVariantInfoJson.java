package com.demo.variant.data;

import static com.demo.variant.data.GenerateVariantInfo.generatevariant;
import static com.demo.variant.data.GenerateVariantInfo.generateconfirmedCaseNumber;
import static com.demo.variant.data.GenerateVariantInfo.generateprobableCaseNumber;
import static com.demo.variant.data.GenerateVariantInfo.generatetotalCaseNumber;
import static com.demo.variant.data.GenerateVariantInfo.generatecaseProportion;
import static com.demo.variant.data.GenerateVariantInfo.generatedeaths;
import static com.demo.variant.data.GenerateVariantInfo.generateCaseFatality;
import static com.demo.variant.data.GenerateVariantInfo.generateCaseFatality28;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomVariantInfoJson {

	public static void main(String[] args) throws InterruptedException, IOException {

		while (true) {
			File file = new File("/Users/91893/Documents/Project/variant" + ".json");
			int records = new Random().nextInt(15);
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
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.append(variantInfo.toString()+"\n");
				bw.flush();
				bw.close();
			}
			Thread.sleep(300);
		}
	}
}