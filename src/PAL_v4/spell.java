package PAL_v4;

import java.util.ArrayList;
import java.util.List;

public class spell {

	static List<String> spell_list = new ArrayList<>();

	public static void spell_list() {
		System.out.println("");
		System.out.println("仙術列表");
		if (spell_list.size() < 1) {
			spell_list.add("氣療術");
		}
		for (int i = 0; i < spell_list.size(); i++) {
			String name = spell_list.get(i);
			System.out.print(name.toUpperCase() + "\t");
			if ((i + 1) % 5 == 0)
				System.out.println("");
		}
		System.out.println("\n");
	}
}
