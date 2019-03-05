package com.mycompany.a4;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.plaf.Border;
import com.mycompany.interfaces.IGameWorld;
import com.mycompany.interfaces.IMove;
import com.mycompany.interfaces.Iiterator;
import com.mycompany.a4.GameObject;
import com.mycompany.a4.ObjectLocation;
import com.mycompany.interfaces.IDrawable;

public class MapView extends Container implements Observer {
	private IGameWorld gwPrxy;
	private ObjectCollection GameObj;
	Form formRef;
	
	public MapView(GameWorld GameDrawer, Form f) {
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLACK);
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLUE));
		gwPrxy = GameDrawer;
		formRef = f;
	}
	
	public void update(Observable o, Object data) {
		// TODO Auto-generated method stub
		if(o instanceof IGameWorld) {
			gwPrxy = (IGameWorld)o;
			repaint();
		}		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		GameObj = gwPrxy.getGameObjects();
		Iiterator objectDrawer = GameObj.getIterator();
		
		Object currentObj = new Object();
		
		while(objectDrawer.hasNext()) {
			ObjectLocation pCmpRelPrnt = new ObjectLocation(this.getX(), this.getY());
			currentObj = objectDrawer.getNext();
			if(currentObj instanceof IMove) {		
				int x = (int) ((GameObject)currentObj).getLocation().getX();
				int y = (int) ((GameObject)currentObj).getLocation().getY();
				int rightWall = this.getWidth() + this.getX();
				int leftWall = this.getX();
				int bottomWall = this.getY() + this.getHeight();
				int topWall = this.getY();
			
				if(x<=leftWall || x>=rightWall) {
					if(x<=0) {
						((GameObject)currentObj).setLocation(new ObjectLocation(this.getWidth(), y));	//works
					}
					if(x>=rightWall) {
						((GameObject)currentObj).setLocation(new ObjectLocation(0, y));
					}
				}
				if(y<=topWall || y>=bottomWall) {
					if(y<=0) {
						((GameObject)currentObj).setLocation(new ObjectLocation(x, bottomWall));
					}
					if((y+this.getY())>=bottomWall) {
						((GameObject)currentObj).setLocation(new ObjectLocation(x, 0));
					}
				}
			}
			if(currentObj instanceof IDrawable) {
				((IDrawable)currentObj).draw(g, pCmpRelPrnt);
			}
		}
	}

}
