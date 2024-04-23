//package life.thedeveloper.smarttouch.infrastructure.web.graphql;
//
//import life.thedeveloper.smarttouch.domain.model.Contact;
//import life.thedeveloper.smarttouch.infrastructure.repository.ContactRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class ContactController {
//
//    private final ContactRepository repository;
//
//    @Autowired
//    public ContactController(ContactRepository repository) {
//        this.repository = repository;
//    }
//
//    @QueryMapping
//    public Contact getContactById(String id) {
//        return repository.findById(id).orElse(null);
//    }
//}
