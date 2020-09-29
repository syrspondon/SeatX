package seatX.Controller;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
    public static void display(String a) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        Label lb = new Label("Booking seat no. "+a);
        Button closeButtonY = new Button("Confirm");
        Button closeButtonN = new Button("Select Again");
        closeButtonY.setOnAction(e -> {
            Seat.confirm = true;
            window.close();
        });
        closeButtonN.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lb, closeButtonY, closeButtonN);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,200,200);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }
}
