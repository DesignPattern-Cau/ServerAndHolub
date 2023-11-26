package manage.findbook.domain;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class BookListDO {

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


}
