package cfg.lms.bkm;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component("librarian")

public class Librarian  extends User{
     private double  salary;
}
