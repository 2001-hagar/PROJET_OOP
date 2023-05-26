package com.example.demo4;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
    public class ConstantBlock {
        public Pane constantBlock(String name, String value) {
            Pane root = new Pane();
            double positionX = 200;
            double positionY = 100;

            // White square with black border
            Rectangle backgroundSquare = new Rectangle(53,53);
            backgroundSquare.setX(positionX - 3);
            backgroundSquare.setY(positionY - 3);
            backgroundSquare.setFill(Color.BLUE);
            backgroundSquare.setStroke(Color.BLUE);

            Rectangle backgroundSquare1 = new Rectangle(53,53);
            backgroundSquare1.setX(positionX + 1);
            backgroundSquare1.setY(positionY + 1);
            backgroundSquare1.setFill(Color.BLUE);
            backgroundSquare1.setStroke(Color.BLUE);
            Rectangle square = new Rectangle(50, 50);
            square.setFill(Color.WHITE);
            square.setStroke(Color.BLACK);
            square.setStrokeWidth(2);
            square.setX(positionX);
            square.setY(positionY);

            // Plus signs inside square
            Text plus1 = new Text("__");
            plus1.setX(positionX + 29);
            plus1.setY(positionY + 15);

            Text plus2 = new Text("/");
            plus2.setX(positionX + 25);
            plus2.setY(positionY + 25);

            Text plus3 = new Text("__");
            plus3.setX(positionX + 16);
            plus3.setY(positionY + 25);

//         "Add" text underneath
            Text text = new Text("Constant");
            text.setX(positionX + 5);
            text.setY(positionY + 70);

            // Add all nodes to the pane
            root.getChildren().addAll(backgroundSquare,backgroundSquare1,square, plus1, plus2, plus3, text);
            return root;
        }
    }

