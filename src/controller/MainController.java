package controller;

import library.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ResourceBundle;





public class MainController implements Initializable {

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField pagesField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Books> TableView;
    
    @FXML
    private TableColumn<Books, String> titleColumn;

    @FXML
    private TableColumn<Books, String> authorColumn;

    @FXML
    private TableColumn<Books, Integer> yearColumn;

    @FXML
    private TableColumn<Books, Integer> pagesColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	showBooks();
    }
    
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","admin");
    		return conn;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public ObservableList<Books> getBooksList(){
    	ObservableList<Books> booksList = FXCollections.observableArrayList();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM books ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Books books;
			while(rs.next()) {
				books = new Books(rs.getString("title"),rs.getString("Author"),rs.getInt("Year"),rs.getInt("Pages"));
				booksList.add(books);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return booksList;
    }
    
    // need to be finished - I still don't know how to view ArrayList in TableView
    public void showBooks() {
    	ObservableList<Books> list = getBooksList();
    	
    	titleColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("title"));
    	authorColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
    	yearColumn.setCellValueFactory(new PropertyValueFactory<Books,Integer>("year"));
    	pagesColumn.setCellValueFactory(new PropertyValueFactory<Books,Integer>("pages"));
    	
    	TableView.setItems(list);
    }

}
