/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl.jdbc;

import dao.DaoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import model.Student;
import dao.StudentDao;

/**
 * Classe implémentant l'interface <code>StudentDao</code>, utilisant le patron de conception Singleton.<br/>
 * Son instance est à récupérer avec la méthode statique <u>getInstance()</u><br/>
 * Son rôle est de gérer les intéractions entre l'application et une base de données JDBC.
 * @author Nathan Salez
 */
public class JdbcStudentDao extends JdbcDao<Student> implements StudentDao {

    private static JdbcStudentDao instance;
    
    private JdbcStudentDao() throws DaoException
    {  
        super();
    }
    
    /**
     * Cette méthode peut être appelée par toutes les classes du package dao.impl.jdbc 
     * @return
     * @throws DaoException 
     */
    static JdbcStudentDao getInstance() throws DaoException
    {
        if( instance == null )
            instance = new JdbcStudentDao();
        return instance;
    }

    @Override
    public void create(Student obj) throws DaoException
    {
        try {
            String query = "INSERT INTO STUDENT(LASTNAME,FIRSTNAME) VALUES(?,?)";
            PreparedStatement pstmt = connector.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getFirstName());
            pstmt.executeUpdate();
            ResultSet res = pstmt.getGeneratedKeys();
            if(!res.next())
                throw new DaoException("Etudiant déjà présent dans l'application.");
            res.close();
            pstmt.close();
            
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Student research(int id) throws DaoException {
        try
        {
            Student s = null;
            String query = "SELECT * FROM STUDENT S WHERE STUDENT.ID = ?";
            PreparedStatement pstmt = connector.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            if( res.next() )
            {
                s = new Student(id,res.getString("LASTNAME"), res.getString("FIRSTNAME"));
            }
            res.close();
            pstmt.close();
            return s;
        }catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Student obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Student obj) throws DaoException {
        
    }

    @Override
    public Collection<Student> findAll() throws DaoException {
        try {
            String query = "SELECT * FROM STUDENT";
            LinkedList<Student> studentList = new LinkedList<>();
            Statement stmt = connector.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() )
            {
                Student s = new Student(res.getInt("ID"),res.getString("LASTNAME"), res.getString("FIRSTNAME"));
                studentList.add(s);
            }
            res.close();
            stmt.close();
            return studentList;
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
    
    
    


}
