public interface IMapper<T extends  IEntity> {
    void insert(T entity);
    void delete(T entity);
    void update(T entity);
    T find(T entity);
    ICollection<T> all();
    ICollection<T> all(int page);
}
