package fr.yoann.architecturemodulaire.bo;

public class Ligne {

    Produit produit = new Produit();
    private int quantite;

    public Ligne() {
    }

    public Ligne(final Produit produit, final int quantite) {
        this.quantite = quantite;
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(final int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(final Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Ligne [quantite=" + quantite + ", produit=" + produit + "]";
    }

}
