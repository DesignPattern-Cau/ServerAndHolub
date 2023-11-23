package manage.findbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_idx")
    private Long id;
    private int price;
    private int quantity;
    private int sales;
    private int page;
    private LocalDateTime registered_at;
    private String title;
    private String description;
    private String ISBN;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
