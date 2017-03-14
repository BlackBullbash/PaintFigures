package com.skarpilovich.figuresoop.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by SergeyKarpilovich on 3/13/2017.
 */
public class Text extends Figure {

	private String text;

	public Text(String text, double centerX, double centerY) {
		super(centerX, centerY);
		this.text = text;
	}

	@Override
	public void paint(GraphicsContext gc) {
		gc.setStroke(Color.CORAL);
		gc.strokeText(text, centerX, centerY);
	}
}

