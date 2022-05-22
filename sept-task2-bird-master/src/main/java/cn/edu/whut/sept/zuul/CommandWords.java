package cn.edu.whut.sept.zuul;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 命令单词类.
 * 存储所有正确的命令单词，建立继承的具体命令的实例.
 */
public class CommandWords {
    private HashMap<String, Command> commands;

    /**
     * 构造函数-初始化commandWord.
     */
    public CommandWords() {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
        commands.put("look", new LookCommand()); //查看房间内物品指令
        commands.put("take", new TakeCommand()); //捡起物品指令
        commands.put("Items", new ItemsCommand()); //检查房间和晚上携带物品指令
        commands.put("eat", new EatCommand()); //吃饼干指令
        commands.put("back", new BackCommand()); // 返回指令
        commands.put("drop", new DropCommand()); // 丢弃物品指令
        commands.put("advanback", new AdvancedBackCommand()); // 直接传送回起点指令

    }

    /**
     * 获取游戏指令.
     * @param word 游戏指令单词
     * @return 返回当前游戏指令单词
     */
    public Command get(String word) {
        return (Command) commands.get(word);
    }

    /**
     * 输出所有正确游戏指令.
     */
    public void showAll() {
        for (Iterator i = commands.keySet().iterator(); i.hasNext();) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }
}
