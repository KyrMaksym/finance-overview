package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by BSyvuliak on 09.07.2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO implements InitDTO {

     Integer id;
     String login;
     String name;
     Integer roleID;

}
