package PAL_v4;

/*
 * ���p���G
 * HP 40  EXP 1  GOLD 0
 * �ܩʡG�r0%  ��50%  �p50%  ��90%  ��0%  �g90%
 * ���ޡG--
 * ���ѡG--
 * �ԧQ�~�G--
 * �F���ȡG1
 * �a�}�G1D28
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GreenGenieDM implements Runnable {
	static InputStreamReader input = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(input);
	static String attack;

	static Thread atGreenGenie = new Thread(new GreenGenieDM(), "GreenGenieDM");

	static Integer GreenGenieHP = 40;
	static Timer timer = new Timer();

	public static void main(String[] args) throws IOException {

		System.out.print("Combat starts <ENTER>");
		String inputNull = reader.readLine();
		atGreenGenie.start();
		xiaoyaohp.timer.schedule(new xiaoyaohp(), 0, 400);
	}

	static void stop() {
		atGreenGenie.interrupt();
		atGreenGenie.stop();
		xiaoyaohp.timer.cancel();
	}

	public void atGreenGenie() throws IOException, InterruptedException {

		int numG = 0;
		while (true) {
			attack = reader.readLine();
			System.out.println(Thread.currentThread().getName());
			if (attack.toUpperCase().equals("AT")) {
				numG = (int) (Math.random() * 14) + 14;
				GreenGenieHP = GreenGenieHP - (int) (numG * 0.5);
				if (GreenGenieHP - numG * 0.5 > 0) {
					System.out.println(
							"���p��HP-" + (int) (numG * 0.5) + "�A���p��HP=" + (GreenGenieHP));
				} else {
					System.out.println("���p��HP-" + (int) (numG * 0.5) + "�A���p��HP=" + (GreenGenieHP));
					if (GreenGenieHP == 0) {
						System.out.print("���A���p���A���p��HP+40\n-Combat Ends-");
						xiaoyaohp.timer.cancel();
						break;
					} else if (GreenGenieHP - numG * 0.5 < 0) {
						while (true) {
							attack = reader.readLine();
							if (attack.toUpperCase().equals("AT")) {
								System.out.println("���p��HP-" + GreenGenieHP + "�A���p��HP=" + 0);
								System.out.println("���A���p���A���p��HP+20\n-Combat Ends-");
								GreenGenieHP = 0;
								xiaoyaohp.timer.cancel();
								main.XiaoYao.HP += 40;
								main.XiaoYao.EXP += 40;
								main.XiaoYao.LevelUp();
								break;
							} else {
								System.out.print("�п�J�������O<AT>�Ӫ���");
								continue;
							}
						}
						break;
					}
				}
			} else {
				System.out.print("�п�J�������O<AT>�Ӫ���");
				continue;
			}
		}
	}

	@Override
	public void run() {
		System.out.println("���ɪﭱ���Ӥ@�����p���A�п�J�������O<AT>�Ӫ���");

		try {
			this.atGreenGenie();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	class atDryadError extends Exception {
//
//		private static final long serialVersionUID = 1L;
//
//		public atDryadError(String msg) {
//			super(msg);
//		}
//	}
}