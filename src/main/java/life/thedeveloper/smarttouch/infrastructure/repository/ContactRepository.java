package life.thedeveloper.smarttouch.infrastructure.repository;

import java.util.List;

import life.thedeveloper.smarttouch.domain.model.Contact;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String>, QueryByExampleExecutor<Contact> {
//    Page<Contact> listContactsByOwner(String owner, Pageable pageable);

    List<Contact> findByOwner(String owner);
}
