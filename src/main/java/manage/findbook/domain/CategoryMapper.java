package manage.findbook.domain;

import holub.database.jdbc.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper<T> implements DataMapper<T> {

    private static CategoryMapper INSTANCE = new CategoryMapper();

    private CategoryMapper(){}

    public static CategoryMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public List<T> mapResultSetToObject(ResultSet resultSet) throws SQLException {
        List<T> resultList = new ArrayList<>();
        while(resultSet.next()){
            Long category_id = resultSet.getLong("category_id");
            String name = resultSet.getString("name");
            int discount_rate = resultSet.getInt("discount_rate");
            Category category = new Category();
            category.setCategory_id(category_id);
            category.setName(name);
            resultList.add((T)category);
        }
        return resultList;
    }
}
