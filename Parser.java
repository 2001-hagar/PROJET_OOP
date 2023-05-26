package com.example.demo4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


import javafx.scene.paint.Color;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;

public class Parser extends Application {

        private TextArea textArea;

        public void start(@org.jetbrains.annotations.NotNull Stage primaryStage) throws IOException {
            textArea = new TextArea();
            ScrollPane scrollPane = new ScrollPane(textArea);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);

            Label headerLabel = new Label("Parser");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            headerLabel.setTextFill(Color.DARKBLUE);
            Pane root= new Pane();

            BorderPane borderPane = new BorderPane();
            borderPane.setTop(headerLabel);
            borderPane.setCenter(scrollPane);

            Scene scene = new Scene(borderPane, 800, 600);
            Scene scene1 = new Scene( root, 2000, 2000);

            primaryStage.setScene(scene);
            primaryStage.setTitle("XML Parser Example");

            // Add event handlers
            scene.setOnKeyPressed(this::handleKeyPress);
            scrollPane.setOnScroll(this::handleScroll);

            // Load the XML file and display its contents in the text area
            try {
                File xmlFile = new File("/home/hagar/IdeaProjects/test/src/main/java/com/example/test/SimulinkMdlReader.xml");

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);

                doc.getDocumentElement().normalize();

                // Get the root element
                Element rootElement = doc.getDocumentElement();

                // Get all the child nodes of the root element
                NodeList nodeList = rootElement.getChildNodes();

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        textArea.appendText("Element: " + element.getNodeName() + "\n");
                        String name = element.getAttribute("Name");
                        textArea.appendText("Name: " + name + "\n");
                         String value = element.getTextContent();
                        textArea.appendText("Value: " + value+ "\n\n");


                        if (element.getNodeName() == "Block"&& name=="Add") {
                             root = new SumBlock().sumBlock(name,value);

                        }
                        if (element.getNodeName() == "Block"&& name=="Constant") {
                            root =new ConstantBlock().ConstantBlock(name,value);

                        }
                        if (element.getNodeName() == "Block"&& name=="Saturation") {
                            root =new SaturationBlock().SaturationBlock(name,value);

                        }
                        if (element.getNodeName() == "Block"&& name=="Scope") {
                            root =new ScopeBlock().ScopeBlock(name,value);

                        }
                        if (element.getNodeName() == "Block"&& name=="Unit Delay") {
                            root =new Unit DelayBlock().Unit DelayBlock(name,value);

                        }
                        if (element.getNodeName() == "line") {
                            new DRAW_LINE();

                        }


                    }
                }

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    primaryStage.close();
                }
            }

            primaryStage.show();
        }

        private void handleKeyPress(KeyEvent event) {
            if (new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN).match(event)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Save changes?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.YES) {
                    // TODO: Implement saving functionality
                }
            }
        }

        private void handleScroll(ScrollEvent event) {
            // TODO: Implement scroll functionality
        }

        public static void main(String[] args) {
            launch(args);
        }

    }