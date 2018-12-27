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
			+ "../../scene.txt"; // ���M�����b�P�ӥؿ��U
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
					new InputStreamReader(new FileInputStream(filePath), "MS950")); // ���wŪ����󪺽s�X�榡�A�H�K�X�{����ýX
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
		item.itemlist.add("��C");
		item.itemlist.add("�Y�y");
		item.itemlist.add("�z��");
	}

	public static void Scene1_2() throws IOException {
		System.out.println("");
		runScene(1);
	}

	public static void Scene1_3() throws IOException {
		if (booleanScene1_3 == false) {
			System.out.println("");
			System.out.println("���X�ж��A�b���D�W�J�����j�Q<ENTER>");
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
			item.itemlist.add("�۪�s");
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
			System.out.println("���j�Q�J�s�ݵ��ӤW�ȤH�F�ܡH�o�̼ȮɨS������i�H�������F");
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
			item.itemlist.remove("�۪�s");
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