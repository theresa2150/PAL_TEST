package PAL_v4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Command {

	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static String inputNull;
	static int poem = 1;

	public static void command() throws IOException {
		Action.inputDirection = Action.reader.readLine();
		switch (Action.inputDirection.toLowerCase()) {
			case "status" :
				main.XiaoYao.satus();
				break;
			case "spell" :
				spell.spell_list();
				break;
			case "poem" :
				System.out.println(file("poem" + poem % 5));
				poem += 1;
				if (poem == 6)
					poem = 1;
				break;
			case "help" :
				System.out.println(file("help"));
				break;
			case "map" :
				System.out.println("");
				Map.printmap(Action.location);
				break;
			case "item" :
				item.itemlist();
				break;
		}
	}

	public static String file(String s) {
		String str = "";
		String allstr = "\n";
		String filePath = Scene1.class.getResource("").getPath().replace("file:", "")
				+ "../../" + s + ".txt"; // 文件和該類在同個目錄下

		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(filePath), "MS950")); // 指定讀取文件的編碼格式，以免出現中文亂碼
			while ((str = reader.readLine()) != null) {
				allstr += str + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allstr;
	}

	public static void main(String[] args) throws IOException {
		command();
	}
}
