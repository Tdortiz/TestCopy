import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageListTest {
	MessageList messyList;
	Message mes0;
	Packet goPack;
	
	@Before
	public void setUp() throws Exception {
		messyList = new MessageList();
		mes0 = new Message(0, 0, "testing");
		goPack = new Packet(1, "123");
	}

	@Test
	public void test() {
		assertEquals(null, messyList.toString());
		
		mes0.add(goPack.getPackNum(), goPack.getMessage());
		messyList.add(mes0);
		
		assertEquals("1", messyList.head.data.toString());
	}

}
