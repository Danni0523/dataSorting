import model.Model;
import view.View;
import controller.Controller;

public class App {
    public static void main(String[] args){
        Model m = new Model("You have not selected a file", "You have not selected a file", "Please select a file to view its contents and organize it.");
        View v = new View("Data Sorting");
        Controller c = new Controller(m,v);
        c.initController();
    }
}