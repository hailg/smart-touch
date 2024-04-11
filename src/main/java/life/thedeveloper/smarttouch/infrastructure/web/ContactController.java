package life.thedeveloper.smarttouch.infrastructure.web;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import jakarta.validation.Valid;
import life.thedeveloper.smarttouch.domain.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity
public class ContactController extends Controller {

    @PostMapping("/contacts")
    @PreAuthorize("hasAuthority('issues:view')")
    public ResponseEntity<Map<String, Object>> createContact(@Valid @RequestBody Contact contact, @RequestHeader Map<String, String> headers) {
        var result = ImmutableMap.<String, Object>builder()
                .put("contact", contact)
                .put("headers", headers)
                .build();
        return ResponseEntity.ok(result);
    }

}
