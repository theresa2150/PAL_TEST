package PAL_v4;

import java.util.Timer;
//import java.util.Date;
import java.util.TimerTask;

public class xiaoyaohp extends TimerTask implements Runnable {
	static Timer timer = new Timer();

	@Override
	public void run() {
		int numX = (int) (Math.random() * 14) + 14;
		main.XiaoYao.HP = main.XiaoYao.HP - (int) (numX * 0.5);

		if (main.XiaoYao.HP - (int) (numX * 0.5) <= 0) {
			System.out.println("���p��HP-" + (int) (numX * 0.5) + ", ���p��HP=" + main.XiaoYao.HP);
			System.out.println("��p�f�l�֨����ڡA�֤������F...QAQ\n");
			System.out.println("���p��HP-" + main.XiaoYao.HP + ", ���p��HP=" + 0);
			System.out.println("�ӱѤD�L�a�`�ơA�j�L�Э��s�ӹL�C");
			main.XiaoYao.HP = 0;
			Dryadhp.stop();
		} else {
			System.out.println("���p��HP-" + (int) (numX * 0.5) + ", ���p��HP=" + main.XiaoYao.HP);
			System.out.println(Thread.currentThread().getName());
		}
		if (main.XiaoYao.HP <= 25 && main.XiaoYao.HP > 0) {
			System.out.println("��p�f�l�֨����ڡA�֤������F...QAQ\n");
		}
	}
}
