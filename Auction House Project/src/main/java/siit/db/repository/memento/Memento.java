package siit.db.repository.memento;

public abstract class Memento {
    protected abstract void update(Memento memento);
}
