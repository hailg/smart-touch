package life.thedeveloper.smarttouch.infrastructure.web;

import java.util.Map;
import java.util.UUID;

import com.google.common.collect.ImmutableMap;
import jakarta.validation.Valid;
import life.thedeveloper.smarttouch.domain.model.Contact;
import life.thedeveloper.smarttouch.infrastructure.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
//@EnableMethodSecurity
public class ContactRestController extends Controller {
    private final ContactRepository repository;

    @Autowired
    public ContactRestController(ContactRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/contacts")
    public ResponseEntity<Map<String, Object>> createContact(@Valid @RequestBody Contact contact, @RequestHeader Map<String, String> headers) {
        String contactId = UUID.randomUUID().toString();
        Contact newContact = new Contact(
                contactId,
                contact.email(),
                contact.owner(),
                contact.attributes()
        );
        repository.save(newContact);
        var result = ImmutableMap.<String, Object>builder()
                .put("data", contact)
                .build();
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/contacts")
    public ResponseEntity<Map<String, Object>> getContacts(@RequestHeader("actor") String actor) {
        var contacts = repository.findByOwner(actor);
        var result = ImmutableMap.<String, Object>builder()
                .put("result", contacts)
                .put("count", contacts.size())
                .build();
        return ResponseEntity.ok(result);
    }
}
