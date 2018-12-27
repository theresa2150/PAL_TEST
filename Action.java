package PAL_v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public enum Action {
	East, West, South, North, Yes, No, Downstairs, Upstairs, Return, MaoRoom, Talk, Kitchen, R1, R2, L;

	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static String inputNull;
	static String inputDirection;
	static int location;

	public static Action action(Action a) throws IOException {
		switch (a) {
			case East :
				return ActionYN();
			case West :
				Scene1.Scene1_3();
				return Action1_3();
			case South :
				System.out.println("");
				System.out.println("只是一面普通的牆壁，什麼也沒有……");
				System.out.println("");
				return Action1();
			case Yes :
				Scene1.Scene1_2();
				return Action1();
			case No :
				return Action1();
			case Downstairs :
				System.out.println("");
				Map.map(Map.lobby_1);
				return Action1_5();
			case Upstairs :
				System.out.println("");
				Map.map(Map.SecondFloor_1);
				return Action1_3();
			case Return :
				System.out.println("");
				Map.map(Map.roomXiaoYao_1);
				return Action1();
			case MaoRoom :
				System.out.println("");
				Scene1.Scene_M();
				return Action1_4();
			case Talk :
				Scene1.readTxt();
				String[] temp = Scene1.scenestring[3].split("\n");
				System.out.println("");
				System.out.print(temp[2]);
				inputNull = reader.readLine();
				System.out.println(temp[3]);
				System.out.println("");
				return Action1_4();
			case Kitchen :
				System.out.println("");
				Map.map(Map.Kitchen_1);
				Scene1.Scene_k();
				return Action1_5();
			case R1 :
				System.out.println("");
				Map.map(Map.room2_1);
				System.out.println("暫時沒什麼任務可進行...");
				System.out.println("");
				return Action1_5();
			case R2 :
				System.out.println("");
				Map.map(Map.room3_1);
				System.out.println("暫時沒什麼任務可進行...");
				System.out.println("");
				return Action1_5();
			case L :
				Scene1.Scene_L();
				if (Scene1.booleanScene_1_5 == false)
					return Action1_5();
		}
		return null;
	}

	public static Action Action1() throws IOException {
		System.out.print("請問逍遙要往哪個方向走？<E/W/S/N>");
		location = 0; // roomXiaoYao
		Command.command();
		if (inputDirection.toUpperCase().equals("E"))
			return action(East);
		else if (inputDirection.toUpperCase().equals("W"))
			return action(West);
		else if (inputDirection.toUpperCase().equals("S") || inputDirection.toUpperCase().equals("N"))
			return action(South);
		else
			return Action1();
	}

	public static Action ActionYN() throws IOException {
		System.out.print("通往樓下柴房的密道，是否進入？<Y/N>");
		location = 0; // roomXiaoYao
		Command.command();
		if (inputDirection.toUpperCase().equals("Y"))
			return action(Yes);
		else if (inputDirection.toUpperCase().equals("N"))
			return action(No);
		else
			return ActionYN();
	}

	static Action Action1_3() throws IOException {
		System.out.print("請問逍遙要往哪個方向走？<D下樓/R回房間/M到苗人客房>");
		location = 3; // SecondFloor
		Command.command();
		if (inputDirection.toUpperCase().equals("D"))
			return action(Downstairs);
		else if (inputDirection.toUpperCase().equals("R"))
			return action(Return);
		else if (inputDirection.toUpperCase().equals("M"))
			return action(MaoRoom);
		else
			return Action1_3();
	}

	static Action Action1_4() throws IOException {
		System.out.print("請問逍遙要往哪個方向走？<D下樓/R回房間/T繼續交談>");
		location = 3; // SecondFloor
		Command.command();
		if (inputDirection.toUpperCase().equals("D"))
			return action(Downstairs);
		else if (inputDirection.toUpperCase().equals("R"))
			return action(Return);
		else if (inputDirection.toUpperCase().equals("T"))
			return action(Talk);
		else
			return Action1_4();
	}

	static Action Action1_5() throws IOException {

		System.out.print("K到廚房　1到李大娘房　2到柴房　U上樓　L與醉漢說話");
		location = 6; // lobby
		Command.command();
		if (inputDirection.toUpperCase().equals("K"))
			return action(Kitchen);
		else if (inputDirection.toUpperCase().equals("1"))
			return action(R1);
		else if (inputDirection.toUpperCase().equals("2"))
			return action(R2);
		else if (inputDirection.toUpperCase().equals("U"))
			return action(Upstairs);
		else if (inputDirection.toUpperCase().equals("L"))
			return action(L);
		else
			return Action1_5();
	}

	public static void main(String[] args) throws IOException {
		Action1();
		// Map.map(Map.Kitchen);
	}
}