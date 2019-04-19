import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pit implements Part{
	private int x;
	private int y;
	private int h;
	private int k;
	private int stones;
	private String label;
	private ArrayList<ChangeListener> cl;
	public Pit(int x, int y, int h, int k, int initialStone, String label) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.k = k;
		this.stones = initialStone;
		cl = new ArrayList<ChangeListener>();
		this.label = label;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double p = new Rectangle2D.Double(x, y, h, k);
		g2.drawString(label, x+h/2, y+k);
		g2.drawString(stones + "", x+h/2, y+k/2);
		g2.draw(p);
	}

	public void addChangeListener(ChangeListener l) {
		cl.add(l);
	}
	
	public int getLabelNum() {
		return Integer.parseInt(label.substring(1));
	}
	public int getStone() {
		return stones;
	}
	
	public void setStone(int s) {
		System.out.println(s);
		stones = s;
	}
	
	@Override
	public void addStone() {
		stones ++;
		for(int i = 0; i<cl.size(); i++) {
			cl.get(i).stateChanged(new ChangeEvent(this));
		}
	}

}
