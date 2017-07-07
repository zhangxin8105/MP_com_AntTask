/**
 * Copyright 2017 - Zhang Xin
 *
 * Date: 2017年5月9日  下午1:49:58
 */

package zhangxin.ant.task.run;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public final class StudyDirectoryChooser extends Application {

    private final Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");

        final DirectoryChooser fileChooser = new DirectoryChooser();

        final Button openButton = new Button("Open a Picture...");

        openButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                configureFileChooser(fileChooser);
                File file = fileChooser.showDialog(stage);
                if (file != null) {
                    openFile(file);
                }
            }
        });

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    private static void configureFileChooser(final DirectoryChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
                );
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void openFile(final File file) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(StudyDirectoryChooser.class.getName()).log(Level.SEVERE, null,
                            ex);
                }
            }
        });
    }
}
