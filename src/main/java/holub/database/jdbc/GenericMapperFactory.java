package holub.database.jdbc;

public class GenericMapperFactory {
    public static <T> DataMapper<T> createMapper(String className){
        try{
            Class<?> clazz = Class.forName("manage.findbook.domain."+className+"Mapper");
            DataMapper<T> dataMapper = (DataMapper<T>) clazz.getMethod("getInstance").invoke(null);
            return dataMapper;

        }catch (Exception e){
            return null;
        }
    }

}
