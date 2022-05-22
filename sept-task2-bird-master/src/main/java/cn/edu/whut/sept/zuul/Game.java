/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 初始化游戏.
 * 建立地图，输出欢迎语，得到各实例对象.
 */
public class Game {

    private Parser parser;
    private Room currentRoom;
    private ArrayList<Room> RoomList;
    private Player player;
    private Path path;

    /**
     * 游戏初始化.
     */
    public Game() {
        RoomList = new ArrayList<>(); // 房间物品列表
//        parser = new Parser(); // 解析器实例
        path = new Path(); // 路径实例
        player = new Player("Tom", currentRoom, 100); // 玩家实例
        createRooms();
    }

    /**
     * 创建房间，连接建立地图.
     */
    private void createRooms() {
        Room outside, roomTwo, roomThree, roomFour, roomFive, roomSix, roomSeven, roomEight, roomNine, roomTen, roomEleven, roomTwelve, roomThirteen, roomFourteen, roomFifteen, roomSixteen, roomSeventeen, roomEighteen, roomNineteen, roomTwenty, roomTwentyone, roomTwentytwo, roomTwentythree, roomTwentyfour, roomTwentyfive;

        //create the rooms
        outside = new Room("You are come to the periphery of the black curse island. The island is surrounded by cliffs. There is only a dilapidated and damaged ancient stone gate in the north. It seems that someone is calling you, you have already decided.");
        roomTwo = new Room("You enter the courtyard of the non triumphal. You know that you have no way back. God has been away from your home for a long time.");
        roomThree = new Room("You have entered the room to admire the moon, and now you have to find the gods to save your home.");
        roomFour = new Room("You are in the room of complaint.");
        roomFive = new Room("You enter the spiral of meeting demons, the mysterious inscription: the black curse island is shrouded in darkness and cannot be an anchor.", new Item("Cursed thing", -10, 5));
        roomSix = new Room("You enter the warehouse of the false and the only one in the world that is related to God, but the legendary black curse island that is cursed by God for ever falling into darkness.");
        roomSeven = new Room("You are in the water of lament.");
        roomEight = new Room("You enter the resting place of the soldiers, the mysterious inscription: without anchor, the ferris wheel of the gods can't park in this world.", new Item("Mysterious inscription", 15, 15));
        roomNine = new Room("You're in the shrine to know false truth.");
        roomTen = new Room("You're in the cloister of modesty.");
        roomEleven = new Room("You enter the city of memory.", new Item("Magic cookie", 25, 5));
        roomTwelve = new Room("You enter the burning path of the traveler, the mysterious inscription: Black curse island is not a dead thing, it will choose its owner for itself.", new Item("Burning sword", 15, 25));
        roomThirteen = new Room("You're in the traitor tower");
        roomFourteen = new Room("You enter the miasmatic temple, you find the mysterious inscription.", new Item("Colorless liquid medicine", -5, 5));
        roomFifteen = new Room("You enter the corridor of the tombstone, which says: I want the gods to disappear!");
        roomSixteen = new Room("You're in the rotten vault.");
        roomSeventeen = new Room("You enter the forgotten factory.", new Item("The book of time", 15, 5));
        roomEighteen = new Room("You're in a blood dry cell.");
        roomNineteen = new Room("You enter the hidden home of the awakened. The mysterious inscription says: God will erode human nature and foster human servility.", new Item("Scepter of the elderly", 10, 15));
        roomTwenty = new Room("You have entered the training center without retreat.");
        roomTwentyone = new Room("You enter the foreign capital of tribe, where you find an old man in the shape of withered bones, who explains to you the origin of God and man in those years. In front of us, this ancient capital was the place where God settled down in the world. People's greed wanted everything from God, and God's arrogance wanted to enslave people. When people find the first dead god, ambition will grow madly in the bottom of their heart, and God also finds that the wings of inferior life have hardened. The war broke out, and finally the ancient capital was destroyed. God also lost the coordinates of the world. The residents of the ancient capital were cursed by God and went into exile. This curse is the suffering of your home today.", new Item("Secret history of ancient capital", 0, 10));
        roomTwentytwo = new Room("You enter the altar of black curse. The inscription under the altar says: if you offer the cursed things, you will always get the blessing of God. Make your choice. The result depends on the final score you get by using the item.");
        roomTwentythree = new Room("You enter the sky of fear, the mysterious inscription: Black curse island is the anchor of the gods.", new Item("Magic cookie", 25, 5));
        roomTwentyfour = new Room("You're in the magic monastic grounds, mysterious inscription: This is a trap!", new Trap("Rotten Dragon", 50, 50));
        roomTwentyfive = new Room("You enter the magic transporting room,you will be transporting to a random room,good luck!");

        outside.setExit("north", roomTwo);
        outside.AddItem(new Item("The book of time", 15, 5));
        outside.AddItem(new Item("Magic cookie", 25, 5));
        roomTwo.setExit("north", roomThree);
        roomTwo.setExit("south", outside);
        roomThree.setExit("east", roomFour);
        roomThree.setExit("south", roomTwo);
        roomThree.setExit("west", roomTwentythree);
        roomThree.setExit("north", roomSix);
        roomFour.setExit("north", roomFive);
        roomFour.setExit("west", roomThree);
        roomFive.setExit("south", roomFour);
        roomSix.setExit("north", roomSeven);
        roomSix.setExit("south", roomThree);
        roomSeven.setExit("west", roomEight);
        roomSeven.setExit("south", roomSix);
        roomSeven.setExit("north", roomNine);
        roomEight.setExit("east", roomSeven);
        roomEight.setExit("south", roomTwentyfive);
        roomNine.setExit("west", roomTen);
        roomNine.setExit("south", roomSeven);
        roomTen.setExit("west", roomEleven);
        roomTen.setExit("east", roomNine);
        roomEleven.setExit("south", roomThirteen);
        roomEleven.setExit("west", roomTwentyfour);
        roomEleven.setExit("north", roomTwelve);
        roomEleven.setExit("east", roomTen);
        roomTwelve.setExit("south", roomEleven);
        roomThirteen.setExit("south", roomFourteen);
        roomThirteen.setExit("north", roomEleven);
        roomFourteen.setExit("north", roomThirteen);
        roomFourteen.setExit("south", roomFifteen);
        roomFifteen.setExit("west", roomSixteen);
        roomFifteen.setExit("north", roomFourteen);
        roomSixteen.setExit("south", roomSeventeen);
        roomSixteen.setExit("east", roomFifteen);
        roomSeventeen.setExit("north", roomSixteen);
        roomSeventeen.setExit("south", roomEighteen);
        roomEighteen.setExit("south", roomTwenty);
        roomEighteen.setExit("east", roomNineteen);
        roomEighteen.setExit("north", roomSeventeen);
        roomNineteen.setExit("west", roomEighteen);
        roomTwenty.setExit("north", roomEighteen);
        roomTwenty.setExit("east", roomTwentyone);
        roomTwentyone.setExit("west", roomTwenty);
        roomTwentyone.setExit("east", roomTwentytwo);
        roomTwentytwo.setExit("west", roomTwentyone);
        roomTwentythree.setExit("east", roomThree);
        roomTwentyfour.setExit("east", roomEleven);
        roomTwentyfive.setExit("north", roomEight);

        //用数组存放不同的房间
        RoomList.add(outside);
        RoomList.add(roomFive);
        RoomList.add(roomNine);
        RoomList.add(roomThree);
        RoomList.add(roomTwelve);
        RoomList.add(roomTwentyone);
        RoomList.add(roomEight);
        RoomList.add(roomEleven);
        RoomList.add(roomFour);
        RoomList.add(roomFourteen);

        currentRoom = outside;  // start game outside
    }

    /**
     * 得到房间列表.
     * @return 房间列表.
     */
    public ArrayList<Room> getRoomList() {
        return RoomList;
    }

    /**
     * 游戏开始，判断命令是否正确.
     */
    public void play() {
        this.parser = new Parser();

        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            if (command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 打印游戏开始欢迎语句.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 得到玩家实例对象.
     * @return 返回玩家实例.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 得到路径实例.
     * @return 返回路径实例.
     */
    public Path getPath() {
        return path;
    }

    /**
     * 得到当前房间.
     * @return 返回当前房间.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 设置当前房间.
     * @param room 房间实例.
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
