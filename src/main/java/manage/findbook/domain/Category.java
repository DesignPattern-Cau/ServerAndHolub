package manage.findbook.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "Category_id")
    private Long category_id;

    private String name;
}
