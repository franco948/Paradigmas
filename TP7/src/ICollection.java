import java.util.List;

public interface ICollection<T> {
     void add(T item);
     void remove(T item);
     T get(int index);
}
