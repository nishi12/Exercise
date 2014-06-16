public class MailCount {

	private String name;
	private int count;
	private String time;

	MailCount(String x, String y, String z) {

		setName(x);
		setCount(y);
		setTime(z);

	}

	public String getName() {

		return name;
	}

	public int getCount() {

		return count;
	}

	public String getTime() {

		return time;
	}

	public void setName(String x) {
		this.name = x;
	}

	public void setCount(String y) {

		this.count = Integer.parseInt(y);

	}

	public void setTime(String z) {
		this.time = z;
	}

}
