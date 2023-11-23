package manage.findbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Author {

    @Id @GeneratedValue
    @Column(name = "author_id")
    private int id;

    private String name;
    private String description;



}
