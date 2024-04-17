package life.thedeveloper.smarttouch.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash("contacts")
public record Contact(
        @Id @NotBlank String id,
        @NotBlank String name,
        @Indexed @NotBlank @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email,
        @Indexed @NotBlank String owner) {
}
