package com.mycompany.myapp;

import com.codename1.ui.Graphics;

public interface ISelectable {
	public void setSelected(boolean yesNo);
	public boolean isSelected();
	public boolean contains(Location pPtrRelPrnt, Location pCmpRelPrnt);
	public void draw(Graphics g, Location pCmpRelPrnt);
}
