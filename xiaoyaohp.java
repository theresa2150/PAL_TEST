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
			System.out.println("李逍遙HP-" + (int) (numX * 0.5) + ", 李逍遙HP=" + main.XiaoYao.HP);
			System.out.println("月如妹子快來幫我，快支持不住了...QAQ\n");
			System.out.println("李逍遙HP-" + main.XiaoYao.HP + ", 李逍遙HP=" + 0);
			System.out.println("勝敗乃兵家常事，大俠請重新來過。");
			main.XiaoYao.HP = 0;
			Dryadhp.stop();
		} else {
			System.out.println("李逍遙HP-" + (int) (numX * 0.5) + ", 李逍遙HP=" + main.XiaoYao.HP);
			System.out.println(Thread.currentThread().getName());
		}
		if (main.XiaoYao.HP <= 25 && main.XiaoYao.HP > 0) {
			System.out.println("月如妹子快來幫我，快支持不住了...QAQ\n");
		}
	}
}
