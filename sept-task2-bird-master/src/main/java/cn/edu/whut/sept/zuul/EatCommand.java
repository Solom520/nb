package cn.edu.whut.sept.zuul;

import java.util.Scanner;

/**
 * 吃魔法饼干命令类.
 * 玩家吃掉魔法饼干，可增加负重能力.
 */
public class EatCommand extends Command {
    public boolean execute(Game game) {
        Scanner input = new Scanner(System.in);
        Player player = game.getPlayer();
        if (!hasSecondWord()) {
            System.out.println("eat anything?");
            String name = input.nextLine();
            player.use(name);
            return false;
        }
        return false;
    }
}
