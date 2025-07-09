package cfg.lms.bkm;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class User {
   private int userID;
   private String name;
}
