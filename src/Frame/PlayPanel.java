package Frame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Config.Config;

public class PlayPanel extends JPanel implements Config{

	/**
	 * Create the panel.
	 */
	public PlayPanel() {
		this.setBounds(0, 0, length, Height);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		int x = 0,y = 0;
		for(x = 0;x<COLS;x++) {
			for(y = 0;y<ROWS;y++){
				if(PaintRect[x][y] == 1) {
					g.setColor(DefaultColor);
					g.fill3DRect(y*SIZE, x*SIZE, y*SIZE+SIZE, x*SIZE+SIZE, false);
					g.setColor(new Color(255,255,255));
					g.drawLine(y*SIZE, x*SIZE, y*SIZE+SIZE, x*SIZE);
					g.drawLine(y*SIZE, x*SIZE, y*SIZE, x*SIZE+SIZE);
					g.drawLine(y*SIZE+SIZE, x*SIZE, y*SIZE+SIZE, x*SIZE+SIZE);
					g.drawLine(y*SIZE, x*SIZE+SIZE, y*SIZE+SIZE, x*SIZE+SIZE);
				}else {
				    g.setColor(new Color(255,255,255));
				    g.fill3DRect(y*SIZE, x*SIZE, y*SIZE+SIZE, x*SIZE+SIZE, false);
				}
				
				
			}
		}
	}
}
