import java.util.LinkedList;
import java.util.List;

public class SmartCollection<T extends Entity> implements ICollection<T> {

    private IMapper<T> mapper;
    // Todo cambiar a SET?
    private List<T> list = new LinkedList<>();
    private int page;

    public SmartCollection(IMapper<T> mapper)
    {
        this.mapper = mapper;
        this.page = 1;
    }

    public SmartCollection(IMapper<T> mapper, int page)
    {
        this.mapper = mapper;
        this.page = page;
    }

    @Override
    public void add(T entity)
    {
        list.add(entity);
    }

    @Override
    public void remove(T entity) {

        list.remove(entity);
    }

    @Override
    public T get(int index) {
        // traer proxima pagina
        if (index >= list.size()) {
            SmartCollection col = (SmartCollection)mapper.all(++page);
            list.addAll(col.list);
        }

        return list.get(index);
    }
}
