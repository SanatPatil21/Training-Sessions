package mongoDemo;

import java.util.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

public class MongoDBOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("demodb");
		
		MongoCollection<Document> collections = database.getCollection("Employee");
		
		/*
		FindIterable<Document> i = collection.find();
		
		for(Document d:i) {
			System.out.println(d);
		}
		
		
		*/
		
		//Various ways of Inserting a record
		//INSERTING USING A DOC
		/*
		Document doc = new Document();
		doc.append("name", "Pooja");
		doc.append("age", 33);
		doc.append("salary", 33000);
		doc.append("designation", "Manager");
		collections.insertOne(doc);
		
		*/
		//INSERTING IN A LINE
		//collections.insertOne(new Document().append("name","Suman").append("age",34).append("salary",33400).append("desgination","Tester"));
		
		//INSERTING AS A LIST
		/*
		List<Document> empList = new ArrayList<Document>();
		empList.add(new Document().append("name","Aster").append("age",50).append("salary",22000).append("desgination","Programmer"));
		empList.add(new Document().append("name","Aryan").append("age",23).append("salary",35000).append("desgination","Programmer"));
		
		collections.insertMany(empList);
		*/
		
		/*
		//PROJECTIONS
		Bson projection1 = Projections.excludeId(); //There is inbuilt function for excluding id
		Bson projection2 = Projections.exclude("_id","age","salary");
		//If we need to include, we can choose to include which columns we want too
		
		//FILTERS(returns bson)
		Bson filter = Filters.eq("designation","Programmer");
		
		//SORTING
		Bson asort = Sorts.ascending("salary");
		Bson dsort = Sorts.descending("age","salary");
		
		FindIterable<Document> i = collections.find(filter).projection(projection1).sort(asort);
		for(Document d:i) {
			System.out.println(d.toJson());
		}
		*/
		
		//UPDATING
		/*
		Bson filter = Filters.gt("age", 35);
		Bson update = Updates.set("designation", "Manager");
		collections.updateMany(filter,update);
		*/
		//DELETING
		/*
		Bson deleteFilter = Filters.eq("name","Suman");
		collections.deleteOne(deleteFilter);
		*/
		
		System.out.println("Sucessfully did the operation on MongoDB");
		mongoClient.close();
	}

}
