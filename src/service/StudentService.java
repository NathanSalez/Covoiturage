/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.DaoException;
import dao.DaoFactory;
import dao.PersistenceType;
import model.Student;
import service.validator.Validator;
import dao.StudentDao;
import java.util.Collection;

/**
 * Cette classe utilise le patron de conception Singleton.<br/>
 * Son instance est à récupérer avec la méthode statique <u>getInstance()</u>
 * Son rôle est d'effectuer les traitements métiers suivants :
 * <ul>
 *  <li>Validation d'un objet Student.</li>
 *  <li>Intéractions avec la base de données concernant les objets Student.</li>
 * </ul>
 * @author Nathan Salez
 */
public class StudentService implements Validator<Student> {
    
    private static StudentService instance;
    
    private StudentDao studentDao;
    
    
    private StudentService() throws DaoException
    {
        studentDao = DaoFactory.getDaoFactory(PersistenceType.JDBC).getStudentDao();
    }

    /**
     * Un étudiant est valide si et seulement si :
     * Il ne vaut pas null, (NullPointerException)
     * Son nom ne vaut pas null
     * @param object 
     */
    @Override
    public void validate(Student object) throws IllegalArgumentException {
        
        if( object.getName() == null | object.getName().isEmpty())
            throw new IllegalArgumentException("le nom de l'étudiant est vide.");
        
    }
    
    
    public static StudentService getInstance() throws DaoException
    {
        if( instance == null)
            instance = new StudentService();
        
        return instance;
    }
    
    public void registerStudent(String name, String firstName) throws IllegalArgumentException, DaoException
    {
        Student s = new Student(name, firstName);
        validate(s);
        studentDao.create(s);
    }
    
    public Collection<Student> getStudentCollection() throws DaoException
    {
        return studentDao.findAll();
    }


}
