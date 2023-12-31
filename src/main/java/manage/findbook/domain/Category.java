package manage.findbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "Category_id")
    private Long id;

    private String name;
}
