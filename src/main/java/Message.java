enum Message {
    TITLE("----Sport Management System----"),
    ENTER_COMAND(">>>"),
    MATCH_LIST("----Match List----");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void writeln(){
        System.out.println(this.message);
    }

    public void write(){
        System.out.print(this.message);
    }

    public String toString(){
        return this.message;
    }
}
