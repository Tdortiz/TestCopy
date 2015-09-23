import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageListTest {
    MessageList messyList;
    Message mes1;
    Message mes2;
    Message mes3;
    Packet goPack;
    
    @Before
    public void setUp() throws Exception {
        messyList = new MessageList();
        mes1 = new Message(10);
        mes2 = new Message(3);
        mes3 = new Message(17);
        goPack = new Packet(1, "123");
    }

    @Test
    public void testAdd() {
       
        messyList.add(mes1);
        messyList.add(mes2);
        messyList.add(mes3);
        String s = "--- Message 1\n";
        	  s += "testing\n";
        	  s += "--- End Message 1\n\n"; 
        	  
        //System.out.println(s);
        //System.out.println(messyList.toString());
        //System.out.println("---------------------------");
        assertEquals(s, messyList.toString());
        
    }
    
    @Test
    public void testToString(){
    	MessageList list = new MessageList();
    	String s = "--- Message 1\n";
  	  	s += "testing\n";
  	    s += "test2\n";
  	  	s += "--- End Message 1\n\n"; 
  	  	
        PacketList packetList = new PacketList();
        Packet a = new Packet(1,"testing");
        Packet b = new Packet(2, "test2");
        System.out.println(packetList.toString(1));
        
        packetList.add(a);
        packetList.add(b);
        
        list.add(mes1);
        list.head.data.setPacketList(packetList);
        
        assertEquals(s, list.toString());
    }

}