import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Wibracje akustyczne warstwy materiału");
        BorderPane borderPane = new BorderPane();

        stage.setScene(new Scene(borderPane, 880, 460));
        stage.show();
        Label tittle = new Label("Wibracje akustyczne warstwy materiału");
        tittle.setStyle("-fx-font-family: 'Bauhaus 93'; -fx-font-size: 22pt; -fx-text-fill: #ffffff; -fx-background-color: rgba(0,0,0,0.84);");
        borderPane.setTop(tittle);
        BorderPane.setAlignment(tittle, Pos.CENTER);
        BorderPane.setMargin(tittle, new Insets(20, 0, 20, 0));
        final int[] configName = {-1};
        TextField elementsQuantity = new TextField();
        Label nQuantity = new Label("Podaj ilość elementów: ");
        nQuantity.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 15 pt; -fx-text-fill: #ffffff; -fx-background-color: rgba(0,0,0,0.93);");
        nQuantity.setAlignment(Pos.CENTER);

        Button getParametr = new Button("CONFIRM");
        getParametr.setStyle("-fx-font-family: 'Bauhaus 93'; -fx-font-size: 15 pt; -fx-text-fill: #ffffff; -fx-background-color: rgba(0,0,0,0.84);-fx-border-color: white;");


        HBox inputList = new HBox(10);
        inputList.getChildren().addAll(nQuantity, elementsQuantity);
        inputList.setAlignment(Pos.TOP_CENTER);

        VBox confirm = new VBox();
        confirm.getChildren().addAll(getParametr);
        VBox.setVgrow(getParametr, Priority.ALWAYS);
        VBox.setMargin(getParametr, new Insets(60, 0, 200, 0));
        inputList.setAlignment(Pos.CENTER);
        borderPane.setCenter(inputList);
        borderPane.setBottom(confirm);
        confirm.setAlignment(Pos.TOP_CENTER);
        borderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        getParametr.setOnAction(action -> {
            configName[0] = Integer.parseInt(elementsQuantity.getText());
            if (configName[0] < 2) {
                try {
                    throw new Exception("N musi być większe od 2!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            stage.setScene(solution(configName[0]));
        });

    }

    private Scene solution(int n){
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("U");
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Wibracje akustyczne warstwy materiału");
        double h = 2.0/n;
        Solution mes2022 = new Solution(n);
        double[] coeff = mes2022.coefficients();
        List<XYChart.Data<Number, Number>> data = new ArrayList<>();
        data.add(new XYChart.Data<>(0,0));
        for (int i = 1; i <= coeff.length; i++) {
            double x=  h*(i);
            double y = coeff[i-1];
            System.out.println(y);
            data.add(new XYChart.Data<>(x, y));
        }
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("U(x)");
        series.getData().addAll(data);

        lineChart.getData().add(0,series);

        return new Scene(lineChart, 800, 600);

    }


}
