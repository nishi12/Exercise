import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Count {

	public static void main(String[] args) {

		try {

			File file = new File("c:\\users\\yusuke\\workspace\\mailcounts.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			ArrayList<String[]> data = new ArrayList<String[]>();
			ArrayList<String> name = new ArrayList<String>();
			ArrayList<String> list = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {

				String[] cols = line.split(",");
				data.add(cols);
			}
			for (String[] row : data) {
				name.add(row[0]);
			}
			for (int i = 0; i < name.size(); i++) {
				if (!list.contains(name.get(i))) {
					list.add(name.get(i));
				}
			}
			int kazu[] = new int[list.size()];

			for (int i = 0; i < list.size(); i++) {

				kazu[i] = 0;

			}

			for (String[] row : data) {
				for (int i = 0; i < list.size(); i++)
					if (row[0].equals(list.get(i))) {

						kazu[i] += Integer.parseInt(row[1]);

					}
			}
			int lowest = kazu[0];
			for (int i = 0; i < kazu.length; i++) {
				if (kazu[i] < lowest) {

					lowest = kazu[i];
				}
			}
			int all = 0;
			System.out.println(list);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i) + ":" + kazu[i] + "通");
				all += kazu[i];
			}
			System.out.println("全期間を通して" + all + "通");

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
