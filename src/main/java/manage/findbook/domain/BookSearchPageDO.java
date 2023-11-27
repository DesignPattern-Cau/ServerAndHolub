package manage.findbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookSearchPageDO {
    private int page;
    private int size;
    List<BookDO> bookList;
}
