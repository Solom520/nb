package cn.edu.whut.sept.zuul;

/**
 * 直接返回最初起点命令.
 * 输入advanback直接返回起点.
 */
public class AdvancedBackCommand extends Command {
    public boolean execute(Game game) {
        int number = game.getPath().getPathNumber();
        while (number != 1) {
            String direction = game.getPath().getDirection();
            String backDirection;
            Player player = game.getPlayer();
            number = game.getPath().getPathNumber();
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
            player.step();
        }
        System.out.println(game.getCurrentRoom().getLongDescription());
        return false;
    }
}
