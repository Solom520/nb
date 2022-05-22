package cn.edu.whut.sept.zuul;

/**
 * 物品类.
 * 房间内物品和玩家自身携带物品信息.
 */
public class Item {
    private String name;
    private int strength;
    private int weight;

    /**
     * 构造函数，实例化物品.
     * @param name 物品名称.
     * @param weight 物品重量.
     * @param strength 物品体力（增加或减少玩家体力）.
     */
    public Item(String name, int strength, int weight) {

        this.name = name;
        this.strength = strength;
        this.weight = weight;
    }

    /**
     * 得到物品体力
     * @return 返回物品体力.
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * 得到物品名称.
     * @return 物品名称.
     */
    public String getName() {
        return this.name;
    }

    /**
     * 显示物品信息.
     * @return 物品名称 重量 玩家负重值.
     */
    public String toString() {
        return "[name:" + name + "，weight:" + weight + "，strength:" + strength + "]";
    }

    /**
     * 得到玩家负重值.
     * @return 返回负重值.
     */
    public int getWeight() {
        return this.weight;
    }
}
