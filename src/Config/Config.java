package Config;

import java.awt.Color;

public interface Config {
	public static final int length = 800;       //��
	public static final int Height = 800;       //��
	public static final int sideLength = 300;
	public static final int SIZE = 10;		//����ĳߴ�
	public static final int FristMIN = length*Height/SIZE/SIZE/9;
	public static final int FristMAX = length*Height/SIZE/SIZE/7;
	public static final int ROWS = length / SIZE;		//��
	public static final int COLS = Height / SIZE;		//��
	public static int[][] PaintRect = new int[COLS][ROWS];		  //��ͼ�ľ���
	public static int[][] PaintRectPre = new int[COLS][ROWS];
	public static final Color DefaultColor = new Color(0,0,0);    //��ɫ
	public int isContinue = 0;
}
