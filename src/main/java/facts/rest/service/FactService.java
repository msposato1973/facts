package facts.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facts.rest.dao.repository.FactRepository;
import facts.rest.model.Fact;
import facts.rest.model.Facts;
import facts.rest.util.Utility;

@Service
public class FactService {
	
	public static final Logger logger = LoggerFactory.getLogger(FactService.class);
	
	@Autowired
	FactRepository factRepository;

		
	public Fact findByIdandTranslateText(Long id, String languageCode) {
		Fact fact = factRepository.findById(id).get();
	
		String translatedText = Utility.translateText(fact.getText(), languageCode);
		logger.debug(" translatedText :" + translatedText);
		fact.setText(translatedText);
		fact.setLanguage(languageCode); 
        
		return fact;
    }
	
	public void createFact(Fact fact) {
		factRepository.save(fact);
    }
	
	
	public Facts getFacts() {
		List<Fact> factList = new ArrayList<Fact>();
		factList = findAll();
	 
       return new Facts(factList);
    }
	
	public List<Fact> findAll() {
		List<Fact> facts = new ArrayList<Fact>();
	    factRepository.findAll().forEach(fact -> facts.add(fact));

	    return facts;
	}

	
	public void updateFact(Fact fact) throws Exception {
		// TODO Auto-generated method stub
		factRepository.save(fact);
	}

	public Fact findById(Long factId) {
		return factRepository.findById(factId).get();
	}
}
