package life.thedeveloper.smarttouch.infrastructure.web;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import jakarta.validation.Valid;
import life.thedeveloper.smarttouch.domain.model.Contact;
import life.thedeveloper.smarttouch.infrastructure.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@EnableMethodSecurity
public class ContactController extends Controller {
    private final ContactRepository repository;

    @Autowired
    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/contacts")
    public ResponseEntity<Map<String, Object>> createContact(@Valid @RequestBody Contact contact, @RequestHeader Map<String, String> headers) {
        var result = ImmutableMap.<String, Object>builder()
                .put("contact", contact)
                .put("headers", headers)
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
