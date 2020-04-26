package PAL_v4;

import java.io.IOException;

public class main {

	String name;
	int Level, maxHP, maxMP, maxEXP = 100, HP, MP, EXP = 0;
	static int money = 0;
	static int x = 0, y = 0;
	static String now;

	static main XiaoYao = new main("李逍遙", 1, 200, 50);
	static main LingEr = new main("趙靈兒", 5, 160, 80);
	static main YueRu = new main("林月如", 8, 180, 60);

	public main() {
	};

	public main(int maxHP, int maxMP) {
		this.maxHP += HP;
		this.maxMP += MP;
		this.Level += 1;
	};

	public main(String name, int Level, int maxHP, int maxMP) {
		this.name = name;
		this.Level = Level;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.HP = this.maxHP;
		this.MP = this.maxMP;
	};

	void LevelUp() {
		if (this.HP >= this.maxHP) {
			this.HP = this.maxHP;
		}
		if (this.MP >= this.maxMP) {
			this.MP = this.maxMP;
		}
		if (this.EXP >= this.maxEXP) {
			this.Level += 1;
			this.maxHP = (int) (this.maxHP * 1.1);
			this.maxMP = (int) (this.maxMP * 1.1);
			this.HP = this.maxHP;
			this.MP = this.maxMP;
			this.maxEXP = 1500 * this.Level * (1 + this.Level / 10);
			this.EXP = 0;
			System.out.println(name + "\tLevel=" + this.Level + "\tHP=" + this.maxHP
					+ "\tMP=" + this.maxMP + "\tLevelUp");
		}
		// else
		// System.out.println(name + "\tHP=" + this.HP + "\tMP=" + this.MP);
	};

	void LevelJump(int Level) {
		this.Level += Level;
		for (int i = 0; i < Level; i++) {
			this.maxHP = (int) (this.maxHP * 1.1);
			this.maxMP = (int) (this.maxMP * 1.1);
		}
		this.HP = this.maxHP;
		this.MP = this.maxMP;
		this.EXP = 0;
		System.out.println(this.name + "\tLevel=" + this.Level + "\tHP=" + this.maxHP
				+ "\tMP=" + this.maxMP + "\tLevelUp");
	};

	void satus() {
		System.out.println("");
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		System.out.println(this.name + "\tLevel=" + this.Level + "\tHP=" + this.HP
				+ "\tMP=" + this.MP);
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		System.out.println("");
	};

	void varmaxHP(int maxHP) {
		this.maxHP += maxHP;
	};

	void varmaxMP(int maxMP) {
		this.maxMP += maxMP;
	};

	void varHP(int HP) {
		this.HP -= HP;
	};

	void varMP(int MP) {
		this.MP -= MP;
	};

	public int getHP() {
		return HP;
	}

	public int getMP() {
		return MP;
	}

	void leveljump1() {
	}

	public static void main(String[] args) throws IOException {
		Scene1.Scene1();
		Action.Action1();
		// XiaoYao.satus();
		// XiaoYao.LevelUp();
		// XiaoYao.LevelJump(3);
		// XiaoYao.varHP(6);
		// XiaoYao.satus();
	}
}
