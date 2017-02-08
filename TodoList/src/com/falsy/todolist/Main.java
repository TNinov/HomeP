package com.falsy.todolist;

import com.falsy.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.getIcons().add(new Image("file:src/com/falsy/todolist/img/icon.png"));
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadTodoItems();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
