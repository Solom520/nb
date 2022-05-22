package cn.edu.whut.sept.zuul;

/**
 * 帮助命令类.
 * 打印帮助详细和所有正确指令.
 */
public class HelpCommand extends Command {
    private CommandWords commandWords;

    public HelpCommand(CommandWords words) {
        commandWords = words;
    }

    public boolean execute(Game game) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
