/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.DaoException;
import dao.PersistenceType;
import dao.UsagerDao;
import dao.impl.jdbc.JdbcFactory;
import model.Usager;
import service.validator.Validator;

/**
 *
 * @author naysson
 */
public class UsagerService implements Validator<Usager> {
    
    private UsagerDao usagerDao;
    
    private static final int MAX_LENGTH_STRING = 50;
    
    public UsagerService() throws DaoException
    {
        usagerDao = JdbcFactory.getDaoFactory(PersistenceType.JDBC).getUsagerDao();
    }
    
    public void inscrireUsager(String nom, String prenom, String login, String mdp, String confirmation, String numeroTelephone) throws DaoException, IllegalArgumentException
    {
        Usager usagerAInscrire = new Usager(0, login, mdp, numeroTelephone, nom, prenom);
        
        if( ! confirmation.equals( usagerAInscrire.getMotDePasse() ))
            throw new IllegalArgumentException("Les champs mot de passe et confirmation ne correspondent pas.");
        
        validate(usagerAInscrire);
        
        usagerDao.create(usagerAInscrire);
        
    }
    
    public int connecterUsager(String login, String mdp) throws DaoException, IllegalArgumentException
    {
        Usager usagerConnecte = usagerDao.connecter(login, mdp);
        if( usagerConnecte == null)
            throw new IllegalArgumentException("Echec de tentative de connexion.");
        
        return usagerConnecte.getId();
    }

    @Override
    public void validate(Usager usager) throws IllegalArgumentException {
        
        String login = usager.getLogin();
        if( login == null || login.isEmpty() )
            throw new IllegalArgumentException("Le login est vide.");
        if( login.length() >= MAX_LENGTH_STRING)
            throw new IllegalArgumentException("Le login doit avoir moins de 50 caractères.");
        
        String password = usager.getMotDePasse();
        if( password == null || password.isEmpty() )
            throw new IllegalArgumentException("Le mot de passe est vide.");
        if( password.length() >= MAX_LENGTH_STRING)
            throw new IllegalArgumentException("Le mot de passe doit avoir moins de 50 caractères.");
        
        String prenom = usager.getPrenom();
        if( prenom != null && prenom.length() >= MAX_LENGTH_STRING )
            throw new IllegalArgumentException("Le prénom doit avoir moins de 50 caractères.");
        
        String nom = usager.getNom();
        if( nom != null && nom.length() >= MAX_LENGTH_STRING )
            throw new IllegalArgumentException("Le nom doit avoir moins de 50 caractères.");
        
        String numeroTel = usager.getNumeroTelephone();        
        if( numeroTel == null || ! numeroTel.matches("\\d{10}") )
            throw new IllegalArgumentException("Le numéro de téléphone est incorrect.");
    }
    
    
}
