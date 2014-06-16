import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Count2 {

	public static void main(String[] args) {

		try {

			File file = new File("c:\\users\\yusuke\\workspace\\mailcounts.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			ArrayList<String[]> data = new ArrayList<String[]>();
			ArrayList<String> list = new ArrayList<String>();
			int k = 0;
			int counter = 0;

			int all = 0;

			while ((line = reader.readLine()) != null) {

				String[] cols = line.split(",");
				data.add(cols);
				counter++;
			}
			MailCount[] r = new MailCount[counter];
			for (String[] row : data) {

				r[k] = new MailCount(row[0], row[1], row[2]);

				k++;
			}

			for (int i = 0; i < k; i++) {
				if (!list.contains(r[i].getName())) {
					list.add(r[i].getName());
				}
			}
			int kazu[] = new int[list.size()];
			for (int i = 0; i < k; i++) {
				all += r[i].getCount();
				for (int j = 0; j < list.size(); j++) {
					if (r[i].getName().equals(list.get(j))) {
						kazu[j] += r[i].getCount();
					}
				}

			}

			int lowest = kazu[0];
			for (int i = 0; i < kazu.length; i++) {
				if (kazu[i] < lowest) {

					lowest = kazu[i];
				}
			}

			System.out.println("全期間を通して" + all + "通");
			for (int i = 0; i < list.size(); i++) {

				System.out.println(list.get(i) + ":" + kazu[i] + "通");

			}
			for (int i = 0; i < kazu.length; i++) {
				if (lowest == kazu[i]) {

					System.out.println("全期間を通して、一番メールが少なかった人は：" + list.get(i));
				}

			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
