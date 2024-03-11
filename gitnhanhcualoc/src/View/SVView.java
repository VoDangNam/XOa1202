package View;
import java.util.List;
import Model.SVModel;

public class SVView {
	public void displaySVDetails(int Id,String Name,int Age, String Adress,double Gpa) {
		System.out.println("Thong tin SV:");
		System.out.println("Id:"+Id);
		System.out.println("Name:"+Name);
		System.out.println("Age:"+Age);
		System.out.println("Adress:"+Adress);
		System.out.println("Gpa:"+Gpa);
	}
	public void displayMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Edit student by id");
        System.out.println("3. Delete student by id");
        System.out.println("4. Sort students by GPA");
        System.out.println("5. Sort students by name");
        System.out.println("6. Show students");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        System.out.println("========================");
    }
	public void displayDanhSachSinhVien(List<SVModel> listSV) {
        if (listSV.isEmpty()) {
            System.out.println("No students to display.");
        } else {
        	System.out.println("========================");
            System.out.println("Student list:");
            for (SVModel sinhvien : listSV) {
            	displaySVDetails(sinhvien.getId(),sinhvien.getName(),sinhvien.getAge(), sinhvien.getAdress(),sinhvien.getGpa());
            }
        }
    }
}
