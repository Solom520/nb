package cn.edu.whut.sept.zuul;

/***
 * 虚拟命令类.
 * 得到返回游戏指令第二个字.
 * 提供虚函数供详细命令类继承.
 */
public abstract class Command {
    private String secondWord;

    public Command() {
        secondWord = null;
    }

    /**
     * @return 返回命令的第二个字,如果命令没有第二个字就返回空.
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * @return 如果命令有第二个字则返回true.
     */
    public boolean hasSecondWord() {
        return secondWord != null;
    }

    /**
     * 设置第二个字.
     */
    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }
    public abstract boolean execute(Game game);
}
