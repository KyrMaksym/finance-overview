package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Vladimir on 12.07.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements InitDTO{
    Integer id;
    String name;
}
