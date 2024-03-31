package life.thedeveloper.smarttouch.infrastructure.web;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import jakarta.validation.Valid;
import life.thedeveloper.smarttouch.domain.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController extends Controller {

    @PostMapping("/contacts")
    public ResponseEntity<Map<String, Object>> createContact(@Valid @RequestBody Contact contact, @RequestHeader Map<String, String> headers) {
        var result = ImmutableMap.<String, Object>builder()
                .put("contact", contact)
                .put("headers", headers)
                .build();
        return ResponseEntity.ok(result);
    }

}
