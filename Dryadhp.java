package PAL_v4;

/*
 /*
 * �𧯡G
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

public class Dryadhp implements Runnable {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Thread atDryad = new Thread(new Dryadhp(), "atDryad");
//	static Thread atxiaoyao = new Thread(new xiaoyaohp(), "atxiaoyao");
	static String attack;
	static Integer DryadHP = 40;

	public static void main(String[] args) throws IOException {

		System.out.print("Combat starts <ENTER>");
		String inputNull = reader.readLine();

		atDryad.start();
		xiaoyaohp.timer.schedule(new xiaoyaohp(), 500, 500);
		}
	
	static void stop() {
		atDryad.interrupt();
		atDryad.stop();
		xiaoyaohp.timer.cancel();
	}
	
	public void atDryad() throws IOException, InterruptedException {

		int numG = 0;
		while (true) {
			attack = reader.readLine();
			System.out.println(Thread.currentThread().getName());
			if (attack.toUpperCase().equals("AT")) {
				numG = (int) (Math.random() * 14) + 14;
				DryadHP = DryadHP - (int) (numG * 0.5);
				if (DryadHP - numG * 0.5 > 0) {
					System.out.println("��HP-" + (int) (numG * 0.5) + "�A��HP=" + (DryadHP));
				} else {
					System.out.println("��HP-" + (int) (numG * 0.5) + "�A��HP=" + (DryadHP));
					if (DryadHP == 0) {
						System.out.print("���A�𧯡A���p��HP+40\n-Combat Ends-");
						xiaoyaohp.timer.cancel();
						break;
					} else if (DryadHP - numG * 0.5 < 0) {
						while (true) {
							attack = reader.readLine();
							if (attack.toUpperCase().equals("AT")) {
								System.out.println("��HP-" + DryadHP + "�A��HP=" + 0);
								System.out.println("���A�𧯡A���p��HP+20\n-Combat Ends-");
								DryadHP = 0;
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
		System.out.println("���ɪﭱ���Ӥ@���𧯡A�п�J�������O<AT>�Ӫ���");

		try {
			this.atDryad();
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