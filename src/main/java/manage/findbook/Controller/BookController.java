package manage.findbook.Controller;

import lombok.AllArgsConstructor;
import manage.findbook.Service.SearchService;
import manage.findbook.domain.BookDO;
import manage.findbook.domain.BookSearchPageDO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {

    private SearchService searchService;

    @GetMapping("/book/list")
    public BookSearchPageDO getBookListBySearch(
            @RequestParam String type,
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        try{
            List<BookDO> resultPage = searchService.getBookListPage(type, keyword, page, size);
            return new BookSearchPageDO(page,size,resultPage);
        }catch (Exception e){
            return null;
        }
    }

}
