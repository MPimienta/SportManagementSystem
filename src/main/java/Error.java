enum Error {
    INVALID_SCORE("\tNew score must be greater or equal to -999999.0"),
    INVALID_COMMAND("\tInvalid command"),
    TOO_MANY_ARGUMENTS("\tToo many arguments"),
    INVALID_ARGUMENT("\tInvalid argument"),
    PLAYER_ALREADY_EXISTS("\tPlayer already exists"),
    PLAYER_DOES_NOT_EXIST("\tPlayer does not exist"),
    WRONG_AMOUNT_OF_PLAYERS("\tThe amount of players to match must be 2"),
    UNEVEN_PLAYER_AMOUNT("\tThe amount of players is not even"),
    ALREADY_EXISTING_MATCH("\tThere is already a match")
    ;

    private final String error;

    Error(String error){
        this.error = error;
    }

    public void writeln(){
        System.out.println(this.error);
    }

    public String toString(){
        return this.error;
    }
}
