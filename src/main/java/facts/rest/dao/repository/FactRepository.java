package facts.rest.dao.repository;
 


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import facts.rest.model.Fact;

 

@Repository
public interface FactRepository  extends CrudRepository<Fact, Long>{

}