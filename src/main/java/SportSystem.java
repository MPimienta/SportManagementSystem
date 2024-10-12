public class SportSystem {

    private final CommandHandler commandHandler;

    public SportSystem(){
        this.commandHandler = new CommandHandler();
    }

    private void start(){
        Message.TITLE.writeln();
        this.commandHandler.initialize();
        do{
            Message.ENTER_COMAND.write();
            this.commandHandler.readCommand();
        }while(true);
    }

    public static void main(String[] args) {
        new SportSystem().start();
    }
}
