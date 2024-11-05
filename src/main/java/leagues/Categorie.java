package leagues;

public enum Categorie {
    SCORE("score"),
    VICTORIES("victories"),
    ASSISTANCE_POINTS("assistance points"),
    TOURNAMENT_VICTORIES("tournament victories"),
    MONEY("money");

    private final String categorie;

    Categorie(String categorie) {
        this.categorie = categorie;
    }

    public String toString(){
        return this.categorie;
    }
}
