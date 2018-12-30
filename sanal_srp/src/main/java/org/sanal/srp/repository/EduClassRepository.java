package org.sanal.srp.repository;

import org.sanal.srp.entities.EduClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sanal567 Date 20-10-18 8:56 PM
 */
@Repository
public interface EduClassRepository extends CrudRepository<EduClass, Integer> {

}
