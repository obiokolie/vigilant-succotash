package ManagedWebCrawler;

import java.io.*;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.v1.Customsearch;
import com.google.api.services.customsearch.v1.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.v1.model.Result;
import com.google.api.services.customsearch.v1.model.Search;

//import org.json.simple.*;

public class JsonManager {

	public static void main(String[] args) throws GeneralSecurityException, IOException{

	    String searchQuery = "upland allied concept"; //The query to search
	    String cx = "dfdksf;ieiegkgk"; //Your search engine ID

	    //Instance Customsearch
	    Customsearch cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null) 
	                   .setApplicationName("com.finidata") 
	                   .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer("Your API Token")) 
	                   .build();

	    //Set search parameter
	    Customsearch.Cse.List list = cs.cse().list().setQ(searchQuery).setCx(cx); 

	    //Execute search
	    Search result = list.execute();
	    if (result.getItems()!=null){
	        for (Result ri : result.getItems()) {
	            //Get title, link, body etc. from search
	            System.out.println(ri.getTitle() + ", " + ri.getLink());
	        }
	    }

	
		

	}

}
