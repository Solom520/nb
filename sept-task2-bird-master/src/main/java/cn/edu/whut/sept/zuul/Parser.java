package cn.edu.whut.sept.zuul;

import java.util.Scanner;

/**
 * 解析器类.
 * 获得玩家输入的命令.
 */
public class Parser {
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input

    /**
     * 创建从终端窗口读取的解析器.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 得到玩家输入的命令.
     * @return 返回用户的下一个命令.
     */
    public Command getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = this.reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
        }

        Command command = commands.get(word1);
        if (command != null) {
            command.setSecondWord(word2);
        }
        return command;
    }

    /**
     * 输出所有游戏指令.
     */
    public void showCommands() {
        commands.showAll();
    }
}

