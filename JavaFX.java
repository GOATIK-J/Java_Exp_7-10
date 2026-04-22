import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{

    public void start(Stage s){

        Label l1=new Label("Name:");
        TextField t=new TextField();
        t.setPromptText("Enter name");

        Label l2=new Label("Marks:");
        TextField m=new TextField();
        m.setPromptText("Enter marks");

        Button b=new Button("Submit");
        Label out=new Label();

        b.setOnAction(e->{
            String name=t.getText();
            String marks=m.getText();
            if(name.isEmpty()||marks.isEmpty())
                out.setText("Fill all fields");
            else{
                try{
                    double val=Double.parseDouble(marks);
                    out.setText("Name: "+name+" Marks: "+val);
                }catch(Exception ex){
                    out.setText("Invalid marks");
                }
            }
        });

        GridPane g=new GridPane();
        g.setVgap(10);
        g.setHgap(10);

        g.add(l1,0,0);
        g.add(t,1,0);
        g.add(l2,0,1);
        g.add(m,1,1);
        g.add(b,1,2);
        g.add(out,1,3);

        Scene sc=new Scene(g,350,200);

        s.setTitle("Student Form");
        s.setScene(sc);
        s.show();
    }

    public static void main(String[] a){
        launch(a);
    }
}

