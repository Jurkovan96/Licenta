package siit.db.repository.mapper;

import siit.db.repository.dao.ModelObject;
import siit.db.repository.memento.Memento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class ResultSetMapper<T extends ModelObject, I extends Memento>{

    protected abstract T mapResultSet(ResultSet resultSet, int rowNumber) throws SQLException;

    public abstract Optional<T> findById(Integer id);

    public abstract void update(Integer id, I update);

    public abstract List<T> findAll();
}
