package manage.findbook.domain;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDO {

    private Long bookIdx;
    private String title;
    private Integer price;
    private Integer quantity;
    private String authorName;
    private Integer sales;
    private String category;
    private Integer likes;
    private String description;
    private String registeredAt;
    private String ISBN;
    private Integer page;
    private boolean canBorrow;
    private String imgURL;


}
