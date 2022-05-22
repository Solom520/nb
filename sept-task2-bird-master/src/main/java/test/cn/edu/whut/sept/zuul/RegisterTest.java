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
* Register Tester. 
* 
* @author <Authors name> 
* @since <pre>7�� 8, 2021</pre> 
* @version 1.0 
*/ 
public class RegisterTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
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
* Method: setID(String ID) 
* 
*/ 
@Test
public void testSetID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setPassword(String password) 
* 
*/ 
@Test
public void testSetPassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setconfirmpasswd(String confirmpassword) 
* 
*/ 
@Test
public void testSetconfirmpasswd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: JudgeRegister() 
* 
*/ 
@Test
public void testJudgeRegister() throws Exception { 
//TODO: Test goes here...
    /**
     * 修改两行命令以及之后的指令位置即可测试
     */
    String inputCommand="1\nhzj\n321\ngo east\nquit\n3\n";
    String expectOutput="> There is no door!\r";
    System.setIn(new ByteArrayInputStream(inputCommand.getBytes()));
    ByteArrayOutputStream outContent=new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Main.main(null);

    String[] outputs = outContent.toString().split("\n");
    int outputLength=outputs.length;
    String actual=outputs[outputLength-4];
    Assert.assertEquals(actual,expectOutput);
} 

/** 
* 
* Method: addAdmin() 
* 
*/ 
@Test
public void testAddAdmin() throws Exception { 
//TODO: Test goes here... 
} 


} 
