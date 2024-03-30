package life.thedeveloper.smarttouch.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Contact(@NotBlank String name,
                      @NotBlank @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email) {
}
