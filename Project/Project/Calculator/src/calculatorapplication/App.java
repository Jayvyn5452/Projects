// Javyn Fashanu, Bhavar Kanubhai Mistry and Pranav Pangil Cibi

package calculatorapplication;
// Imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
// import javafx.scene.paint.Color;
// import javafx.scene.paint.CycleMethod;
// import javafx.scene.paint.LinearGradient;
// import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application{
     // Creating Variables
    TextField taskbar = new TextField();
    long num1 =0;
    String input ="";
    boolean start = true;

    @Override
public void start(Stage primaryStage) throws Exception{
// Creating and formating textfield
taskbar.setFont(Font.font(20));
taskbar.setPrefHeight(50);
//JavaFx CSS for textfield
taskbar.setStyle("-fx-background-color: rgba(147,149,151, 0.4) ;-fx-text-fill: white;");
taskbar.setAlignment(Pos.CENTER_RIGHT);
taskbar.setEditable(false);

// Creating Stackpane
StackPane stackpane = new StackPane();
stackpane.setPadding(new Insets(10));
stackpane.getChildren().add(taskbar);

// Creating Buttons
TilePane keypad = new TilePane();
keypad.setHgap(10);
keypad.setVgap(10);
keypad.setAlignment(Pos.TOP_CENTER);
keypad.getChildren().addAll(
ButtonForNumber("7"),    
ButtonForNumber("8"),
ButtonForNumber("9"),
ButtonForOperators("/"),

ButtonForNumber("4"),    
ButtonForNumber("5"),
ButtonForNumber("6"),
ButtonForOperators("X"),

ButtonForNumber("1"),    
ButtonForNumber("2"),
ButtonForNumber("3"),
ButtonForOperators("-"),

ButtonForNumber("0"),    
ButtonForClear("C"),
ButtonForOperators("="),
ButtonForOperators("+")

);

// Creating BorderPane
BorderPane root = new BorderPane();
//Css for background
root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%,#758CFF , #CCFFFF);");
root.setTop(stackpane);
// Creating and adding Scence 
root.setCenter(keypad);
Scene scene = new Scene(root,250,325);
primaryStage.setScene(scene);
primaryStage.setTitle("Calculator");
primaryStage.setResizable(false);
primaryStage.show();


    }
// Adding event handlers
Button ButtonForNumber(String ch){
//Setting parameter inside the button obj
Button btn = new Button(ch);
btn.setFont(Font.font(18));
btn.setPrefSize(50, 50);
//JavaFx ButtonForNumber CSS
btn.setStyle("-fx-background-color: rgba(147,149,151, 0.4);-fx-text-fill: white;");
btn.setOnAction(this::processingNum);
return btn;

}
Button ButtonForOperators(String ch){
//Setting parameter inside the button obj
Button btn = new Button(ch);
//Font size
btn.setFont(Font.font(18));
btn.setPrefSize(50, 50);
//JavaFx ButtonForOperator CSS
btn.setStyle("-fx-background-color: rgba(147,149,151, 0.4);-fx-text-fill: white;");
btn.setOnAction(this::processingOperator);
return btn;
}
Button ButtonForClear(String ch){
    //Setting parameter inside the button obj
    Button btn = new Button(ch);
    btn.setFont(Font.font(18));
    //JavaFx ButtonForClear CSS 
    btn.setStyle("-fx-background-color: rgba(147,149,151, 0.4);-fx-text-fill: white;");
btn.setPrefSize(50, 50);
btn.setOnAction(e->{
taskbar.setText("");
input="";
start=true;
});
return btn;
}
public void processingNum(ActionEvent e){
if(start){
    taskbar.setText("");
    start=false;
}
String value=((Button)e.getSource()).getText();
taskbar.setText(taskbar.getText()+value);

}
// Adding Functionality to the Buttons
public void processingOperator(ActionEvent e){
String value=((Button)e.getSource()).getText();
if(!value.equals("=")){
if(!input.isEmpty())
return;
num1=Long.parseLong(taskbar.getText());
input=value;
taskbar.setText("");

}else{
if(input.isEmpty())
return;
double num2 = Double.parseDouble(taskbar.getText());
double result = calculate(num1,num2,input);
taskbar.setText(String.valueOf(result));
start=true;
input="";
}


}
// Calculator Methods
double calculate(long num1,long num2, String operator){
switch(operator){
    case "+": return num1+num2;
    case "-": return num1-num2;
    case "X": return num1*num2;
    case "/": 
if(num2==0)
return 0;
    return num1/num2;

    default: return  0.0;
}
}

double calculate(double num1, double num2, String operator){
    switch(operator){
        case "+": return num1+num2;
        case "-": return num1-num2;
        case "X": return num1*num2;
        case "/": 
    if(num2==0)
    return 0;
        return num1/num2;
    
        default: return 0;
    }
}
    public static void main (String[] args){
    launch(args);
}
}