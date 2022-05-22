package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

/**
 * 捡起物品命令类.
 * 捡起房间内存有物品。
 */
public class TakeCommand extends Command
{
    public boolean execute(Game game)
    {
        Room currentRoom = game.getCurrentRoom();
        Player player = game.getPlayer();
        ArrayList<Item> items= currentRoom.getItemList();
        if(items.size()==0){
            System.out.println("There is nothing.");
        }
        else{
            for(int i=0;i<items.size();i++){
                player.take(items.get(i));
                System.out.println("you get something like " + items.get(i).getName() + "." +items.get(i).toString());
            }
            currentRoom.removeItems();
        }


        return false;
    }
}
