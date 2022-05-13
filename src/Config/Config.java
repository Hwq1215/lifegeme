package Config;

import java.awt.Color;

public interface Config {
	public static final int length = 800;       //长
	public static final int Height = 800;       //长
	public static final int sideLength = 300;
	public static final int SIZE = 10;		//方块的尺寸
	public static final int FristMIN = length*Height/SIZE/SIZE/9;
	public static final int FristMAX = length*Height/SIZE/SIZE/7;
	public static final int ROWS = length / SIZE;		//列
	public static final int COLS = Height / SIZE;		//行
	public static int[][] PaintRect = new int[COLS][ROWS];		  //绘图的矩阵
	public static int[][] PaintRectPre = new int[COLS][ROWS];
	public static final Color DefaultColor = new Color(0,0,0);    //黑色
	public int isContinue = 0;
}
