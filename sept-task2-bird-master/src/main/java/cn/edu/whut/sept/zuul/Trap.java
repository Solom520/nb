package cn.edu.whut.sept.zuul;

/**
 * 陷阱类.
 * 构造房间内的陷阱.
 */
public class Trap {
    private String name;
    private int strengthDown;
    private int weightDown;

    /**
     * 构造陷阱效果.
     * @param name 陷阱名称.
     * @param strengthDown 体力减少值.
     * @param weightDown 负重值减少值.
     */
    public Trap(String name, int strengthDown, int weightDown) {
        this.name = name;
        this.strengthDown = strengthDown;
        this.weightDown = weightDown;
    }

    /**
     * 得到体力值减少值.
     * @return 返回体力值减少值.
     */
    public int getStrengthDown() {
        return this.strengthDown;
    }

    /**
     * 得到生命值/负重值减少值.
     * @return 返回命值/负重值减少值.
     */
    public int getWeightDown() {
        return this.weightDown;
    }

    /**
     * 得到陷阱名称.
     * @return 返回陷阱名称.
     */
    public String getName() {
        return this.name;
    }
}
