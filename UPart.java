import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UPart {

	private DatagramSocket socket;
	private DatagramPacket packet;

	private int port;
	private byte[] buf;

	private int movement = 0;
	private int seq = 0;
	private int light = 0;
	private int temperature = 0;

	public UPart(String[] args) {
		port = 5555;
		init();

		while (true) {

			byte[] received_buf;

			try {
				socket.receive(packet);
			} catch (Exception e) {
				System.out.println("#ERROR: " + e.toString());
			}

			received_buf = packet.getData();
			dataParse(received_buf);

			System.out.println(" seq: " + seq + " move:" + movement + " light:"
					+ light + " temp:" + temperature);

		}
	}

	public void init() {
		buf = new byte[256];

		try {
			socket = new DatagramSocket(port);
		} catch (Exception e) {
			System.out.println("#ERROR: " + e.toString());
		}

		packet = new DatagramPacket(buf, buf.length);

	}

	public void dataParse(byte[] data) {

		movement = (data[61] & 0xFF);
		temperature = (data[62] & 0xFF);
		light = (data[63] & 0xFF);
		seq = (data[53] & 0xFF);
	}

}