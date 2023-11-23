package manage.findbook.Repository;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Search {

    private String keyword;
    private String type;

    public String toString() {
        return "Search [keyword=" + keyword + ", type=" + type + "]";
    }
}
