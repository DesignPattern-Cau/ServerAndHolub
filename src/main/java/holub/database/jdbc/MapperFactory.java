package holub.database.jdbc;

public interface MapperFactory {
    public <T> DataMapper<T> createMapper(String className);
}
