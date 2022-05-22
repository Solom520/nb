package cn.edu.whut.sept.zuul;

import java.util.Scanner;

/**
 * 丢弃物品命令类.
 * 可以选择丢弃一件物品或者全部物品.
 */
public class DropCommand extends Command
{
    public boolean execute(Game game) {
        Scanner input = new Scanner(System.in);
        Player player = game.getPlayer();
        System.out.println("You want to discard 1. One item 2. All items?");
        System.out.print("> ");
        int choose = Integer.parseInt(input.next());
        if(choose == 1){
            Scanner input2 = new Scanner(System.in);
            System.out.print("Please input the item's name:");
            String inputLine = input2.nextLine();
            player.dropItem(inputLine);
        }
        else if(choose == 2)
            player.dropItem();
        return false;
    }
}