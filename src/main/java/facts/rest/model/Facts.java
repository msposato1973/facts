package facts.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Facts {
	 
	public Facts() {}
	
	public Facts(List<Fact> factList) {
		super();
		this.factList = factList;
	}

	private List<Fact> factList;
    
    public List<Fact> getFactsList() {
        if(factList == null) {
        	factList = new ArrayList<Fact>();
        }
        return factList;
    }
  
    public void setFactseList(List<Fact> factList) {
        this.factList = factList;
    }
 
}
