/*
 * Author: Leonardo Mazuran
 * This a startup project for csci3300
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.sql.SQLException;
import java.text.DecimalFormat;

//import javax.mail.MessagingException;


//import javafx.scene.control.ProgressIndicator;
import model.project;
import application.Main;
import application.DbConfig;
import application.smtp;
import javafx.event.ActionEvent;
//import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
//import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
//import javafx.stage.Modality;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

public class MainController {
	//MySQL todo task
// input hashing for password using sha512/salt. encrypt with aes in mysql server side.
//input timestamp on all updates in tuples/tables.
//ssl mysql connection setup.




private Main main;
public void setMain(Main mainIn)
{
	main = mainIn;
}

private static int mem_logid;
public int code_mem;
public static String mem_email;
public static String mem_username;
public static String mem_timestamp;
public int r1_mem;
public  int r2_mem;
public  int r3_mem;
public int r4_mem;
public int r5_mem;
public int s1_mem;
public int s2_mem;
public int s3_mem;
public int s4_mem;
public int f1_mem;
public int f2_mem;
public int f3_mem;
public int f4_mem;
public int f5_mem;

String email_a,email_b,email_c;
String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com|org|edu|net))+$";
//email connection


//Login inputs
@FXML private TextField Login_Username;
@FXML private PasswordField Login_Password;
@FXML private Button Login_Create;
@FXML private Button Login_button;
@FXML private Button Login_Forgot;
@FXML private Label Login_status;
//CA inputs
@FXML private TextField CA_FirstName;
@FXML private TextField CA_LastName;
@FXML private TextField CA_email;
@FXML private TextField CA_UserName;
@FXML private PasswordField CA_Password;
@FXML private PasswordField CA_Rpassword;
@FXML private Button CA_Submit_button;
@FXML private Button CA_GoBack;
@FXML private Label CA_status;
//Forgot Input
@FXML private TextField forgot_email;
@FXML private Button Forgot_Submit;
@FXML private Label forgot_status;
@FXML private Button forgot_goback_Button;
@FXML private Button forgot_continue_Button;
@FXML private Label forgot_status1;
@FXML private Button forgot_next;
//Forgot Next Input
@FXML private TextField fn_email;
@FXML private TextField fn_code;
@FXML private PasswordField fn_password;
@FXML private PasswordField fn_rpassword;
@FXML private Label fn_status;
@FXML private Button fn_resetB;
@FXML private Button Fn_Goback;
//Account
@FXML private Button UA_UUB;
@FXML private Button UA_UE;
@FXML private Button UA_UPB;
@FXML private Button UA_DAB;
@FXML private TextField UA_username;
@FXML private TextField UA_email;
@FXML private PasswordField UA_password;
@FXML private PasswordField UA_rpassword;
@FXML private Label UA_status;
//Main
@FXML private Label m_welcome;
@FXML private Button Main_Account_Button;
@FXML private Button Main_logout_Button ;
@FXML private Button main_Overview;
@FXML private Button main_State;
@FXML private Button main_federal;
@FXML private Button main_result;
@FXML private ProgressBar main_progress;
//stage1
@FXML private Label ol_1;
@FXML private Label ol_2;
@FXML private Label ol_3;
@FXML private Label ol_4;
@FXML private Label ol_5;
@FXML private Label ol_6;
@FXML private Label ol_7;
@FXML private Label ol_8;
@FXML private Label ol_9;
@FXML private TextField O_1;
@FXML private TextField O_2;
@FXML private TextField O_3;
@FXML private TextField O_4;
@FXML private TextField O_5;
@FXML private TextField O_6;
@FXML private TextField O_7;
@FXML private TextField O_8;
@FXML private TextField O_9;
@FXML private Button O_SE;
@FXML private Button O_SC;
@FXML private Button test;
//stage 2
@FXML private Label sl_1;
@FXML private Label sl_2;
@FXML private Label sl_3;
@FXML private Label sl_4;
@FXML private TextField S_1;
@FXML private TextField S_2;
@FXML private TextField S_3;
@FXML private TextField S_4;
@FXML private Button S_SE;
@FXML private Button S_SC;
@FXML private Button s_test;
//stage 3
@FXML private Label fl_1;
@FXML private Label fl_2;
@FXML private Label fl_3;
@FXML private Label fl_4;
@FXML private Label fl_5;
@FXML private Label fl_6;

@FXML private TextField f_1;
@FXML private TextField f_2;
@FXML private TextField f_3;
@FXML private TextField f_4;
@FXML private TextField f_5;
@FXML private TextField f_6;

@FXML private Button f_SE;
@FXML private Button f_test;
@FXML private Button f_SC;
//review/result
@FXML private Label ro_1;
@FXML private Label ro_2;
@FXML private Label ro_3;
@FXML private Label ro_4;
@FXML private Label ro_5;
@FXML private Label ro_6;
@FXML private Label ro_7;
@FXML private Label rs_1;
@FXML private Label rs_2;
@FXML private Label rs_3;
@FXML private Label rs_4;
@FXML private Label rf_1;
@FXML private Label rf_2;
@FXML private Label rf_3;
@FXML private Label rf_4;
@FXML private Label rf_5;
@FXML private Label rl_mes;
@FXML private Label rl_calc;
@FXML private Button r_review;
@FXML private Button r_calc;
@FXML private Button r_b;



//Delete
@FXML private PasswordField D_password;
@FXML private Button D_button;
@FXML private Button D_GB;
@FXML private Label D_status;
Stage stage;
Scene scene;
Scene scene2;
Parent root;
public void ClickBa(ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void Clickcal(ActionEvent event) throws Exception{
	result();
}

public void ClickMresult(ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/stage4.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	
}
public void ClickReview(ActionEvent event) throws Exception{
	ro();
	rs();
	rf();
}
public void Clicktest(ActionEvent event) throws Exception{
	geto();
}
public void Clicktest2(ActionEvent event) throws Exception{
	gets();
}
public void Clicktest3(ActionEvent event) throws Exception{
	getf();
}

public void ClickSSE(ActionEvent event) throws Exception{
	saves();
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	
	
	
}
public void ClickSSC(ActionEvent event) throws Exception{
	saves();
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/stage3.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void ClickFSE(ActionEvent event) throws Exception{
	savef();stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void ClickFSC(ActionEvent event) throws Exception{
	savef();
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/stage4.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void ClickOSE(ActionEvent event) throws Exception{
	saveo();
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void ClickOSC(ActionEvent event) throws Exception{
	saveo();
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Stage2.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}

public void ClickMO(ActionEvent event) throws Exception{
	
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	
	root = FXMLLoader.load(getClass().getResource("/view/stage1.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	
	
	
	
	
	

	
}
public void ClickMS(ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/stage2.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	
}
public void ClickMF(ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/stage3.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	
}
public void ClickLogOut(ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	mem_logid=0;
	stage.setTitle("Logout!");
}
	public void ClickAccountUpdate(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Account.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		
		stage.setScene(new Scene(root));
		stage.show();
		
	}

public void ClickCA(ActionEvent event) throws Exception{
	

stage = (Stage)((Button) event.getSource()).getScene().getWindow();
root = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
scene = new Scene(root);
stage.setScene(scene);
}
public void ClickCAGoBack(ActionEvent event) throws Exception{
	

stage = (Stage)((Button) event.getSource()).getScene().getWindow();
root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
scene = new Scene(root);
stage.setScene(scene);
}
public void ClickForgotButton(ActionEvent event) throws Exception{
	

stage = (Stage)((Button) event.getSource()).getScene().getWindow();
root = FXMLLoader.load(getClass().getResource("/view/ForgotView.fxml"));
scene = new Scene(root);
stage.setScene(scene);

}
public void ClickCASubmit(ActionEvent event) throws Exception{
	CASubmit();
}
public void ClickLoginButton (ActionEvent event) throws Exception{
	authenticate();
	if (mem_logid != 0){
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	welcome();
	
	
	}
}
public void ClickForgotSubmit (ActionEvent event) throws Exception{
	
	forgot();
	
}
public void ClickDGB (ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Account.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void ClickForgotCode (ActionEvent event) throws Exception{
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/forgotInput.fxml"));
	Parent root = (Parent) fxmlLoader.load();
	Stage stage = new Stage();
	
	stage.setScene(new Scene(root));
	stage.show();
}
public void ClickFnButton (ActionEvent event) throws Exception{
	reset();
}

public void ClickUUB (ActionEvent event) throws Exception{
	String query = "update login set username = ? where loginid = ? ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement insertprofile = conn.prepareStatement(query);){
		String username;int loginid;
		 loginid = mem_logid;
		username = UA_username.getText();
		
		project change = new project();
		change.setUserId(loginid);
		change.setUsername(username);
		insertprofile.setString(1, change.getUsername());
		insertprofile.setInt(2, change.getUserId());
		if (username == null || username == "" || username.trim().isEmpty()) {
			throw new Exception("Need Username");
		}
		int result = insertprofile.executeUpdate();
		
		
		if (result ==1){
			
			
			UA_status.setTextFill(Color.GREEN);}else{
			throw new Exception("Can not proceed");}
		
			
			String a,b,c;
			a = mem_email;
			b = "Update Alert";
			c = "Hello," +
					"\n\n This is a friendly reminder that your username has been updated to " + change.getUsername() +
					"\n \n Thank you, FastTax";
			smtp.connect(a,b,c);
			System.out.println("Done");
			UA_status.setText("Username reset");
			UA_username.setText(null);
		
	}catch (Exception e){
		UA_status.setTextFill(Color.RED);
		UA_status.setText(e.getMessage());
		System.out.println(mem_email);
	}
	
}
public void ClickUAUE (ActionEvent event) throws Exception{
	
		String query = "update login set email = ? where loginid = ? ";
		try (Connection conn = DbConfig.getConnection();
				PreparedStatement insertprofile = conn.prepareStatement(query);){
			String email;int loginid;
			 loginid = mem_logid;
			email = UA_email.getText();
			
			project change = new project();
			change.setUserId(loginid);
			change.setEmail(email);
			insertprofile.setString(1, change.getEmail());
			insertprofile.setInt(2, change.getUserId());
			Boolean emailResult = email.matches(emailregex);
			if (email == null || email == "" || emailResult == false) {
				throw new Exception("Invalid Email.");
			}
			int result = insertprofile.executeUpdate();
			
			
			if (result ==1){
				
				
				UA_status.setTextFill(Color.GREEN);}else{
				throw new Exception("Can not Proceed");}
				String a,b,c;
				a = mem_email;
				b = "Update Alert";
				c = "Hello," +
						"\n\n We notice that you change your email account to ("+change.getEmail()+ ") and we want to let you know it was done Successfully!" +
						"\n \n Thank you for using FastTax";
				smtp.connect(a,b,c);

				System.out.println("Done");
				UA_status.setText("Email reset");
				UA_email.setText(null);
			
		}catch (Exception e){
			UA_status.setTextFill(Color.RED);
			UA_status.setText(e.getMessage());
			System.out.println(mem_email);
		}
		
	
}

public void ClickUAUP(ActionEvent event) throws Exception{
	String query = "update login set password= aes_encrypt(?,?) where loginid = ? ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement insertprofile = conn.prepareStatement(query);){
		String password,rpassword;int loginid;
		 loginid = mem_logid;
		password = UA_password.getText();
		rpassword = UA_rpassword.getText();
		
		project change = new project();
		change.setUserId(loginid);
		change.setPassword(password);
		insertprofile.setString(1, change.getPassword());
		insertprofile.setString(2, change.getPassword());
		insertprofile.setInt(3, change.getUserId());
		if (password == null || password == "" || password.trim().isEmpty()) {
			throw new Exception("Need Password.");
		}
		if (password.length() < 8){

			throw new Exception ("Password is to short! ");
		}
		if (rpassword == null || rpassword == "" || rpassword.trim().isEmpty()) {
			throw new Exception("Need Password.");
		}
		if (password.equals (rpassword)) {
			System.out.println("password good");
		}else {
			throw new Exception ("Passwords do not match");
		}
		int result = insertprofile.executeUpdate();
		
		
		if (result ==1){
			
			
			UA_status.setTextFill(Color.GREEN);}else{
			throw new Exception("Can not Proceed");}
		String a,b,c;
		a= mem_email;
		b="Update Alert";
		c = "Hello," +
				"\n\n This is a friendly reminder that your password has been updated!" +
				"\n \n Thank you, FastTax";
		smtp.connect(a,b,c);
		
		
			

			System.out.println("Done");
			UA_status.setText("Password reset");
			UA_rpassword.setText(null);
			UA_password.setText(null);
		
	}catch (Exception e){
		UA_status.setTextFill(Color.RED);
		UA_status.setText(e.getMessage());
		System.out.println(mem_email);
	}
	
}
public void ClickUADA (ActionEvent event) throws Exception{
	stage = (Stage)((Button) event.getSource()).getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("/view/Delete.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
}
public void ClickDB (ActionEvent event) throws Exception{
	String query = "DELETE FROM `login` WHERE password = aes_encrypt(?,?) and loginid = ?  ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement insertprofile = conn.prepareStatement(query);){
		String password;int loginid;
		 loginid = mem_logid;
		password =D_password.getText();
		
		project change = new project();
		change.setUserId(loginid);
		change.setPassword(password);
		insertprofile.setString(1, change.getPassword());
		insertprofile.setString(2, change.getPassword());
		insertprofile.setInt(3, change.getUserId());
		if (password == null || password == "" || password.trim().isEmpty()) {
			throw new Exception("Need Password");
		}
		int result = insertprofile.executeUpdate();
		
		
		
		if (result ==1){
			
			
			D_status.setTextFill(Color.GREEN);}else{
			throw new Exception("Password unknown");}
		stage = (Stage)((Button) event.getSource()).getScene().getWindow();
		stage.close();
		String a,b,c;
		a=mem_email;
				b="Account Deletion";
				c="Hello," +
						"\n\n We notice that you deleted your account and we want to let you know it was done Successfully!" +
						"\n \n Thank you for using FastTax";
				smtp.connect(a, b, c);
				

			System.out.println("Done");
		
	
		
	}catch (Exception e){
		D_status.setTextFill(Color.RED);
		D_status.setText(e.getMessage());
		
	}
	
}

private void saves(){
	String query ="update stage2 set s1 = ?, s2 = ?, s3 = ?, s4 = ?  where Logid = ? ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement updatesaveo = conn.prepareStatement(query);){
		String firstname, lastname, address, City;
		firstname = S_1.getText();
		lastname = S_2.getText();
		address = S_3.getText();
		City = S_4.getText();
		
		project saveo = new project();
		saveo.setFirstName(firstname);
		saveo.setLastName(lastname);
		saveo.setAddress(address);
		saveo.setCity(City);
		
		
		updatesaveo.setString(1, saveo.getFirstName());
		updatesaveo.setString(2, saveo.getLastName());
		updatesaveo.setString(3, saveo.getAddress());
		updatesaveo.setString(4, saveo.getCity());
		
		updatesaveo.setInt(5, mem_logid);
		int result = updatesaveo.executeUpdate();
		if (result == 1){
			System.out.println("saveo good");
		}else{
			System.out.println(mem_logid);
		}
		
		
		
		
		
	}catch (SQLException e){
		System.out.println(e);
		
	}
	
}	
private void savef(){
	String query ="update stage3 set f1 = ?, f2 = ?, f3 = ?, f4 = ?, f5 = ? where LoginId = ? ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement updatesaveo = conn.prepareStatement(query);){
		String firstname, lastname, address, City, Zipcode;
	
		firstname = f_1.getText();
		lastname = f_2.getText();
		address = f_3.getText();
		City = f_4.getText();
		Zipcode = f_5.getText();
		
		project saveo = new project();
		saveo.setFirstName(firstname);
		saveo.setLastName(lastname);
		saveo.setAddress(address);
		saveo.setCity(City);
		saveo.setZipcode(Zipcode);
		
		updatesaveo.setString(1, saveo.getFirstName());
		updatesaveo.setString(2, saveo.getLastName());
		updatesaveo.setString(3, saveo.getAddress());
		updatesaveo.setString(4, saveo.getCity());
		updatesaveo.setString(5, saveo.getZipcode());
		
		updatesaveo.setInt(6, mem_logid);
		int result = updatesaveo.executeUpdate();
		if (result == 1){
			System.out.println("saveo good");
		}else{
			System.out.println(mem_logid);
		}
		
		
		
		
		
	}catch (SQLException e){
		System.out.println(e);
		
	}
	
}
private void saveo(){
	String query ="update stage1 set mlname = ?,LFirstname = ?, LLastName =?, SSN = ?, birthday = ?, Address = ?, City = ? where LoginId = ? ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement updatesaveo = conn.prepareStatement(query);){
		String firstname, lastname, address, City, Zipcode, State;
		String SSN;
		firstname = O_1.getText();
		lastname = O_2.getText();
		address = O_3.getText();
		City = O_4.getText();
		Zipcode = O_5.getText();
		State = O_6.getText();
		SSN = O_7.getText();
		
		project saveo = new project();
		saveo.setFirstName(firstname);
		saveo.setLastName(lastname);
		saveo.setAddress(address);
		saveo.setCity(City);
		saveo.setZipcode(Zipcode);
		saveo.setState(State);
		saveo.setSSN(SSN);
		
		updatesaveo.setString(1, saveo.getFirstName());
		updatesaveo.setString(2, saveo.getLastName());
		updatesaveo.setString(3, saveo.getAddress());
		updatesaveo.setString(4, saveo.getCity());
		updatesaveo.setString(5, saveo.getZipcode());
		updatesaveo.setString(6, saveo.getState());
		updatesaveo.setString(7, saveo.getSSN());
		
		updatesaveo.setInt(8, mem_logid);
		int result = updatesaveo.executeUpdate();
		if (result == 1){
			System.out.println("saveo good");
		}else{
			System.out.println(mem_logid);
		}
		
		
		
		
		
	}catch (SQLException e){
		System.out.println(e);
		
	}
	
}
private void reset() {
	String query = "update login set password= aes_encrypt(?,?), acode = NULL where acode= ? and email= ?";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement updatereset = conn.prepareStatement(query);){
		String password,email, rpassword;
		String code;
		code= fn_code.getText();
		email = fn_email.getText();
		password = fn_password.getText();
		rpassword = fn_rpassword.getText();
		project reset= new project();
		Boolean emailResult = email.matches(emailregex);
		if (email == null || email == "" || emailResult == false) {
			throw new Exception("Invalid Email.");
		
		}
		if (code == null || code == "" || code == "0"){
			throw new Exception("Invalid Code");
		}
		if (password.equals (rpassword)){
			System.out.println("good password");
		}else{
			throw new Exception("Passwords do not match");
		}
		
	
		reset.setAcode(code);
		reset.setEmail(email);
		reset.setPassword(rpassword);
		updatereset.setString(1, reset.getPassword());
		updatereset.setString(2, reset.getPassword());
		updatereset.setString(3, reset.getAcode());
		updatereset.setString(4, reset.getEmail());
		int result = updatereset.executeUpdate();
		
if (result ==1){
			
			fn_status.setTextFill(Color.GREEN);
			fn_email.setText(null);
			fn_password.setText(null);
			fn_rpassword.setText(null);
			fn_code.setText(null);
			fn_status.setText("Thank you, Your password is reset!");
			
			
		}else{
			throw new Exception("Invalid Email and Code");
			
		}


		
	}catch(Exception e){
		fn_status.setText(e.getMessage());
		fn_status.setTextFill(Color.RED);
	}
	
	
}
private void forgot() {
	String query = "update login set Acode = ? where email = ? ";
	try (Connection conn = DbConfig.getConnection();
			PreparedStatement insertprofile = conn.prepareStatement(query);){
		int code;
		String email;
		code =  (int) (Math.random() * 1000000000+1);
		email = forgot_email.getText();
		code_mem = code;
		project forgot = new project();
		
		Boolean emailResult = email.matches(emailregex);
		if (email == null || email == "" || emailResult == false) {
			throw new Exception("Invalid Email.");
		
		}
		forgot.setCode(code);
		
		forgot.setEmail(email);
		insertprofile.setInt(1, forgot.getCode());
		insertprofile.setString(2, forgot.getEmail());
		int result = insertprofile.executeUpdate();
		if (result ==1){
			
			forgot_status.setText("Email is valid. Sending email please wait!");
			forgot_status.setTextFill(Color.GREEN);
			
			
			
		}else{
			throw new Exception("Invalid Email!");
			
		}
		
	
		String a,b,c;
		a= forgot_email.getText();
		b="Password Reset";
		c = "Hello," +
				"\n\n Your password reset code is:  "+ code_mem + " \n Thank you!";
		smtp.connect(a,b,c);
		System.out.println("Done");
		code_mem= 0;
		
		forgot_status.setText("Send! Please check your email");
		forgot_email.setText(null);

	} catch (Exception e) {
		forgot_status.setText(e.getMessage());
	
		System.out.println(e);
	}
	
}


private void welcome() throws Exception{


	String query = "Select firstname, lastname, email from login where loginid = ?";
	try(Connection conn= DbConfig.getConnection()){
		PreparedStatement welcome = conn.prepareStatement(query); 
		welcome.setInt(1, mem_logid);
	ResultSet result1 = welcome.executeQuery();
		if (result1.next()){
			
			String firstname = result1.getString("firstname");
			String lastname = result1.getString("lastname");
			mem_email = result1.getString("email");
			 
			
			stage.setTitle(" Welcome " + firstname + " " + lastname+ "! ");
			//m_welcome.setText("System Error: missing logid ");
			main_progress.setProgress(33);
			
		}else{
			m_welcome.setText("System Error: missing logid ");
		}
		//m_welcome.setText("System Error: missing logid ");
		main_progress.setProgress(33);
	}catch(Exception e){
		System.out.println(" " +e.getMessage());
		
	}
	
}
public void authenticate() throws Exception {
	String query = "Select LoginId from Login Where username = ? AND password = aes_encrypt(?,?) ";
	try(Connection conn= DbConfig.getConnection()){
		PreparedStatement authenticate = conn.prepareStatement(query); 
		authenticate.setString(1,Login_Username.getText());
		authenticate.setString(2, Login_Password.getText());
		authenticate.setString(3, Login_Password.getText());
		ResultSet result = authenticate.executeQuery();
		if (result.next()){
			
			Login_status.setText("Success!!");
			Login_status.setTextFill(Color.GREEN);
			mem_logid = result.getInt("LoginId");
			System.out.println(mem_logid);
			
			
		}else{
			
			Login_status.setText("Incorrect Login credentials! Try Again");
			Login_status.setTextFill(Color.RED);
			
		}
			
		
	}catch (Exception e) {
			Login_status.setText(" " + e.getMessage());
		
	}
}
public void CASubmit() throws Exception {
	String query = "insert into Login " + "(LoginId, email, Username, password, firstname, lastname, acode)"
			+ "values(?,?,?,aes_encrypt(?,?),?,?, NULL)";
	
	
	//String query = "insert into Login " + "(LoginId, email, Username, password, firstname, lastname)"
		//	+ "values(1234,4343,2323,aes_encrypt(2323,2323),2323,2323)";
	

	try (Connection conn = DbConfig.getConnection();
			PreparedStatement insertprofile = conn.prepareStatement(query);){
		int UserId;
		String email, username, password,firstname,lastname, rpassword;
		UserId =  (int) (Math.random() * 100000000+1);
		mem_logid = UserId;
		firstname = CA_FirstName.getText();
		lastname = CA_LastName.getText();
		email = CA_email.getText();
		username = CA_UserName.getText();
		password = CA_Password.getText();
		rpassword = CA_Rpassword.getText();
		
		Boolean emailResult = email.matches(emailregex);



		// value validation
		if (firstname == null || firstname == "" || firstname.trim().isEmpty()) {
			throw new Exception("Need first name.");
		}

		if (lastname == null || lastname == "" || lastname.trim().isEmpty()) {
			throw new Exception("need last name.");
		}
		if (email == null || email == "" || emailResult == false) {
			throw new Exception("Invalid Email.");
		}
		if (username == null || username == "" || username.trim().isEmpty()) {
			throw new Exception("Need Username");
		}
		if (password == null || password == "" || password.trim().isEmpty()) {
			throw new Exception("Need Password.");
		}
		if (password.length() < 8){

			throw new Exception ("Password is to short! ");
		}
		if (rpassword == null || rpassword == "" || rpassword.trim().isEmpty()) {
			throw new Exception("Need Password.");
		}
		if (password.equals (rpassword)) {
			System.out.println("password good");
		}else {
			throw new Exception ("Passwords do not match");
		}

		//
		project login = new project();
		login.setUserId(UserId);
		login.setFirstName(firstname);
		login.setLastName(lastname);
		login.setEmail(email);
		login.setUsername(username);
		login.setPassword(password);
		
		

		insertprofile.setInt(1, login.getUserId());
		insertprofile.setString(2, login.getEmail());
		insertprofile.setString(3, login.getUsername());
		insertprofile.setString(4, login.getPassword());
		insertprofile.setString(5, login.getPassword());
		insertprofile.setString(6, login.getFirstName());
		insertprofile.setString(7, login.getLastName());
		

		
		int affectedRow = insertprofile.executeUpdate();

		if (affectedRow == 1) {

			int d =mem_logid;
			stage1(d);
			stage2(d);
			stage3(d);
			mem_logid =0;
			
			

		

			CA_FirstName.setText(null);
			CA_LastName.setText(null);
			CA_email.setText(null);
			CA_UserName.setText(null);
			CA_Password.setText(null);
			CA_Rpassword.setText(null);
			CA_status.setText("Your Submittion has been completed check your email!");
		
			//email sent
			String a,b,c;
			a=login.getEmail();
			b="Account Created";
			c= "Hello " + login.getFirstName() + " " + login.getLastName() +" Username: (" + login.getUsername() +") "+
					"\n\n We just like to inform you that your account has been successfully created."+
					"\n We just want to let you know that our email system well inform you of any  password reset, deletion or changes to your account information. "+
					 " \n We well not send any personal information such as any personal tax data that you have input in your system." +
					"\n Thank you for choosing FastTax and we hope you get a big refund this tax season" +
					 "\n\n Sincerely,"+ 
					" \n\n The FastTax Team";
			smtp.connect(a,b,c);
				System.out.println("Done");
			
	
			
		}

	} catch (Exception e) {
		CA_status.setText(" " + e.getMessage() + "please try again ");
		e.getMessage();
	//} finally {
		//if (keys != null) {
			//keys.close();
	//	}
	}
	
	

	}
public void stage1(int d){
	try{
	String query = "insert into stage1 (loginid) values("+d+")";
	Connection conn = DbConfig.getConnection();
	PreparedStatement st=  conn.prepareStatement(query);
	int result = st.executeUpdate();
	if (result == 1){
		System.out.println("Stage1 good");
	}
	}catch(Exception e) {
		System.out.println(e);
		
	}
}
public void stage2(int d){
	try{
	String query = "insert into stage2 (logid) values("+d+")";
	Connection conn = DbConfig.getConnection();
	PreparedStatement st=  conn.prepareStatement(query);
	int result = st.executeUpdate();
	if (result == 1){
		System.out.println("Stage2 good");
	}
	}catch(Exception e) {
		System.out.println(e);
		
	}
	
}
public void stage3(int d){
try{	

	String query = "insert into stage3 (LoginId) values("+d+")";
	Connection conn = DbConfig.getConnection();
	PreparedStatement st=  conn.prepareStatement(query);
	int result = st.executeUpdate();
	if (result == 1){
		System.out.println("Stage3 good");
	}
	}catch(Exception e) {
		System.out.println(e);
		
	}
}
private void geto() {
	String SQLQuery = "select mlname, lfirstname, llastname, ssn, birthday, address, city from stage1 where LoginId = ?";
	ResultSet rs = null;

	try(
			Connection conn = DbConfig.getConnection();
			PreparedStatement displayprofile = conn.prepareStatement(SQLQuery);
	){
		displayprofile.setInt(1, mem_logid);
		rs = displayprofile.executeQuery();

		// check to see if receiving any data
		if(rs.next()){
			project geto = new project();
			geto.setMname(rs.getString(1));
			geto.setFirstName(rs.getString(2));
			geto.setLastName(rs.getString(3));
			geto.setSSN(rs.getString(4));
			geto.setBirthday(rs.getString(5));
			geto.setAddress(rs.getString(6));
			geto.setCity(rs.getString(7));
			
			O_1.setText(geto.getMname());
			O_2.setText(geto.getFirstName());
			O_3.setText(geto.getLastName());
			O_4.setText(geto.getSSN());
			O_5.setText(geto.getBirthday());
			O_6.setText(geto.getAddress());
			
			O_7.setText(geto.getCity());
			
			
		//	O_1.setText("test");
			System.out.println("test" +geto.getFirstName());
			System.out.println("test"+geto.getBirthday());
			System.out.println(code_mem);
		
			
		}else{
			System.out.println("error");
		}
	}catch(SQLException ex){
		DbConfig.displayException(ex);
		
	
	}
}
private void gets() {
	String SQLQuery = "select s1,s2,s3,s4 from stage2 where LogId = ?";
	ResultSet rs = null;

	try(
			Connection conn = DbConfig.getConnection();
			PreparedStatement displayprofile = conn.prepareStatement(SQLQuery);
	){
		displayprofile.setInt(1, mem_logid);
		rs = displayprofile.executeQuery();

		// check to see if receiving any data
		if(rs.next()){
			project geto = new project();
			geto.setMname(rs.getString(1));
			geto.setFirstName(rs.getString(2));
			geto.setLastName(rs.getString(3));
			geto.setSSN(rs.getString(4));
			
		
			S_1.setText(geto.getMname());
			S_2.setText(geto.getFirstName());
			S_3.setText(geto.getLastName());
			S_4.setText(geto.getSSN());
			
			
		
		
			
		}else{
			System.out.println("error");
		}
	}catch(SQLException ex){
		DbConfig.displayException(ex);
		
	
	}
}
private void getf() {
	String SQLQuery = "select f1,f2,f3,f4,f5 from stage3 where LoginId = ?";
	ResultSet rs = null;

	try(
			Connection conn = DbConfig.getConnection();
			PreparedStatement displayprofile = conn.prepareStatement(SQLQuery);
	){
		displayprofile.setInt(1, mem_logid);
		rs = displayprofile.executeQuery();

		// check to see if receiving any data
		if(rs.next()){
			project geto = new project();
			geto.setMname(rs.getString(1));
			geto.setFirstName(rs.getString(2));
			geto.setLastName(rs.getString(3));
			geto.setSSN(rs.getString(4));
			geto.setCity(rs.getString(5));
			
		
			f_2.setText(geto.getFirstName());
			f_1.setText(geto.getMname());
			f_3.setText(geto.getLastName());
			f_4.setText(geto.getSSN());
			f_5.setText(geto.getCity());
			
			
		
		
			
		}else{
			System.out.println("error");
		}
	}catch(SQLException ex){
		DbConfig.displayException(ex);
		
	
	}
}
private void ro(){
String SQLQuery = "select mlname, lfirstname, llastname, ssn, birthday, address, city from stage1 where LoginId = ?";
ResultSet rs = null;

try(
		Connection conn = DbConfig.getConnection();
		PreparedStatement displayprofile = conn.prepareStatement(SQLQuery);
){
	displayprofile.setInt(1, mem_logid);
	rs = displayprofile.executeQuery();

	// check to see if receiving any data
	if(rs.next()){
		project geto = new project();
		geto.setMname(rs.getString(1));
		r1_mem = rs.getInt(1);
		geto.setFirstName(rs.getString(2));
		r2_mem = rs.getInt(2);
		geto.setLastName(rs.getString(3));
		r3_mem = rs.getInt(3);
		geto.setSSN(rs.getString(4));
		r4_mem = rs.getInt(4);
		geto.setBirthday(rs.getString(5));
		r5_mem = rs.getInt(5);
		geto.setAddress(rs.getString(6));
		geto.setCity(rs.getString(7));
		
		ro_1.setText(geto.getMname());
		ro_2.setText(geto.getFirstName());
		ro_3.setText(geto.getLastName());
		ro_4.setText(geto.getSSN());
		ro_5.setText(geto.getBirthday());
		ro_6.setText(geto.getAddress());
		
		ro_7.setText(geto.getCity());
		
		
			
	}else{
		System.out.println("error");
	}
}catch(SQLException ex){
	DbConfig.displayException(ex);
	

}}
private void rs() {
	String SQLQuery = "select s1,s2,s3,s4 from stage2 where LogId = ?";
	ResultSet rs = null;

	try(
			Connection conn = DbConfig.getConnection();
			PreparedStatement displayprofile = conn.prepareStatement(SQLQuery);
	){
		displayprofile.setInt(1, mem_logid);
		rs = displayprofile.executeQuery();

		// check to see if receiving any data
		if(rs.next()){
			project geto = new project();
			geto.setMname(rs.getString(1));
			s1_mem = rs.getInt(1);
			geto.setFirstName(rs.getString(2));
			s2_mem = rs.getInt(2);
			geto.setLastName(rs.getString(3));
			s3_mem = rs.getInt(3);
			geto.setSSN(rs.getString(4));
			s4_mem = rs.getInt(4);
			
		
			rs_1.setText(geto.getMname());
			rs_2.setText(geto.getFirstName());
			rs_3.setText(geto.getLastName());
			rs_4.setText(geto.getSSN());
			
			
		
		
			
		}else{
			System.out.println("error");
		}
	}catch(SQLException ex){
		DbConfig.displayException(ex);
		
	
	}
}
private void rf() {
	String SQLQuery = "select f1,f2,f3,f4,f5 from stage3 where LoginId = ?";
	ResultSet rs = null;

	try(
			Connection conn = DbConfig.getConnection();
			PreparedStatement displayprofile = conn.prepareStatement(SQLQuery);
	){
		displayprofile.setInt(1, mem_logid);
		rs = displayprofile.executeQuery();

		// check to see if receiving any data
		if(rs.next()){
			project geto = new project();
			geto.setMname(rs.getString(1));
			f1_mem=(rs.getInt(1));
			geto.setFirstName(rs.getString(2));
			f2_mem=(rs.getInt(2));
			geto.setLastName(rs.getString(3));
			f3_mem=(rs.getInt(3));
			geto.setSSN(rs.getString(4));
			f4_mem=(rs.getInt(4));
			geto.setCity(rs.getString(5));
			f5_mem=(rs.getInt(5));
		
			rf_2.setText(geto.getFirstName());
			rf_1.setText(geto.getMname());
			rf_3.setText(geto.getLastName());
			rf_4.setText(geto.getSSN());
			rf_5.setText(geto.getCity());
			
			
		
		
			
		}else{
			System.out.println("error");
		}
	}catch(SQLException ex){
		DbConfig.displayException(ex);
		
	
	}
	
}
private void result(){
	double a,a1,a2,a3;
	double b,b1, b2;
	double z, z1, z2;
	double y,y1;
	y = 3.40;
	y1 = 3.30;
	z = 3.5;
	z1 = 3.6;
	z2 = 3.4;
	if (s1_mem > 100000){
		z = 4.1;
		z1 = 4.4;
		z2 = 4.25;
	}else if (r1_mem >= 2){
		y = 4.9;
		y1 = 5.0;
	}
	double c,c1;
	double d1;
	a = (f1_mem - f2_mem) /6.20;
	b = f3_mem /6.30;
	a2 = f4_mem/y;
	b2 = f5_mem/y1;
	a3 = r5_mem/7.2;
	c = a+b;
	a1 = s2_mem/z;
	b1 = s3_mem/z1;
	d1 = s4_mem/z2;
	c1 = a1+b1+d1+a2+b2+a3+c;
	DecimalFormat twod = new DecimalFormat("#.##");
	rl_mes.setText("Your Refund is:");
	String s = String.valueOf(c1);
	rl_calc.setText("$"+twod.format(c1));
	
	System.out.println(c);
	System.out.println(c1);
	
}
}
