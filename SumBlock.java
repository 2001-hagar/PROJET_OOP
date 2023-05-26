package com.example.demo4;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
public class SumBlock {
    public Pane sumBlock(String name, String value) {
        Pane root = new Pane();

        // White square with black border
        Rectangle backgroundSquare = new Rectangle(53,53);
        backgroundSquare.setX(value[0]);
        backgroundSquare.setY(value[1]);
        backgroundSquare.setFill(Color.BLUE);
        backgroundSquare.setStroke(Color.BLUE);

        Rectangle backgroundSquare1 = new Rectangle(53,53);
        backgroundSquare1.setX(100);
        backgroundSquare1.setY(100);
        backgroundSquare1.setFill(Color.BLUE);
        backgroundSquare1.setStroke(Color.BLUE);
        Rectangle square = new Rectangle(50, 50);
        square.setFill(Color.WHITE);
        square.setStroke(Color.BLACK);
        square.setStrokeWidth(2);
        square.setX(100);
        square.setY(100);

        // Plus signs inside square
        Text plus1 = new Text("+");
        plus1.setX(value[0]+10);
        plus1.setY(value[1]+10);

        Text plus2 = new Text("+");
        plus2.setX(value[0]+10);
        plus2.setY(value[1]+20);

        Text plus3 = new Text("+");
        plus3.setX(value[0]+10);
        plus3.setY(value[1]+30);

        // "Add" text underneath
        Text add = new Text(name);
        add.setX(value[0]);
        add.setY(170);

        // Add all nodes to the pane
        root.getChildren().addAll(backgroundSquare,backgroundSquare1,square, plus1, plus2, plus3, add);
        return root;
    }
}
