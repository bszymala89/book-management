package com.projects.bookmanagement;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class MainController {
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, Number> idColumn;
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Number> priceColumn;
    @FXML
    private TableColumn<Book, Number> yearColumn;
    @FXML
    private TableColumn<Book, Number> pagesColumn;
    @FXML
    private TableColumn<Book, Number> stockColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    @FXML
    private void initialize() {
        try {
            List<Book> books = Book.readFromJson("assets/books.json");
            ObservableList observableList = FXCollections.observableArrayList(books);
            tableView.setItems(observableList);

            idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
            nameColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitle()));
            authorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAuthor()));
            priceColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrice()));
            yearColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getYear()));
            pagesColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumberOfPages()));
            stockColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStock()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addButtonClicked() throws IOException {
        showAddBookWindow();
    }

    @FXML
    public void updateButtonClicked() throws IOException {
        showUpdateBookWindow();
    }

    @FXML
    public void deleteButtonClicked() throws IOException {
        Book bookToDelete = tableView.getSelectionModel().getSelectedItem();
        List<Book> books = Book.readFromJson("assets/books.json");
        for(Book el:books) {
            if (el.getId() == bookToDelete.getId()) {
                books.remove(el);
                BookUtils.writeToJson(books, "assets/books.json");
                break;
            }
        }
        initialize();
    }

    @FXML
    public void showAddBookWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addBook-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage newWindow = new Stage();
        Scene scene = new Scene(root);
        newWindow.setScene(scene);
        newWindow.setTitle("Add Book");
        newWindow.show();
    }

    @FXML
    public void showUpdateBookWindow() throws IOException {

    }
}