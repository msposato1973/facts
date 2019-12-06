package facts.rest.controller;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import facts.rest.model.Fact;


public class FactsControllerTest {

	public static final String REST_BASE_URI = "http://localhost:8080";
	public static final String REST_STATUS_URI = REST_BASE_URI + "/status";
	public static final String REST_FACTS_URI = REST_BASE_URI + "/facts";
	public static final String REST_FACTID_URI = REST_BASE_URI + "/facts/{factId}";
	public static final String REST_LANG_URI = REST_BASE_URI + "/facts/{factId}?lang={languageCode}";
	
	@Before
	public void setUp() throws Exception {
	}

	/* GET */
    @SuppressWarnings("unchecked")
    private static void listAllFacts(){
        System.out.println("Testing listAllUsers API-----------");
          
        RestTemplate restTemplate = new RestTemplate();
        List<Fact> factsMap = restTemplate.getForObject(REST_STATUS_URI, List.class);
          
        if(factsMap!=null){
            for(Fact f : factsMap){
               
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
      
    /* GET */
    private static void getFact(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Fact fact = restTemplate.getForObject(REST_STATUS_URI, Fact.class);
        System.out.println(fact);
    }

}
