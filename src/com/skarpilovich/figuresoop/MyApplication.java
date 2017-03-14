package com.skarpilovich.figuresoop;

import com.skarpilovich.figuresoop.figures.Circle;
import com.skarpilovich.figuresoop.figures.Figure;
import com.skarpilovich.figuresoop.figures.Rectangle;
import com.skarpilovich.figuresoop.figures.Text;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by java-student on 9.3.17.
 */
public class MyApplication extends Application {
    private Canvas canvas;
    private Figure[] figures;
    private Random rnd = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        figures = new Figure[1];
        root.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        onMouseReleased(event);
                    }
                });
        this.canvas = new Canvas(640,480);
        AnchorPane.setTopAnchor(this.canvas, 0.0);
        AnchorPane.setRightAnchor(this.canvas, 0.0);
        AnchorPane.setLeftAnchor(this.canvas, 0.0);
        AnchorPane.setBottomAnchor(this.canvas, 0.0);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root,640,480);
        canvas.setWidth(scene.getWidth());
        canvas.setHeight(scene.getHeight());
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                canvas.setWidth(newValue.doubleValue());
            }
        });

        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                canvas.setHeight(newValue.doubleValue());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onMouseReleased(MouseEvent event) {
        System.out.println("Mouse released at:");
        System.out.println("x: " + event.getX());
        System.out.println("y: " + event.getY());
        Rectangle rectangle = new Rectangle(event.getX(),event.getY(), 50, rnd.nextInt(100));
        Circle circle = new Circle(event.getX(), event.getY(),100, 100);
        Text text = new Text("Hello",event.getX(), event.getY());

                addFigure(circle);
                repaint();
                addFigure(rectangle);
                repaint();
                addFigure(text);
                repaint();



    }

    private void addFigure(Figure figure) {
        if (figures[figures.length-1] == null) {
            figures[figures.length-1] = figure;
            return;
        }
        Figure[] tmp = new Figure[figures.length+1];
        for (int i = 0; i < figures.length; i++) {
            tmp[i] = figures[i];
        }
            tmp[tmp.length-1] = figure;
            figures = tmp;
    }

    private void repaint() {
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (Figure f : figures) {
            f.paint(canvas.getGraphicsContext2D());
        }
    }

}
