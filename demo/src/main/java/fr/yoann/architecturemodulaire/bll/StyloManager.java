package fr.yoann.architecturemodulaire.bll;

import fr.yoann.architecturemodulaire.bo.Stylo;
import fr.yoann.architecturemodulaire.dal.DALException;
import fr.yoann.architecturemodulaire.dal.DAO;
import fr.yoann.architecturemodulaire.dal.DAOFactory;

public class StyloManager {
    private static volatile StyloManager instance;
    private static DAO<Stylo> styloImpl;

    private StyloManager() {
        styloImpl = DAOFactory.getStyloDAO();
    }

    public static StyloManager getInstance() {
        if (instance == null) {
            synchronized (StyloManager.class) {
                if (instance == null) {
                    instance = new StyloManager();
                }
            }
        }
        return instance;
    }

    public void add(Stylo stylo) throws BLLException {
        validate(stylo);
        try {
            styloImpl.insert(stylo);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'ajout du stylo", e);
        }
    }

    public void validate(Stylo stylo) throws BLLException {
        if (stylo.getQteStock() < 0) {
            throw new BLLException("La quantité de stylo est négative");
        }
        if (stylo.getPrixUnitaire() < 0) {
            throw new BLLException("Le prix du stylo est négatif");
        }
        if (stylo.getPrixUnitaire() > 100) {
            throw new BLLException("Le prix du stylo est trop élevé");
        }
        if (stylo.getQteStock() > 100) {
            throw new BLLException("La quantité de stylo est trop élevée");
        }

        if (stylo.getCouleur() == null) {
            throw new BLLException("La couleur du stylo est null");
        }

        if (stylo.getCouleur().isEmpty()) {
            throw new BLLException("La couleur du stylo est vide");
        }

        if (stylo.getCouleur().length() > 10) {
            throw new BLLException("La couleur du stylo est trop longue");
        }

        if (stylo.getTypeMine() == null) {
            throw new BLLException("Le type de mine du stylo est null");
        }

        if (stylo.getTypeMine().isEmpty()) {
            throw new BLLException("Le type de mine du stylo est vide");
        }

        if (stylo.getTypeMine().length() > 10) {
            throw new BLLException("Le type de mine du stylo est trop longue");
        }

    }
}