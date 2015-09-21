import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Jacob
 *
 */
public class PacketListTest {
	
	private Packet pack1;
	
	private Packet pack2;
	
	private Packet pack3;
	
	private Packet pack4;
	
	private Packet pack5;
	
	private Packet pack6;
	
	private String testString;
	
	private PacketList sixPack;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pack1 = new Packet(1, "Good");
		pack2 = new Packet(2, "Morning");
		pack3 = new Packet(4, "Seven");
		pack4 = new Packet(7, "yasss");
		testString = "Good\n";
		testString += "Morning\n";
		testString += "WARNING: packet 3 of message 3 is missing\n";
		testString += "Seven\n";
		testString += "WARNING: packet 5 of message 3 is missing\n";
		testString += "WARNING: packet 6 of message 3 is missing\n";
		testString += "yasss\n";
		
		sixPack = new PacketList();
		
		
	}

	/**
	 * Test method for {@link PacketList#PacketList()}.
	 */
	@Test
	public void testPacketList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link PacketList#PacketList(Packet)}.
	 */
	@Test
	public void testPacketListPacket() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link PacketList#add(Packet)}.
	 */
	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link PacketList#addHelper(Packet)}.
	 */
	@Test
	public void testAddHelper() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link PacketList#addToRest(Packet)}.
	 */
	@Test
	public void testAddToRest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link PacketList#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		sixPack.add(pack1);
		sixPack.add(pack2);
		sixPack.add(pack3);
		sixPack.add(pack4);
		assertEquals(testString, sixPack.toString(3));
	}

}
