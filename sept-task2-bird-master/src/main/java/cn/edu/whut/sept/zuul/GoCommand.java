package cn.edu.whut.sept.zuul;


/**
 * go命令类.
 * 前往所选方向的下一个房间，该方向无门给出相应提示.
 */
import java.util.ArrayList;
import java.util.Random;

public class GoCommand extends Command {
    public boolean execute(Game game) {
        if (!hasSecondWord()) {
            System.out.println("Go where?");
//            这里增加return，不然就会出现下面"There is no door!"的情形

            return false;
        }

        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();
        Player player = game.getPlayer();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if (nextRoom.getShortDescription().equals("You enter the magic transporting room,you will be transporting to a random room,good luck!")) {
            Random random = new Random();
            ArrayList<Room> rooms = game.getRoomList(); //获取总房间列表（不包括传送房本身）
            int RoomNumber = random.nextInt(rooms.size()); //随机生成数组下标
            currentRoom = rooms.get(RoomNumber);
            System.out.println("You are transporting to a random room...");
            game.setCurrentRoom(currentRoom); //当前房间设置为传送房
            System.out.println(currentRoom.getLongDescription()); //输出房间信息
            return false;
        } else {
            game.setCurrentRoom(nextRoom);
            game.getPath().setPath(direction);
            System.out.println(nextRoom.getLongDescription());
            player.step();
            player.setRoom(currentRoom);
            if (currentRoom.getTrap() != null) {
                player.harm(currentRoom.getTrap());
                currentRoom.removeTrap();
            }
        }
        return false;
    }
}
