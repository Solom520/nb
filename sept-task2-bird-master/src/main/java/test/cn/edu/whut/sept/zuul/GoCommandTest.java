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
* GoCommand Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 8, 2021</pre> 
* @version 1.0 
*/ 
public class GoCommandTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: execute(Game game) 
* 
*/ 
@Test
public void testExecute() throws Exception { 
//TODO: Test goes here...
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


} 
