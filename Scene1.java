package PAL_v4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scene1 {
	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static BufferedReader readertemp = new BufferedReader(input);
	static String inputNull;
	static String[] scenestring;
	static String[] temp;
	static String str;
	static String allstr = "";
	static String filePath = Scene1.class.getResource("").getPath().replace("file:", "")
			+ "../../scene.txt"; // 文件和該類在同個目錄下
	static boolean booleanScene1_3;
	static boolean booleanScene_M;
	static boolean booleanScene_k1;
	static boolean booleanScene_k2;
	static boolean booleanScene_l1;
	static boolean booleanScene_l2;
	static boolean booleanScene_1_5;

	public static void readTxt() {
		try {
			readertemp = new BufferedReader(
					new InputStreamReader(new FileInputStream(filePath), "MS950")); // 指定讀取文件的編碼格式，以免出現中文亂碼
			while ((str = readertemp.readLine()) != null) {
				allstr += str + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				readertemp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scenestring = allstr.split("-------------------------------------\n");
	}

	public static void PrintAllScene() {
		readTxt();
		for (int j = 0; j < scenestring.length - 1; j++)
			System.out.println("[" + j + "]\n" + scenestring[j]);
	}

	public static void printscene(int i) {
		readTxt();
		System.out.println(scenestring[i]);
	}

	static void runScene(int j) throws IOException {
		readTxt();
		temp = scenestring[j].split("\n");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
			inputNull = reader.readLine();
		}
		System.out.println("");
	}

	public static void Scene1() throws IOException {
		System.out.println(
				"Scene1 starts, please press <ENTER> each step to continue the story...");
		inputNull = reader.readLine();
		Map.map(Map.roomXiaoYao_2);
		runScene(0);
		Map.map(Map.roomXiaoYao_1);
		item.itemlist.add("木劍");
		item.itemlist.add("頭巾");
		item.itemlist.add("糯米");
	}

	public static void Scene1_2() throws IOException {
		System.out.println("");
		runScene(1);
	}

	public static void Scene1_3() throws IOException {
		if (booleanScene1_3 == false) {
			System.out.println("");
			System.out.println("走出房間，在走道上遇見李大娘<ENTER>");
			inputNull = reader.readLine();
			Map.map(Map.SecondFloor_2);
			runScene(2);
		}
		if (booleanScene1_3 == true) {
			System.out.println("");
			Map.map(Map.SecondFloor_1);
		}
		booleanScene1_3 = true;
	}

	public static void Scene_M() throws IOException {

		if (booleanScene_k2 == true) {
			runScene(6);
			item.itemlist.add("桂花酒");
			booleanScene_1_5 = true;
		} else if (booleanScene_M == false) {
			Map.map(Map.room1_1);
			runScene(3);
			main.money += 500;
			Map.map(Map.room1_1);
		} else if (booleanScene_M == true) {
			Scene1.readTxt();
			temp = scenestring[3].split("\n");
			System.out.print(temp[2]);
			inputNull = reader.readLine();
			System.out.println(temp[3]);
			System.out.println("");
		}
		booleanScene_M = true;
	}

	public static void Scene_k() throws IOException {

		if (booleanScene_k2 == true) {
			System.out.println("李大娘︰酒端給樓上客人了嗎？這裡暫時沒有什麼可以幫忙的了");
			System.out.println("");
		} else if (booleanScene_k2 == false) {
			if (booleanScene_l2 == false) {
				runScene(4);
				Map.map(Map.lobby_1);
			} else if (booleanScene_l2 == true) {
				runScene(5);
				Map.map(Map.Kitchen_1);
				booleanScene_k2 = true;
			}
		}
		booleanScene_k1 = true;
	}

	public static void Scene_L() throws IOException {
		if (booleanScene_k1 == true)
			booleanScene_l2 = true;

		if (booleanScene_l1 == false && booleanScene_1_5 == false) {
			System.out.println("");
			runScene(7);
			Map.map(Map.lobby_1);
			booleanScene_l1 = true;
		} else if (booleanScene_l1 == true && booleanScene_1_5 == false) {
			System.out.println("");
			runScene(8);
			Map.map(Map.lobby_1);
		} else if (booleanScene_1_5 == true) {
			System.out.println("");
			runScene(9);
			item.itemlist.remove("桂花酒");
			System.out.println("-Scene 1 ends-");
		}
	}

	public static void main(String[] argv) throws IOException {
		// PrintAllScene();
		// printscene(1);
		// runScene(2);
		Scene1();
	}
}