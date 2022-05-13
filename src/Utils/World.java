package Utils;

import java.util.Random;

import Config.Config;

public class World implements Config {
	private static Random random = new Random();

	public static void newWorld(){
		clearWorld();
		int lifeNumber = random.nextInt(FristMAX) + FristMIN;
		int i, j;
		for(int count = 0; count < lifeNumber; count++) {
			i = random.nextInt(COLS - 2) + 1;
			j = random.nextInt(ROWS - 2) + 1;
			PaintRect[i][j] = 1;
		}
	}
	private static int getNeighborNumber(int i, int j) {
		return PaintRect[i-1][j-1] + PaintRect[i-1][j] + PaintRect[i-1][j+1] + PaintRect[i][j-1] + PaintRect[i][j+1] + PaintRect[i+1][j-1] + PaintRect[i+1][j] + PaintRect[i+1][j+1];
	}
	
	public static void nextWorld() {
		int neighborNumber, wide = COLS - 1, high = ROWS - 1;
		for(int i = 1; i < wide; i++) {
			for(int j = 1; j < high; j++) {
				neighborNumber = getNeighborNumber(i, j);
				if(neighborNumber == 3){
					PaintRectPre[i][j] = 1;
				}else if(neighborNumber == 2) {
					PaintRectPre[i][j] = PaintRect[i][j];
				}else {
					PaintRectPre[i][j] = 0;
				} 
			}
		}
		swapPaintRect();
	}
	
	public static void newWorld(int flag) {
		clearWorld();
		if(flag == 1){
			int size = ROWS - 1, i = COLS / 2, j =1;
			for(; j < size; j++) {
				PaintRect[i][j] = 1;
			}
		}else if(flag == 2){
			int size = COLS - 1, i = 1, j = ROWS / 2;
			for(; i < size; i++) {
				PaintRect[i][j] = 1;
			}
		}else{
			newWorld();
		}
	}
	public static void swapPaintRect() {
		int wide = COLS - 1, high = ROWS - 1;
		for(int i = 1; i < wide; i++) {
			for(int j = 1;j < high; j++) {
				PaintRect[i][j] = PaintRectPre[i][j];
			}
		}
	}
	public static void clearWorld(){
		int wide = COLS - 1, high = ROWS - 1;
		for(int i = 1; i < wide; i++) {
			for(int j = 1;j < high; j++) {
				PaintRect[i][j] = 0;
			}
		}
	}
}