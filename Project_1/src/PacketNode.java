public class PacketNode {

		public String data;
		public PacketNode next;

		public PacketNode(String data) {
			this(data, null);
		}

		public PacketNode(String data, PacketNode next) {
			this.data = data;
			this.next = next;
		}
	}