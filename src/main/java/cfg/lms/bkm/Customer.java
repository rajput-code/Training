package cfg.lms.bkm;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("customer")
@Data
public class Customer extends User {
   private String email;
}
