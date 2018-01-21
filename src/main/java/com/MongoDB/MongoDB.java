package com.MongoDB;
import java.util.Date;

import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDB {
	public static void main(String[] args) {
		MongoClient ob = new MongoClient("localhost",27017);
		DB db = ob.getDB("testJava");
		DBCollection table = db.getCollection("user");
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", "mini");
		doc.put("age",24);
		doc.put("createDate", new Date());
		table.insert(doc);
		BasicDBObject query = new BasicDBObject();
		query.put("name","mini");
		DBCursor cursor = table.find(query);
		
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
		BasicDBObject newDoc = new BasicDBObject();
		query.put("name","mini");
		BasicDBObject updatedValue = new BasicDBObject();
		updatedValue.put("name","miniNew");
		BasicDBObject updatewithNewValue = new BasicDBObject();
		updatewithNewValue.put("$set",updatedValue);
		table.update(query, updatewithNewValue);
		
		BasicDBObject query2 = new BasicDBObject().append("name", "miniNew");
		DBCursor cursor2 = table.find(query2);
		while(cursor2.hasNext()) {
			System.out.println(cursor2.next());
		}
		
	}
}
