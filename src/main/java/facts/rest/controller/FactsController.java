package facts.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import facts.rest.model.Fact;
import facts.rest.model.Facts;
import facts.rest.service.FactService;

@RestController
@RequestMapping(path = "/")
public class FactsController{

	public static final Logger logger = LoggerFactory.getLogger(FactsController.class);
	
	@Autowired
    private FactService factService;
     
    @GetMapping(path="/facts", produces = MediaType.APPLICATION_JSON_VALUE)
    public  Facts getFacts() 
    {
        return factService.getFacts();
    }
     
    @GetMapping(path="/facts/{factId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fact> getFact(@PathVariable Long factId) 
    {
    	Fact fact = factService.findById(factId);
       	if (fact == null) return new ResponseEntity<Fact>(HttpStatus.NOT_FOUND);
    
       	return new ResponseEntity<Fact>( fact, HttpStatus.OK);
    }
    
    
    @GetMapping(path="/facts/{factId}?lang={languageCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Facts getTransalete(@PathVariable Long factId,@RequestParam("lang") String languageCode) 
    {
    	List<Fact> factList = new ArrayList<Fact>();
    	factList.add(factService.findByIdandTranslateText(factId, languageCode));
    	
        return new Facts(factList);
    }
    
    
}
