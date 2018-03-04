package controller;

import library.Books;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.table.DefaultTableModel;



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

    @SuppressWarnings("rawtypes")
	@FXML
    private TableView jTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/library","root","admin");
    		return conn;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public ArrayList<Books> getBooksList(){
    	ArrayList<Books> booksList = new ArrayList<Books>();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM books ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Books books;
			while(rs.next()) {
				books = new Books(rs.getString("Title"),rs.getString("Author"),rs.getInt("Year"),rs.getInt("Pages"));
				booksList.add(books);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return booksList;
    }
    
    // need to be finished - I still don't know how to view ArrayList in TableView
    public void showBooks() {
    	ArrayList<Books> list = getBooksList();
    	
    	
    }

}
