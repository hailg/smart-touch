package life.thedeveloper.smarttouch.infrastructure;

import life.thedeveloper.smarttouch.domain.model.Contact;
import life.thedeveloper.smarttouch.infrastructure.repository.ContactRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initialization implements InitializingBean {
    private final ContactRepository contactRepository;

    @Autowired
    public Initialization(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        var contact1 = new Contact(
                "1",
                "Hai Le",
                "hailegia@gmail.com",
                "hailegia"
        );
        var contact2 = new Contact(
                "2",
                "Thao Doan",
                "thaodoannp@gmail.com",
                "hailegia"
        );
        var contact3 = new Contact(
                "3",
                "Test",
                "test@gmail.com",
                "thaodoan"
        );
        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);
    }
}
