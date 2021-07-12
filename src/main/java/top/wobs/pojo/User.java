package top.wobs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id;
    String userName;
    String userPassword;
    String userNumber;
    String userType;


}
