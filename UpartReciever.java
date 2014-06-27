import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UpartReciever {

	private static DatagramSocket socket;
	private static DatagramPacket packet;

	private int port;
	private byte[] buf;

	public UpartReciever(int p) {
		this.port = p;

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

	public void startRecieving() {
		while (true) {

			byte[] received_buf;

			try {
				socket.receive(packet);

			} catch (Exception e) {
				System.out.println("#ERROR: " + e.toString());
			}

			received_buf = packet.getData();
			UpartParser parse = new UpartParser(received_buf);
			System.out.println(parse.getId() + parse.getSeq()
					+ parse.getMovement() + parse.getLight()
					+ parse.getTemperature());
		}
	}

	public static void main(String[] args) {

		UpartReciever test = new UpartReciever(5555);
		test.init();
		test.startRecieving();

	}

}
