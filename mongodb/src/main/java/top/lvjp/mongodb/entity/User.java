package top.lvjp.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "users")
public class User implements Serializable {

    @Id
    private Integer id;

    private String username;

    private String password;

}
