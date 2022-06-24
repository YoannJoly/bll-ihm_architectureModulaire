package fr.yoann.architecturemodulaire.bo;

public enum TypeCartePostale {
    Paysage("Paysage"), Portrait("Portrait");

    private String libelle;

    TypeCartePostale(String libelle) {
        this.libelle = libelle;
    }

}
