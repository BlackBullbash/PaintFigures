package com.skarpilovich.figuresoop.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * Created by SergeyKarpilovich on 3/13/2017.
 */
public class Circle extends Figure {

	private double w;
	private double h;

	public Circle(double centerX, double centerY, double w, double h) {
		super(centerX, centerY);
		this.w = w;
		this.h = h;
	}

	@Override
	public void paint(GraphicsContext gc) {
		gc.setStroke(Color.BLUE);
		gc.strokeOval(centerX - w/2, centerY - h/2, w, h);
	}
}
