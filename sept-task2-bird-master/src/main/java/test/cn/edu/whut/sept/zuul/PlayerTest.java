package test.cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** 
* Player Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 8, 2021</pre> 
* @version 1.0 
*/ 
public class PlayerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: step() 
* 
*/ 
@Test
public void testStep() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: take(Item item) 
* 
*/ 
@Test
public void testTake() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: use(String name) 
* 
*/ 
@Test
public void testUse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: isDead() 
* 
*/ 
@Test
public void testIsDead() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: lookItem() 
* 
*/ 
@Test
public void testLookItem() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: dropItem() 
* 
*/ 
@Test
public void testDropItem() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: dropItem(String name) 
* 
*/ 
@Test
public void testDropItemName() throws Exception { 
//TODO: Test goes here...
    String inputCommand="";
    String expectOutput="\r";
    System.setIn(new ByteArrayInputStream(inputCommand.getBytes()));
    ByteArrayOutputStream outContent=new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Main.main(null);

    String[] outputs = outContent.toString().split("\n");
    int outputLength=outputs.length;

//    体现输出行数
    String actual=outputs[outputLength-4];
    Assert.assertEquals(actual,expectOutput);
} 

/** 
* 
* Method: harm(Trap trap) 
* 
*/ 
@Test
public void testHarm() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRoom() 
* 
*/ 
@Test
public void testGetRoom() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setRoom(Room room) 
* 
*/ 
@Test
public void testSetRoom() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setMaxWeight(int maxWeight) 
* 
*/ 
@Test
public void testSetMaxWeight() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMaxWeight() 
* 
*/ 
@Test
public void testGetMaxWeight() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getNowWeight() 
* 
*/ 
@Test
public void testGetNowWeight() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setNowWeight(int nowWeight) 
* 
*/ 
@Test
public void testSetNowWeight() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: decideEnd() 
* 
*/ 
@Test
public void testDecideEnd() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Player.getClass().getMethod("decideEnd"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
