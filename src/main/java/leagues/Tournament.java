package leagues;

import jdk.jfr.Category;

public class Tournament {
    private final String name;
    private final String startDate; //change to DateTime
    private final String endDate;   //change to DateTime
    private final String league;
    private final String sport;
    private final String categorie;

    public Tournament(String name, String startDate, String endDate, String league, String sport, String categorie){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.league = league;
        this.sport = sport;
        this.categorie = categorie;
    }

    public String getName() {
        return name;
    }


}
