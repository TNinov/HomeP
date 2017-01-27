package com.falsy.todolist;

import com.falsy.todolist.datamodel.TodoData;
import com.falsy.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class EditDialogController {
    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processEditResults(){
        String shortDescription = shortDescriptionField.getSelectedText().trim();
        String details = detailsArea.getSelectedText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();
        TodoItem editItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(editItem);
        return editItem;
    }
}
