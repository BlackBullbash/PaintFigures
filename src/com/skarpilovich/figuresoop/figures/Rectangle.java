package com.skarpilovich.figuresoop.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by java-student on 9.3.17.
 */
public class Rectangle extends Figure {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double centerX, double centerY, double width, double height) {
        super(centerX, centerY);
        this.width = width;
        this.height = height;
       // this.x = centerX - width/2;
        // this.y = centerY - height/2;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(Color.RED);
        gc.strokeRect(centerX - width/2,centerY-height/2,width,height);
    }


}
