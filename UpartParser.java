public class UpartParser {

	private byte[] data;
	private int[] id = new int[3];
	private int movement = 0;
	private int seq = 0;
	private int light = 0;
	private int temperature = 0;

	public UpartParser(byte[] x) {
		this.data = x;
		dataParse(data);
	}

	public void dataParse(byte[] data) {

		id[0] = (data[50] & 0xFF);
		id[1] = (data[51] & 0xFF);
		id[2] = (data[52] & 0xFF);
		movement = (data[61] & 0xFF);
		temperature = (data[62] & 0xFF);
		light = (data[63] & 0xFF);
		seq = (data[53] & 0xFF);
	}

	public String getId() {

		String upartId = id[0] + "." + id[1] + "." + id[2];

		return upartId;
	}

	public int getMovement() {

		return movement;
	}

	public int getSeq() {

		return seq;
	}

	public int getLight() {

		return light;
	}

	public int getTemperature() {

		return temperature;
	}

}
