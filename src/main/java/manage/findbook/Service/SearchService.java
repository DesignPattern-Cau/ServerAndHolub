package manage.findbook.Service;

import holub.database.jdbc.HolubRepository;
import lombok.AllArgsConstructor;
import manage.findbook.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private HolubRepository<Book> repository =new HolubRepository<>();



}
