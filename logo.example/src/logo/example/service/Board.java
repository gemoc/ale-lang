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
package logo.example.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Board extends JPanel{
	
	EObject turtle;
	
	Board(EObject t){
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
		
		EStructuralFeature getDrawings = turtle.eClass().getEStructuralFeature("drawings");
		EList<EObject> segments = (EList<EObject>)turtle.eGet(getDrawings);
		for(EObject seg : segments){
			
			EStructuralFeature getBegin = seg.eClass().getEStructuralFeature("begin");
			EObject begin = (EObject) seg.eGet(getBegin);
			EStructuralFeature getBeginX = begin.eClass().getEStructuralFeature("x");
			EStructuralFeature getBeginY = begin.eClass().getEStructuralFeature("y");
			double beginX = (double) begin.eGet(getBeginX);
			double beginY = (double) begin.eGet(getBeginY);
			
			EStructuralFeature getEnd = seg.eClass().getEStructuralFeature("end");
			EObject end = (EObject) seg.eGet(getEnd);
			EStructuralFeature getEndX = end.eClass().getEStructuralFeature("x");
			EStructuralFeature getEndY = end.eClass().getEStructuralFeature("y");
			double endX = (double) end.eGet(getEndX);
			double endY = (double) end.eGet(getEndY);
			
			double size = size(beginX,endX,beginY,endY);
//			System.out.println(size);
			g2.setColor(new Color((int)100, (int)(255*shade(size,150)), (int)0));
			
			
			g2.drawLine(	
					(int) beginX + centerX,
					(int) -beginY + centerY,
					(int) endX + centerX,
					(int) -endY + centerY
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
