package com.myapp.A1prj;
import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
public class MapView extends Container implements Observer {
	// implements singleton design pattern.
	private GameWorld gw;
	public MapView(GameWorld gw) {
		this.gw=gw;
		//setting the back ground color of center container to light gray
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		//setting the border Color
		this.getAllStyles().setBorder(Border.createLineBorder(4,
		ColorUtil.GRAY));
	}
	public void update(Observable observable, Object data) {
		if(observable==gw) {
			gw.map();
		}else
			System.out.println("something is wrong");
		
	}

}
