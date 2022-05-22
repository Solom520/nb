package cn.edu.whut.sept.zuul;

import java.util.*;

/**
 * 玩家信息类.
 * 用于玩家建立，进行玩家操作相关.
 */
public class Player {
    private String name;
    private int strength = 160; // 默认玩家体力
    private int maxWeight = 100; // 负重值
    private Room currentRoom;
    private int nowWeight = 0;
    private Map<String, Item> bag = new HashMap<>();

    /**
     * 构造函数，完成建立.
     * @param username 玩家名.
     * @param room 房间.
     * @param weight 玩家负重.
     */
    public Player(String username, Room room, int weight) {
        name = username;
        currentRoom = room;
        maxWeight = weight;
        nowWeight = 0;
    }

    /**
     * 每一次的行走都会消耗玩家体力.
     * 每次减少5.
     */
    public void step() {
        strength -= 5;
        System.out.println("You expended 5 points of energy.");
        System.out.println("Now you have " + strength + " points of energy.");
    }

    /**
     * 游戏结束提示.
     */
    private void decideEnd() {
        if (strength % 10 == 2) {
            System.out.println("You used all the steles and gave up the chance to save your home. He became the new owner of black curse island!");
            System.out.println("Congratulations, game clearance, the end of one!");
        } else if (strength % 10 == 9) {
            System.out.println("You sacrifice the curse. In exchange, God will release the curse on your people!");
            System.out.println("Congratulations, game clearance, the end of two!");
        }
    }

    /**
     * 捡起物品.
     * @param item 返回物品信息.
     */
    public void take(Item item) {
        int lastweight = getNowWeight();
        int maxweight = getMaxWeight();
        if (lastweight + item.getWeight() <= maxweight) {
            setNowWeight(lastweight + item.getWeight());
            bag.put(item.getName(), item);
            System.out.println("Now you're carrying " + getNowWeight() + " weights goods");
        } else {
            System.out.println("Sorry,you can't take so many things !");
        }
    }

    /**
     * 使用物品.
     * @param name 物品名称.
     */
    public void use(String name) {
        Item item = bag.get(name);
        bag.remove(name);

        if (item != null) {
            if (item.getName().equals("Magic cookie")) {
                System.out.println("You eat a magic cookie!");
                int maxweight = getMaxWeight();
                maxweight = maxweight * 2;
                setMaxWeight(maxweight);
                System.out.println("Now you have " + maxweight + " maximum load bearing capacity");
            } else {
                if (item.getStrength() != 0) {
                    int lastStrength = strength;
                    strength += item.getStrength();
                    if (strength - lastStrength < 0) {
                        System.out.println("You lost " + (lastStrength - strength) + " points of energy.");
                    } else {
                        System.out.println("You gained " + (strength - lastStrength) + " points of energy.");
                    }
                    System.out.println("Now you have " + strength + " points of energy.");
                }
                if (item.getWeight() != 0) {
                    int lastweight = getNowWeight();
                    lastweight -= item.getWeight();
                    setNowWeight(lastweight);
                    System.out.println("Now you're carrying " + lastweight + " weights goods");
                }
            }
        } else {
            System.out.println("You don't have anything like " + name + ".");
        }
    }

    /**
     * 死亡判断.
     * 体力死亡或者负重死亡.
     * @return 死亡返回true，否则返回false.
     */
    public boolean isDead() {
        if (strength <= 0) {
            System.out.println("You're exhausted! With a daze, you fall to the ground.");
            System.out.println("The darkness soon engulfs the exhausted you");
            return true;
        }
        else if (maxWeight <= nowWeight) {
            System.out.println("You're dead tired");
            System.out.println("The darkness soon engulfs the dying you");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查看物品.
     */
    public void lookItem() {
        if (bag.isEmpty()) {
            System.out.println("Sorry,you have nothing!");
        } else {
            System.out.println("You have ");
            bag.keySet().stream().forEach(key -> System.out.println(key + "[weight：" + bag.get(key).getStrength() + ",life：" +bag.get(key).getWeight()+ "] "));
            System.out.println("Now you're carrying " + getNowWeight() + " weights goods");
            System.out.println("Now you have " + getMaxWeight() + " maximum load bearing capacity");
        }
    }

    /**
     * 丢弃全部物品.
     */
    public void dropItem() {
        if (bag.isEmpty()) {
            System.out.println("Sorry,you have nothing to drop.");
        } else {
            bag.clear();
            setNowWeight(0);
        }
    }

    /**
     * 丢弃某件物品.
     * @param name 物品名称.
     */
    public void dropItem(String name) {
        Item item = bag.get(name);
        bag.remove(name);
        if (item != null) {
            int lastweight = getNowWeight() - item.getWeight();
            setNowWeight(lastweight);
            System.out.println("You drop something named "+ name);
            System.out.println("Now you're carrying " + getNowWeight() + " weights goods");
        }
        else
            System.out.println("sorry,you don't have it");
    }

    /**
     * 触发陷阱.
     * @param trap 相关陷阱实例.
     */
    public void harm(Trap trap) {
        System.out.println("You have been attacked by" + trap.getName() + ".");
        if (trap.getStrengthDown() != 0) {
            strength -= trap.getStrengthDown();
            System.out.println("You lost " + trap.getStrengthDown() + " points of energy.");
            System.out.println("Now you have " + strength + " points of energy.");
        }

        if (trap.getWeightDown() != 0) {
            maxWeight -= trap.getWeightDown();
            System.out.println("You lost " + trap.getWeightDown() + " maximum load bearing capacity");
            System.out.println("Now you have " + maxWeight + " maximum load bearing capacity");
        }
    }

    /**
     * 得到玩家名.
     * @return 返回玩家名。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置玩家名.
     * @param name 玩家名.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 得到房间名.
     * @return 返回房间名.
     */
    public Room getRoom() {
        return currentRoom;
    }

    /**
     * 设置房间名.
     * @param room 房间名.
     */
    public void setRoom(Room room) {
        currentRoom = room;
    }

    /**
     * 设置最大负重.
     * @param maxWeight 最大负重值.
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * 得到最大负重值.
     * @return 返回最大负重值
     */
    public int getMaxWeight() {
        return this.maxWeight;
    }

    /**
     * 得到当前负重值.
     * @return 返回当前负重值.
     */
    public int getNowWeight() {
        return nowWeight;
    }

    /**
     * 设置当前负重值.
     * @param nowWeight 当前负重值.
     */
    public void setNowWeight(int nowWeight) {
        this.nowWeight = nowWeight;
    }
}
