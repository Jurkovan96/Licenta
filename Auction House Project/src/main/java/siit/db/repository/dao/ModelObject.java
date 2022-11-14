package siit.db.repository.dao;

public abstract class ModelObject {

    private final Integer id;

    public ModelObject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
