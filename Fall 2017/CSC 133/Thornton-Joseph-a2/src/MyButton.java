package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
public class MyButton extends Button  {

	public MyButton(String name) {
		super(name);
		setstyle();
	}
	public void setstyle() {
		this.getUnselectedStyle().setBgTransparency(255);
		this.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);	
		this.getAllStyles().setMarginTop(5);
		this.getAllStyles().setMarginBottom(5);
		this.getAllStyles().setMarginLeft(5);
		this.getAllStyles().setMarginRight(5);
		this.getAllStyles().setPaddingBottom(5);
		this.getAllStyles().setPaddingTop(5);
	}

}
