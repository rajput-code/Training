package cfg.lms.bkm;

import lombok.Data;

@Data
public class Student {
   private int studentId;
   private String studentName;
   private Course course;
}
