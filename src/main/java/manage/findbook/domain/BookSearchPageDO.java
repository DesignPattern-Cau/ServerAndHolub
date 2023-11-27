package manage.findbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookSearchPageDO {
    List<BookDO> bookList;
}
