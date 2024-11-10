package org.gfg.JBDL_64_DBConnectivity.repositories;

import org.gfg.JBDL_64_DBConnectivity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class SpringJDBCPerson implements IPerson{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Person> getAllPerson() {
        return jdbcTemplate.query("select * from person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person p = new Person(rs.getString("name"),rs.getInt("id"));
                return p;
            }
        });
    }

    @Override
    public void createTable() throws SQLException {
        return;
    }

    @Override
    public boolean insertPerson(Person person) throws SQLException {
        MapSqlParameterSource ParameterSource = new MapSqlParameterSource();
        ParameterSource.addValue("name",person.getName());
        ParameterSource.addValue("id",person.getId());

        namedParameterJdbcTemplate.update("insert into person(name,id) values(:name,:id)", ParameterSource);
        return false;
    }

//    @Override
//    public int updatePerson(Person person) {
//        return 0;
//    }

    @Override
    public int updatePerson(String name, Integer id) {
        namedParameterJdbcTemplate.execute("update person set name = '"+name+"' where id='"+id+"'", PreparedStatement::execute);
        return 0;
    }

    @Override
    public boolean deletePerson(Person person) throws SQLException {
        return false;
    }
}
