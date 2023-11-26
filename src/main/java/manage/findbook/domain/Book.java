package manage.findbook.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter @Setter
@Builder
@ToString
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_idx")
    private Long id;
    private int price;
    private int quantity;
    private int sales;
    private int page;
    private int likes;
    private String registered_at;
    private String title;
    private String description;
    private String ISBN;
    private long authorId;
    private long categoryId;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
