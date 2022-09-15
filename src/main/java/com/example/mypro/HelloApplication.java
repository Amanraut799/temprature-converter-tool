package com.example.mypro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void init() throws Exception
    {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        System.out.println("Start");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode=fxmlLoader. load();
        MenuBar menuBar=CreateMenu();
        rootNode.getChildren().add(0,menuBar );





        Scene scene = new Scene(rootNode, 320, 240);
        stage.setTitle("Temprature Converter Tool.");
        stage.setScene(scene);
        stage.show();
    }


    private MenuBar CreateMenu()
    {
        Menu fileMenu= new Menu("File");
                MenuItem newMenuItem=new MenuItem("New");

                newMenuItem.setOnAction(event -> System.out.println("New Item is Clicked"));
        SeparatorMenuItem SeperatorMenuItem= new SeparatorMenuItem();


        MenuItem quitMenuItem =new MenuItem("quit");
                quitMenuItem.setOnAction(event -> {
                    Platform.exit();
                    System.exit(0);
                });
                fileMenu.getItems().addAll(newMenuItem,SeperatorMenuItem,quitMenuItem);


        Menu helpMenu=new Menu("Help");
                MenuItem aboutapp= new MenuItem("About");
               aboutapp.setOnAction(event -> aboutApp());
                helpMenu.getItems().add(aboutapp);



        MenuBar menubar=new MenuBar();



        menubar.getMenus().addAll(fileMenu, helpMenu);

        return menubar;
    }

    private void aboutApp() {

        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("my first Application");
        alertDialog.setHeaderText("learning JAVAFX");
        alertDialog.setContentText("Iam jsut a begginer but soon will be pro in develping awsome java games");
        ButtonType yesbtn =new ButtonType("yes");
        ButtonType nobtn =new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);
        Optional<ButtonType> clickbtn = alertDialog.showAndWait();
        if(clickbtn.isPresent()&&clickbtn.get()==yesbtn)
        {
           System.out.println("YES btn clicked");
        }
        else
        {
            System.out.println("NO btn clicked");
        }
    }


    public static void main(String[] args)
    {
        System.out.println("launch");
        launch();
    }}