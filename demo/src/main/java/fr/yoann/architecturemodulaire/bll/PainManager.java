package fr.yoann.architecturemodulaire.bll;

import fr.yoann.architecturemodulaire.bo.Pain;
import fr.yoann.architecturemodulaire.dal.DALException;
import fr.yoann.architecturemodulaire.dal.DAO;
import fr.yoann.architecturemodulaire.dal.DAOFactory;

public class PainManager {
    private static volatile PainManager instance;
    private static DAO<Pain> painImpl;

    private PainManager() {
        painImpl = DAOFactory.getPainDAO();
    }

    public static PainManager getInstance() {
        if (instance == null) {
            synchronized (PainManager.class) {
                if (instance == null) {
                    instance = new PainManager();
                }
            }
        }
        return instance;
    }

    public void add(Pain pain) throws BLLException {
        validate(pain);
        try {
            painImpl.insert(pain);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'ajout du pain", e);
        }
    }

    public void validate(Pain pain) throws BLLException {
        if (pain.getQteStock() < 0) {
            throw new BLLException("La quantité de pain est négative");
        }
        if (pain.getPrixUnitaire() < 0) {
            throw new BLLException("Le prix du pain est négatif");
        }
        if (pain.getPrixUnitaire() > 100) {
            throw new BLLException("Le prix du pain est trop élevé");
        }
        if (pain.getQteStock() > 100) {
            throw new BLLException("La quantité de pain est trop élevée");
        }
        if (Pain.getPoids() < 0) {
            throw new BLLException("Le poids du pain est négatif");
        }

        if (Pain.getPoids() > 1000) {
            throw new BLLException("Le poids du pain est trop élevé");
        }
    }
}