/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Student;
import model.Usager;

/**
 *
 * @author naysson
 */
public class StudentListTable extends AbstractTableModel 
{
    
    private List<Student> students;
    
    private static final String[] HEADERS = {"id","first name","name"};
    
    public StudentListTable(Collection<Student> students)
    {
        if( students == null)
            throw new NullPointerException("Le paramètre students vaut null.");
        
        this.students = new ArrayList<>(students);
    }

    @Override
    public int getRowCount() {
       return students.size();
       Usager u = new Usager();
       u.getId();
       u.setId(123);
    }

    @Override
    public int getColumnCount() {
        return HEADERS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student currentStudent = students.get(rowIndex);
        switch(columnIndex)
        {
            case 0 :
                return currentStudent.getId();
                
            case 1 :
                return currentStudent.getFirstName();
                
            case 2 :
                return currentStudent.getName();
                
            default:
                throw new IllegalArgumentException("L'index de colonne de la table n'est pas pris en compte.");
        }
            
            
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int column) {
        return HEADERS[column];
    }
    
    
    
    
    
    
}
