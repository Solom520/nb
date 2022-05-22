package cn.edu.whut.sept.zuul;

/**
 * 检查房间内物品和玩家携带物品命令类.
 * 输入check命令，若有物品，给出各物品信息，否则给出相应提示.
 */
public class ItemsCommand extends Command {
    public boolean execute(Game game) {
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        if (room.getItem() != null) {
            System.out.println("There is\n" + room.getItem().toString());
        } else {
            System.out.println("There is nothing in the room!");
        }
        player.lookItem();
        return false;
    }
}
