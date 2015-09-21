import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageListTest {
    MessageList messyList;
    Message mes1;
    Message mes2;
    Packet goPack;
    
    @Before
    public void setUp() throws Exception {
        messyList = new MessageList();
        mes1 = new Message(1, 1, "testing");
        mes2 = new Message(2, 1, "test2");
        goPack = new Packet(1, "123");
    }

    @Test
    public void testAdd() {
        //assertEquals(null, messyList.toString());
        
        messyList.add(mes1);
        String s = "--- Message 3\n";
        	  s += "testing"; 
        System.out.println(messyList.toString());
        assertEquals(s, messyList.toString());
    }
    
    @Test
    public void testToString(){
        assertEquals(null, messyList.toString());
        
        messyList.add(mes1);
        messyList.add(mes2);
        
        //a set of sanity-check printlns to ensure nodes are added correctly.
        System.out.println(messyList.head.data.toString());
        System.out.println(messyList.head.next.toString());
        
        assertEquals("", messyList.toString());
    }

}