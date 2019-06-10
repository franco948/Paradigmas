public abstract class Entity implements IEntity {
    private int id;

    public Entity()
    {
        setId(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
