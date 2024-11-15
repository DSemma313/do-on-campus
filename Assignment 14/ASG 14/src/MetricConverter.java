import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MetricConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Enter value in meters");

        ComboBox<String> conversionType = new ComboBox<>();
        conversionType.getItems().addAll("Meters to Kilometers", "Kilograms to Grams");
        conversionType.setValue("Meters to Kilometers");

        Button convertButton = new Button("Convert");

        Label resultLabel = new Label();

        convertButton.setOnAction(event -> {
            try {
                double inputValue = Double.parseDouble(inputField.getText());
                String selectedConversion = conversionType.getValue();
                double result;

                if (selectedConversion.equals("Meters to Kilometers")) {
                    result = inputValue / 1000;
                } else if (selectedConversion.equals("Kilograms to Grams")) {
                    result = inputValue * 1000;
                } else {
                    result = 0;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a number.");
            }
        });

        // Layout setup
        VBox layout = new VBox(10, inputField, conversionType, convertButton, resultLabel);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Metric Converter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
