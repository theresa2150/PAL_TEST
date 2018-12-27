package PAL_v4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public enum Map {
	roomXiaoYao, roomXiaoYao_1, roomXiaoYao_2, SecondFloor, SecondFloor_1, SecondFloor_2, lobby, lobby_1, room1,
	room1_1, room2, room2_1, room3, room3_1, Kitchen, Kitchen_1, Village, Market, all;

	static String[] string;
	static String[][] mapstring;
	static String str;
	static String allstr = "";
	static String filePath = Map.class.getResource("").getPath().replace("file:", "") + "../../map.txt"; // 文件和該類在同個目錄下
	static BufferedReader reader;

	public static void map(Map m) {
		switch (m) {
		case roomXiaoYao:
			printmap(0);
			break;
		case roomXiaoYao_1:
			printmap(1);
			break;
		case roomXiaoYao_2:
			printmap(2);
			break;
		case SecondFloor:
			printmap(3);
			break;
		case SecondFloor_1:
			printmap(4);
			break;
		case SecondFloor_2:
			printmap(5);
			break;
		case lobby:
			printmap(6);
			break;
		case lobby_1:
			printmap(7);
			break;
		case room1:
			printmap(8);
			break;
		case room1_1:
			printmap(9);
			break;
		case room2:
			printmap(10);
			break;
		case room2_1:
			printmap(11);
			break;
		case room3:
			printmap(12);
			break;
		case room3_1:
			printmap(13);
			break;
		case Kitchen:
			printmap(14);
			break;
		case Kitchen_1:
			printmap(15);
			break;
		case Village:
			printmap(16);
			break;
		case Market:
			printmap(17);
			break;
		case all:
			PrintAllMap();
			break;
		}
	}

	public static void readTxt() {
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "MS950")); // 指定讀取文件的編碼格式，以免出現中文亂碼
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
		string = allstr.split("-------------------------------------\n");

		mapstring = new String[string.length / 2][2];
		for (int i = 0; i < string.length - 1; i += 2) {
			mapstring[i / 2][0] = string[i];
			mapstring[i / 2][1] = string[i + 1];
		}
	}

	public static void PrintAllMap() {
		readTxt();
		for (int j = 0; j < mapstring.length; j++)
			System.out
					.println("[" + j + "]" + "[0]=\n" + mapstring[j][0] + "\n[" + j + "]" + "[1]=\n" + mapstring[j][1]);
	}

	public static void PrintMap() {
		readTxt();
		int i = 0;
		for (; i < mapstring.length; i++) {
			System.out.println("[" + i + "]" + "[0]=\n" + mapstring[i][0]);
		}
	}

	public static void printmap(int i) {
		readTxt();
		System.out.println(mapstring[i][1]);
	}

	public static void main(String[] argv) throws IOException {
//		map(all);
//		PrintMap();
		printmap(5);
	}
}
