package Main;
import Controller.SVController;
import View.SVView;
public class SVMain{
    public static void main(String[] args) {
    	SVView view= new SVView();
    	SVController sinhVienController = new SVController(view);
    	sinhVienController.start();
    }
}