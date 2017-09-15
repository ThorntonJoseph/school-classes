package com.myapp.ui;

public class Point {
	private float x;
	private float y;
	public void setpoint(float x,float y) {
		if(x > 0 && x<1024 && y<768 && y>0) {
			this.x=x;
			this.y=y;
		}else {
			this.x=512;
			this.y=357;
		}
	}

}
