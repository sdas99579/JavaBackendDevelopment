package org.gfg.JBDL_64_DBConnectivity.repositories;

import org.gfg.JBDL_64_DBConnectivity.Person;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class PersonRepository implements IPerson{


//    @Autowired
    private Connection connection;


    public PersonRepository(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();
    }


    //Connecttion with my db
    public List<Person> getAllPerson()
    {
        List<Person> list =  new ArrayList<>();

            try {
                ResultSet set = connection.createStatement().executeQuery("select * from person");
                while (set.next())
                {
                    Person p = new Person(set.getString("name"),set.getInt("id"));
                    list.add(p);
                }

                return list;


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//            finally {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }

    }

    public void createTable() throws SQLException {
        connection.createStatement().execute("create table if not exists person(name varchar(25), id int primary key);");
    }

    public boolean insertPerson(Person person) throws SQLException {
        return connection.createStatement().execute("insert into person (name,id) values('"+person.getName()+"','"+person.getId()+"')");
    }

//    @Override
//    public int updatePerson(Person person) {
//        return 0;
//    }

//        public boolean updatePerson(Person person) throws SQLException {
//        return connection.createStatement().execute("update person set name = '"+person.getName()+"' where id = '"+person.getId()+"'");
//    }
    public int updatePerson(String name, Integer id) throws SQLException{
        boolean autocommit = connection.getAutoCommit();

        try {

            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement("update person set name = ? where id=?");
            statement.setString(1,name);
            statement.setInt(2,id);


            connection.commit();
            connection.setAutoCommit(autocommit);


            return statement.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }

    }


    public boolean deletePerson(Person person) throws SQLException {
        return connection.createStatement().execute("delete from person where id = '"+person.getId()+"'");
    }


}
