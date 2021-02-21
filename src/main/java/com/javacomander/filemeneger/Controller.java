package com.javacomander.filemeneger;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller  {
@FXML
    VBox leftPanel, rightPanel;

    public void btnExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }



    public void copyBtnAction(ActionEvent actionEvent) {
        PanelController leftPC = (PanelController) leftPanel.getProperties().get("ctrl");
        PanelController rightPC = (PanelController) rightPanel.getProperties().get("ctrl");

        if(leftPC.getSelectedFilename() == null && rightPC.getSelectedFilename() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Файл не выбран", ButtonType.OK);
            alert.showAndWait();
            return;

        }
        PanelController srcPC = null, distPC = null;
        if(leftPC.getSelectedFilename() != null) {
            srcPC = leftPC;
            distPC= rightPC;
        }
        if(rightPC.getSelectedFilename() != null) {
            srcPC = rightPC;
            distPC = leftPC;
        }

        Path srcPath = Paths.get(srcPC.getCurrentPath(),srcPC.getSelectedFilename());
        Path dstPath = Paths.get(distPC.getCurrentPath()).resolve(srcPath.getFileName().toString());

       try {
           Files.copy(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING);
           distPC.updateList(Paths.get(distPC.getCurrentPath()));
       }catch (IOException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR,"Не удалось скопировать указанный файл", ButtonType.OK);
           alert.showAndWait();
       }


    }


    public void moveBtnAction(ActionEvent actionEvent) {
        PanelController leftPC = (PanelController) leftPanel.getProperties().get("ctrl");
        PanelController rightPC = (PanelController) rightPanel.getProperties().get("ctrl");

        if(leftPC.getSelectedFilename() == null && rightPC.getSelectedFilename() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Файл не выбран", ButtonType.OK);
            alert.showAndWait();
            return;

        }
        PanelController srcPC = null, distPC = null;
        if(leftPC.getSelectedFilename() != null) {
            srcPC = leftPC;
            distPC= rightPC;
        }
        if(rightPC.getSelectedFilename() != null) {
            srcPC = rightPC;
            distPC = leftPC;
        }

        Path srcPath = Paths.get(srcPC.getCurrentPath(),srcPC.getSelectedFilename());
        Path dstPath = Paths.get(distPC.getCurrentPath()).resolve(srcPath.getFileName().toString());


        try {
            Files.move(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING);
            distPC.updateList(Paths.get(distPC.getCurrentPath()));
            srcPC.updateList(Paths.get(srcPC.getCurrentPath()));
        }catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Не удалось переместить указанный файл", ButtonType.OK);
            alert.showAndWait();
        }

    }

    public void deleteBtnAction(ActionEvent actionEvent) {
        PanelController leftPC = (PanelController) leftPanel.getProperties().get("ctrl");
        PanelController rightPC = (PanelController) rightPanel.getProperties().get("ctrl");

        if(leftPC.getSelectedFilename() == null && rightPC.getSelectedFilename() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Файл не выбран", ButtonType.OK);
            alert.showAndWait();
            return;

        }
        PanelController srcPC = null, distPC = null;
        if(leftPC.getSelectedFilename() != null) {
            srcPC = leftPC;
            distPC= rightPC;
        }
        if(rightPC.getSelectedFilename() != null) {
            srcPC = rightPC;
            distPC = leftPC;
        }

        Path srcPath = Paths.get(srcPC.getCurrentPath(),srcPC.getSelectedFilename());
        Path dstPath = Paths.get(distPC.getCurrentPath()).resolve(srcPath.getFileName().toString());


        try {
            Files.delete(srcPath);
            srcPC.updateList(Paths.get(srcPC.getCurrentPath()));
        }catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Не удалось удалить указанный файл", ButtonType.OK);
            alert.showAndWait();
        }

    }
    }
