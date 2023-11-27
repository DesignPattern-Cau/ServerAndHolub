package manage.findbook.domain;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDO {

    private Long book_idx;
    private String title;
    private Integer price;
    private Integer quantity;
    private String author_name;
    private Integer sales;
    private String category;
    private Integer likes;
    private String description;
    private String registered_at;
    private String ISBN;
    private Integer page;
    private boolean canBorrow;
    private String imgURL;


}
