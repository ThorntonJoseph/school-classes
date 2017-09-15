package com.myapp.ui;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
public class SpaceShip extends rescuers{
	public SpaceShip() {
		//set color
		super.setcolor(ColorUtil.GREEN);
		// create object at random location
		Random rn = new Random();
		int x=1024;
		int y=768;
		super.setsize(100);
		super.setlocation(rn.nextInt(x), rn.nextInt(y));
	}
	public void setsize(int size) {
		if(size>1024) {
			super.setsize(1024);
		}
		else if(size<50) {
			super.setsize(50);
		}
		else {
			super.setsize(size);
		}
	}
}
