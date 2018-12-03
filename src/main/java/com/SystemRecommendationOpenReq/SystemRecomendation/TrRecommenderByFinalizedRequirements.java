package com.SystemRecommendationOpenReq.SystemRecomendation;

import java.util.List;
import java.util.Random;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import data.UserFinder;
import data.UserGateway;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrRecommenderByFinalizedRequirements extends Transaction {

	String idUser;
	
	public TrRecommenderByFinalizedRequirements (String idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public void execute() {
		//requirements from SQLite database		
		RequirementsStubAcces racces = new RequirementsStubAcces();
		ArrayList<RequirementsStub> requirements = racces.getRequirements();
		
		UserFinder uF = new UserFinder();
		UserGateway u;
		try {
			u = uF.findById(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//prepare file for datamodel (performance)
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < requirements.size(); i++) {
			lines.add(idUser + "," + requirements.get(i).topicParsedToLong(36) + "," + ",");
		}
		
		Path file = Paths.get("finalizedRequirements.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileDataModel de = null;
		try {
			de = new FileDataModel(new File("finalizedRequirements.txt"));
		
		
		ItemSimilarity sim = new LogLikelihoodSimilarity(de);
		
		GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(de, sim);
		
		int x = 1;
		for (LongPrimitiveIterator items = de.getItemIDs(); items.hasNext();) {
			long itemId = items.nextLong();
			List<RecommendedItem> recommendations;
				recommendations = recommender.mostSimilarItems(itemId, 2);
			for (RecommendedItem recommendation : recommendations) {
				System.out.println(itemId + "," + recommendation.getItemID() + "," + recommendation.getValue());
			}
		}
		}
		catch (IOException e){
			System.out.println("Error inout");
		}
		catch (TasteException e) {
			System.out.println("There was a Taste Exception");
		}
		
		
	}
	
	private class RequirementsStubAcces {
		
		public ArrayList<RequirementsStub> getRequirements() {
			ArrayList<RequirementsStub> result = new ArrayList<>();
			Random random = new Random(System.currentTimeMillis());
			for (int i = 1; i < 20; i++) {
				result.add(new RequirementsStub (i, "s"+i, "null", "topic" + random.nextInt(i)%4));
			}
			return result;
		}
			
	}	
		
	private class RequirementsStub {

		int id;
		String subject;
		String description;
		String topic;
		
		public RequirementsStub(int i, String subject, String description, String topic) {
			id = i;
			this.subject = subject;
			this.description = description;
			this.topic = topic;
		}
		
		public Long topicParsedToLong (int radix) {
			
			Long res = Long.parseLong(this.topic, radix);
			return res;
			
		}

	}
	
	private class FinalizedRequirementsStub {
		
		int idRequirement;
		int idUser;
		
		public FinalizedRequirementsStub (int idU, int idR) {
			idRequirement = idR;
			idUser = idU;
		}
	}
}

