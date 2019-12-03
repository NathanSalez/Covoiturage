/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl.jdbc;

import dao.DaoException;
import dao.UsagerDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import model.Usager;

/**
 *
 * @author naysson
 */
public class JdbcUsagerDao extends JdbcDao<Usager> implements UsagerDao,RowMapper<Usager> {
    
    private static JdbcUsagerDao instance;
    
    private static final String REQUETE_INSCRIPTION_USAGER = "INSERT INTO COVOITURAGE.USAGER(login,password,numtel,nom,prenom) VALUES(?,?,?,?,?)";
    
    private static final String REQUETE_CONNEXION_USAGER = "SELECT * FROM COVOITURAGE.USAGER WHERE login = ? AND password = ?";
            
    public static JdbcUsagerDao getInstance() throws DaoException
    {
        if( instance == null)
            instance = new JdbcUsagerDao();
        
        return instance;
    }

    @Override
    public Usager connecter(String login, String motDePasse) throws DaoException {
        Usager usagerConnecte = null;
        try
        {
             PreparedStatement pstmt = connector.prepareStatement(REQUETE_CONNEXION_USAGER);
             pstmt.setString(1, login);
             pstmt.setString(2, motDePasse);
             
             ResultSet rs = pstmt.executeQuery();
             if( rs.next() )
             {
                 usagerConnecte = map(rs);
             }             
             rs.close();
             pstmt.close();
        } catch( SQLException ex)
        {
            throw new DaoException(ex);
        }
        
        return usagerConnecte;
    }

    @Override
    public void create(Usager obj) throws DaoException {
        try
        {
             PreparedStatement pstmt = connector.prepareStatement(REQUETE_INSCRIPTION_USAGER, Statement.RETURN_GENERATED_KEYS);
             pstmt.setString(1, obj.getLogin());
             pstmt.setString(2, obj.getMotDePasse());
             pstmt.setString(3, obj.getNumeroTelephone());
             pstmt.setString(4, obj.getNom());
             pstmt.setString(5, obj.getPrenom());
             
             int generatedKey = pstmt.executeUpdate();
             obj.setId(generatedKey);
             pstmt.close();
        } catch( SQLException ex)
        {
            throw new DaoException(ex);
        }     
    }

    @Override
    public Usager research(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usager obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usager obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Usager> findAll() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usager map(ResultSet rs) throws SQLException {
        return new Usager(
                rs.getInt("idUsager"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("numTel"),
                rs.getString("nom"), 
                rs.getString("prenom")
        );
    }
    
    
    
    
    
    private JdbcUsagerDao() throws DaoException
    {
        super();
    }

    

    
}
