package PAL_v4;

import java.util.ArrayList;
import java.util.List;

public class item {

	static List<String> itemlist = new ArrayList<>();
	static int[] count_item = new int[0];
	static int count = 1;

	public static void itemlist() {
		System.out.println("");
		System.out.println("�����G" + main.money);
		System.out.println("���~�M��G");
		itemlist.add("���~1");
		itemlist.add("���~5");
		itemlist.add("���~1");
		itemlist.add("���~2");
		itemlist.add("���~2");
		itemlist.add("���~3");
		itemlist.add("���~1");
		itemlist.add("���~1");
		itemlist.add("���~2");
		itemlist.add("���~4");
		itemlist.add("���~5");
//		if (itemlist.size() < 1)
//			System.out.print("�L");
//		else
//			for (int i = 0; i < itemlist.size(); i++) {
//				String name = itemlist.get(i);
//				System.out.print(name.toUpperCase() + "\t");
//				if ((i + 1) % 5 == 0)
//					System.out.println("");
//			}
//		System.out.println("\n");
		int i = 0;
		int j = 0;
		count_item = new int[itemlist.size()];
		for (int k = 0; k < count_item.length; k++) {
			while (j < itemlist.size()) {
				while (i < j) {
					if (itemlist.get(i) == itemlist.get(j)) {
						count += 1;
						i++;
					}
					j++;
				}
				k++;
				System.out.println(itemlist.get(j) + ", " + count);
			}
			i = 0;
			count = 1;

		}
	}
}
