package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
//Contents of File  SimpleForm.java:
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.commands.addAsteroidCollided;
import com.mycompany.commands.addAsteroidWhackedSaucer;
import com.mycompany.commands.addAsteroids;
import com.mycompany.commands.addEliminate;
import com.mycompany.commands.addFlyingSaucers;
import com.mycompany.commands.addMissileKillAsteroids;
import com.mycompany.commands.addReloadMissiles;
import com.mycompany.commands.addShipCrashedAsteroid;
import com.mycompany.commands.addShipHitFlyingSaucer;
import com.mycompany.commands.addShips;
import com.mycompany.commands.addSpaceStation;
/** This class creates a simple "Form"  by extending an existing
*  class "Form", defined in the CN1 ui package.
*/
public class ButtonPanel extends Button{
	
	public ButtonPanel() {
		
	}
	
	public ButtonPanel(String text) {
		super(text);
	}
	
	public ButtonPanel(Command cmd) {
		super(cmd);
		this.getAllStyles().setBgColor(ColorUtil.CYAN);
		this.getAllStyles().setFgColor(ColorUtil.BLUE);
	}
	
	public ButtonPanel(Image icon) {
		super(icon);
	}
	
	public ButtonPanel(String text, Image icon) {
		super(text, icon);
	}
		
}
