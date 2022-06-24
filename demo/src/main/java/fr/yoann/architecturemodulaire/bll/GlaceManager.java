package fr.yoann.architecturemodulaire.bll;

import fr.yoann.architecturemodulaire.bo.Glace;
import fr.yoann.architecturemodulaire.bo.ProduitPerissable;
import fr.yoann.architecturemodulaire.dal.DALException;
import fr.yoann.architecturemodulaire.dal.DAO;
import fr.yoann.architecturemodulaire.dal.DAOFactory;

import java.time.LocalDate;

public class GlaceManager {
    private static volatile GlaceManager instance;
    private static DAO<Glace> glaceImpl;

    private GlaceManager() {
        glaceImpl = DAOFactory.getGlaceDAO();
    }

    public static GlaceManager getInstance() {
        if (instance == null) {
            synchronized (GlaceManager.class) {
                if (instance == null) {
                    instance = new GlaceManager();
                }
            }
        }
        return instance;
    }

    public void add(Glace glace) throws DALException {
        validate(glace);
        try {
            glaceImpl.insert(glace);
        } catch (DALException e) {
            throw new DALException("Erreur lors de l'ajout de la glace", e);
        }
    }

    public void validate(Glace glace) throws DALException {
        if (ProduitPerissable.getDateLimiteConso().isBefore(LocalDate.now())) {
            throw new DALException("La date limite de consommation est dépassée");
        }
        if (glace.getQteStock() < 0) {
            throw new DALException("La quantité de glace est négative");
        }
        if (glace.getPrixUnitaire() < 0) {
            throw new DALException("Le prix de la glace est négatif");
        }
        if (glace.getPrixUnitaire() > 100) {
            throw new DALException("Le prix de la glace est trop élevé");
        }
        if (glace.getQteStock() > 100) {
            throw new DALException("La quantité de glace est trop élevée");
        }
    }
}
