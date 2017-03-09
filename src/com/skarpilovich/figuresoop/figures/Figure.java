package com.skarpilovich.figuresoop.figures;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by java-student on 9.3.17.
 */
public abstract class Figure {
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;
    public static final int FIGURE_TYPE_RUND = 3;

    protected double centerX;
    protected double centerY;

    public Figure(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public abstract void paint(GraphicsContext gc);
}
