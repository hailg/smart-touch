package life.thedeveloper.smarttouch.infrastructure.web;

import jakarta.validation.Valid;
import life.thedeveloper.smarttouch.domain.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController extends Controller {

    @PostMapping("/contacts")
    public ResponseEntity<String> createContact(@Valid @RequestBody Contact contact) {
        return ResponseEntity.ok("Contact created: " + contact);
    }
    
}
