package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

/**
 * 查看房间内物品命令类.
 * 查看当前房间内物品名称.
 */
public class LookCommand extends Command {
    public boolean execute(Game game) {
        Room currentRoom = game.getCurrentRoom();
        ArrayList<Item> items= currentRoom.getItemList();
        if(items.size()==0){
            System.out.println("you look nothing in the room");
        }
        else{
            for(int i=0;i<items.size();i++){
                System.out.println("There is a " + items.get(i) + " in the room.");
            }
        }
        return false;
    }
}
