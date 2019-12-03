package utils;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class PasswordUtils {

    private ConfigurablePasswordEncryptor passwordEncryptor;
    
    /**
     * Algorithme utilisé pour le hachage des mots de passe.
     */
    private static final String CRYPT_ALGO = "SHA-256";

    private static PasswordUtils ourInstance = new PasswordUtils();

    public static PasswordUtils getInstance() {
        return ourInstance;
    }

    private PasswordUtils() {
        passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(CRYPT_ALGO);
        passwordEncryptor.setPlainDigest(true);
    }

    public String encryptPassword(String password)
    {
        return passwordEncryptor.encryptPassword(password);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword)
    {
        return passwordEncryptor.checkPassword(plainPassword, encryptedPassword );
    }
}
