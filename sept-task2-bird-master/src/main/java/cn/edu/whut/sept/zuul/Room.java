package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * 房间类.
 * 建立房间信息.
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private Item item = null;
    private Trap trap = null;
    private ArrayList<Item> itemList = new ArrayList<>();

    /**
     * 构造房间描述.
     * @param description 房间描述.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * 构造房间物品.
     * @param description 房间描述.
     * @param item 物品实例.
     */
    public Room(String description, Item item) {
        this(description);
        this.item = item;
        itemList.add(item);
    }

    /**
     * 增加房间物品
     * @param item 物品参数
     */
    public void AddItem(Item item){
        itemList.add(item);
    }

    public ArrayList<Item> getItemList(){
        return itemList;
    }

    /**
     * 构造房间陷阱事件.
     * @param description 房间描述.
     * @param item 房间事件.
     * @param trap 陷阱实例.
     */
    public Room(String description, Item item, Trap trap) {
        this(description);
        this.item = item;
        this.trap = trap;
    }

    /**
     * 构造房间陷阱.
     * @param description 房间描述。
     * @param trap 陷阱实例.
     */
    public Room(String description, Trap trap) {
        this(description);
        this.trap = trap;
    }

    /**
     * 设置房间方向，相关方向所连接的房间.
     * @param direction 方向.
     * @param neighbor 连接房间名.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * 得到房间简要描述.
     * @return 返回Room的简要描述description,只有描述没有方向.
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * 得到房间详细描述.
     * @return 返回Room的仔细描述description,有可以走的方向.
     */
    public String getLongDescription() {
        return description + ".\n" + getExitString();
    }

    /**
     * 得到房间出口方向.
     * @return 所有出口/路径.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * @return 所有可以走的方向.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * 得到房间物品.
     * @return 返回物品实例.
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * 捡起物品后房间物品置空.
     */
    public void removeItems() {
        this.item = null;
        itemList.clear();
    }
    /**
     * 得到房间陷阱.
     * @return 返回陷阱实例.
     */
    public Trap getTrap() {
        return this.trap;
    }

    public void removeTrap() {
        this.trap = null;
    }
}


