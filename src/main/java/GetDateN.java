import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class GetDateN {
    private Stage stage;
    private BorderPane borderPane = new BorderPane();

    public Stage getN(){
        this.stage = new Stage();
        stage.setTitle("Metoda Elementów Skończonych - Natalia Luberda");
        stage.alwaysOnTopProperty();
        stage.setScene(new Scene(borderPane, 880, 460));
        stage.show();
        Label tittle = new Label("Wibracje akustyczne warstwy materiału");
        tittle.setStyle("-fx-font-family: 'Bauhaus 93'; -fx-font-size: 22pt; -fx-text-fill: #ffffff; -fx-background-color: rgba(0,0,0,0.84);");
        borderPane.setTop(tittle);
        BorderPane.setAlignment(tittle, Pos.CENTER);
        BorderPane.setMargin(tittle, new Insets(20, 0, 20, 0));
        return initGetDate();
    }

    private Stage initGetDate() {
        final int[] configName = {-1};
        TextField elementsQuantity = new TextField();
        Label nQuantity = new Label("Podaj ilość elementów: ");

        Button getParametr = new Button("CONFIRM");
        getParametr.setStyle("-fx-font-family: 'Bauhaus 93'; -fx-font-size: 15 pt; -fx-text-fill: #30cbc8; -fx-background-color: rgba(8,56,65,0.84);");


        HBox inputList = new HBox(10);
        inputList.getChildren().addAll(nQuantity, elementsQuantity);
        inputList.setAlignment(Pos.TOP_CENTER);

        VBox confirm = new VBox();
        confirm.getChildren().addAll(getParametr);
        VBox.setVgrow(getParametr, Priority.ALWAYS);
        VBox.setMargin(getParametr, new Insets(60, 0, 200, 0));
        borderPane.setCenter(inputList);
        borderPane.setBottom(confirm);
        confirm.setAlignment(Pos.TOP_CENTER);
        borderPane.setBackground(new Background(new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY)));

        getParametr.setOnAction(action -> {
            configName[0] = Integer.parseInt(elementsQuantity.getText());
            if (configName[0] < 2) {
                try {
                    throw new Exception("N musi być większe od 2!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            stage.close();
        });
        return stage;
    }
}
