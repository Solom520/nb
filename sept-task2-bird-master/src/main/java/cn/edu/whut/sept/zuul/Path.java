package cn.edu.whut.sept.zuul;

import java.util.HashMap;

/**
 * 路径类，用于保存游戏进行中的方向输入.
 * 辅助back命令的实现.
 * @author LuoLing
 * @version 1.0
 */
public class Path {
    private int pathNumber; // 路径数
    private String direction; // 路径方向
    private HashMap<Integer, String> pathTable; //路径表

    /**
     * 路径初始化.
     */
    public Path() {
        pathNumber = 0;
        direction = null;
        pathTable = new HashMap<>();
    }

    /**
     * 根据路径方向设置路径表.
     * @param direction 路径方向.
     */
    public void setPath(String direction) {
        this.pathNumber++;
        this.direction = direction;
        pathTable.put(pathNumber, direction);
    }

    /**
     * 得到当前房间路径数.
     * @return 返回当前房间路径数.
     */
    public String getDirection() {
        return pathTable.get(pathNumber);
    }

    /**
     * 得到路径数.
     * @return 返回路径数.
     */
    public int getPathNumber() {
        return pathNumber;
    }

    /**
     * 路径次数减一.
     */
    public void reducePath() {
        this.pathNumber--;
    }
}
