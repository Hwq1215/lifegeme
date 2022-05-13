package Utils;
import Config.Config;
import Frame.PlayPanel;

public class UpdateThread extends Thread{
	PlayPanel panel;
	public int isContinue = 0;
	
	public UpdateThread(PlayPanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
	}
	
	@Override
	public void run() {
		while (true) {
			while(isContinue == 0) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			panel.repaint();
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			World.nextWorld();
		}
	}
	
	public void setIsContinue(int isContinue) {
		this.isContinue = isContinue;
	}
}
