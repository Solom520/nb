package cn.edu.whut.sept.zuul;

/**
 * bcak命令类，输入"back"将玩家带回上一个房间.
 * 多次back会回到起点.
 * @author LuoLing
 * @version 1.0
 */
public class BackCommand extends Command {
    @Override
    public boolean execute(Game game) {
        String direction = game.getPath().getDirection();
        String backDirection;
        Player player = game.getPlayer();
        int number = game.getPath().getPathNumber();

        if (number == 0) {
            System.out.println("There is first room!");
        } else {
            switch (direction) { //返回方向与实际方向相反
                case "west":
                    backDirection = "east";
                    break;
                case "east":
                    backDirection = "west";
                    break;
                case "north":
                    backDirection = "south";
                    break;
                case "south":
                    backDirection = "north";
                    break;
                default:
                    backDirection = null;
                    break;
            }

            Room nextRoom = game.getCurrentRoom().getExit(backDirection);

            game.setCurrentRoom(nextRoom);
            game.getPath().reducePath();
            System.out.println(nextRoom.getLongDescription());
            player.step();
        }
        return false;
    }
}
