/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;

import javax.swing.JPanel;

import vmlogo.Segment;
import vmlogo.Turtle;

public class Board extends JPanel{
	
	Turtle turtle;
	
	Board(Turtle t){
		turtle = t;
	}
	
	public void paint(Graphics g){
		
		int centerX = this.getHeight() / 2;
		int centerY = this.getWidth() / 2 + 100;
		g.drawLine(-10+centerX,-10+centerY,10+centerX,10+centerY);
		g.drawLine(-10+centerX,10+centerY,10+centerX,-10+centerY);
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
		g2.setStroke(new BasicStroke(3));
		
		
		for(Segment seg : turtle.getDrawings()){
			
			double size = size(seg.getBegin().getX(),seg.getEnd().getX(),seg.getBegin().getY(),seg.getEnd().getY());
//			System.out.println(size);
			g2.setColor(new Color((int)100, (int)(255*shade(size,150)), (int)0));
			
			
			g2.drawLine(	
					(int) seg.getBegin().getX() + centerX,
					(int) -seg.getBegin().getY() + centerY,
					(int) seg.getEnd().getX() + centerX,
					(int) -seg.getEnd().getY() + centerY
			);
		}		
	}
	
	private double size(double aX, double aY, double bX, double bY) {
		return Math.sqrt((aX - aY)*(aX - aY) + (bX - bY)*(bX - bY));
	}
	
	private double shade(double size, double range) {
		double factor = 0.3;
		double a = (size/150.0);
		return 1-Math.pow(a, 2.0*factor);
		
//		return 1 - (a * a * (3 - 2 * a));
	}
	
}
