/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl.jdbc;

import dao.DaoException;
import dao.DaoFactory;
import dao.StudentDao;

/**
 *
 * @author naysson
 */
public class JdbcFactory extends DaoFactory {

    @Override
    public StudentDao getStudentDao() throws DaoException
    {
        return JdbcStudentDao.getInstance();
    }
}
