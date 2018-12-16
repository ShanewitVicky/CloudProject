package controller;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.apphosting.api.DatastorePb.QueryResult;
import com.googlecode.objectify.Result;

import model.Profile;
import model.User;

public class Dao {

	DatastoreService datastore = null;

	public Dao() {
		/*
		 * try { if (SystemProperty.environment.value() ==
		 * SystemProperty.Environment.Value.Production) { // Load the class that
		 * provides the new "jdbc:google:mysql://" prefix.
		 * Class.forName("com.mysql.jdbc.GoogleDriver"); url =
		 * "jdbc:google:mysql://supplychain-1531732261910:asia-east1:supplychaindatabase/supplychain";
		 * 
		 * } else { // Local MySQL instance to use during development.
		 * Class.forName("com.mysql.jdbc.Driver"); url =
		 * "jdbc:mysql://127.0.0.1:3306/guestbook?user=root"; } conn =
		 * DriverManager.getConnection(url, "root", "root");
		 * 
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		datastore = DatastoreServiceFactory.getDatastoreService();

	}

	public void User() throws SQLException {

		Query query = new Query("Messages");
		List<Entity> listEnt = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());

		for (Entity entity : listEnt) {

		}

	}

	public boolean loginUser(User user) {
		boolean flag = false;

		int count = ofy().load().type(User.class).filter("UserName =", user.getUserName()).filter("Password =",user.getPassword()).count();

		System.out.println("Count"+count+"user"+user.getUserName());

		if (count>0) {
			flag = true;
		}

		return flag;

	}

	public void insertUser(User user) {

		
		ofy().save().entity(user);

	}
	
	public Object createResume(Profile profile) {
		return ofy().save().entity(profile).now();
	}
	public Profile getProfile(String lastName) {
		List<Profile> prof=ofy().load().type(Profile.class).filter("lastName =", lastName).list();
		
		return prof.get(0);
	}
	
	public User fetchUser(String userName) {
		User user=ofy().load().type(User.class).filter("UserName=",userName).list().get(0);
		return user;
	}
}
