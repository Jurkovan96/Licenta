package siit.db.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;




}
