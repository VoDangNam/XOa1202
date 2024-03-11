package Controller;
import java.util.ArrayList;
import Model.SVModel;
import View.SVView;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
public class SVController {
	private SVView view;
	private ArrayList<SVModel> listSV;
	private Scanner scanner = new Scanner(System.in);
	private boolean isExistingStudentId(int id) {//exception about existing student information
	    for (SVModel sinhvien : listSV) {
	        if (sinhvien.getId() == id) {
	            return true;
	        }
	    }
	    return false;
	}
	public SVController(SVView view) {
		listSV = new ArrayList<>();
		this.view=view;
	}
	public void start() {
        int choice;
        do {
        	view.displayMenu();
        	try {
        		choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if(choice == 1) {
                	addSinhVien();
                }else if(choice == 2) {
                	editSinhVien();
                }else if(choice == 3) {
                	deleteSinhVien();
                }else if(choice ==4) {
                	sortSinhVienByGPA();
                }else if(choice ==5) {
                	sortSinhVienByName();
                }else if(choice ==6) {
                	showDSSV();
                }else if(choice ==7) {
                	System.out.println("Chuong Trinh Ket Thuc!");
                	break;
                }
        	}catch (InputMismatchException e) {
                System.out.println("Gia tri nhap vao khong hop le!");
                choice = 0;
                scanner.nextLine(); // Consume invalid input
            }
        } while (choice != 7);
    }
	public void addSinhVien (){
		try {
			int id;
			do {
				System.out.print("Enter student ID: ");
		        id = scanner.nextInt();
		        scanner.nextLine(); // Consume newline character
		        if (isExistingStudentId(id)) {
		            System.out.println("Sinh vien voi Id: " + id + " da ton tai.");
		        }
			}while(isExistingStudentId(id));
	        System.out.print("Ten sinh vien: ");
	        String name = scanner.nextLine();
	        int age;
	        do {
	        	System.out.print("Tuoi sinh vien: ");
		        age = scanner.nextInt();
		        scanner.nextLine(); // Consume newline character
		        if (age <= 0) {
		            System.out.println("Tuoi khong hop le. Vui long nhap lai.");
		        }
	        }while(age<=0);
	        System.out.print("Dia chi cua sinh vien: ");
	        String address = scanner.nextLine();
	        double gpa;
	        do {
	        	System.out.print("Nhap diem GPA: ");
		        gpa = scanner.nextDouble();
		        if (gpa < 0 || gpa > 4) {
		            System.out.println("Diem GPA khong phu hop.Diem GPA: 0-> 4.");
		        }
	        }while(gpa < 0 || gpa > 4);
	    
	        SVModel sinhvien = new SVModel(id, name, age, address, gpa);
	        listSV.add(sinhvien);
	        System.out.println("Them sinh vien thanh cong.");
		}catch (InputMismatchException e) {
            System.out.println("Cac gia tri nhap vao khong hop le!");
            scanner.nextLine(); // Consume invalid input
        }
	}
	public void editSinhVien() {
		try {
			System.out.print("Nhap Id sinh vien muon chinh sua: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        
	        boolean found = false;
	        for (SVModel sinhvien : listSV) {
	            if (sinhvien.getId() == id) {
	    	        System.out.print("Ten sinh vien: ");
	                String name = scanner.nextLine();
	                sinhvien.setName(name);
	                int age;
	                do {
	                	System.out.print("Tuoi sinh vien: ");
		                age = scanner.nextInt();
		                scanner.nextLine(); // Consume newline character
		                sinhvien.setAge(age);
	    		        if (age <= 0) {
	    		            System.out.println("Tuoi khong hop le. Vui long nhap lai.");
	    		        }
	    	        }while(age<=0);

	                System.out.print("Dia chi cua sinh vien: ");
	                String address = scanner.nextLine();
	                sinhvien.setAddress(address);
	                double gpa;
	    	        do {
	    	        	System.out.print("Nhap diem GPA: ");
		                gpa = scanner.nextDouble();
		                sinhvien.setGpa(gpa);
	    		        if (gpa < 0 || gpa > 4) {
	    		            System.out.println("Diem GPA khong phu hop.Diem GPA: 0-> 4.");
	    		        }
	    	        }while(gpa < 0 || gpa > 4);	                

	                found = true;
	                System.out.println("Thong tin cua sinh vien voi id " + id + " da duoc chinh sua.");
	                break;
	            }
	        }
	        if (!found) {
	        	System.out.println("Sinh vien voi Id " + id + " khong tim thay.");
	        }
		}catch (InputMismatchException e) {
            System.out.println("Gia tri nhap vao khong hop le!");
            scanner.nextLine(); // Consume invalid input
        }
        
	}
	public void deleteSinhVien() {
		try {
			System.out.print("Nhap vao Id cua sinh vien ban muon xoa: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        boolean found = false;
	        for (SVModel sinhvien : listSV) {
	            if (sinhvien.getId() == id) {
	            	listSV.remove(sinhvien);
	                found = true;
	                System.out.println("Sinh vien voi ID " + id + " da duoc xoa.");
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("Sinh vien voi Id " + id + " khong tim thay.");
	        }
		}catch (InputMismatchException e) {
            System.out.println("Gia tri nhap vao khong hop le!");
            scanner.nextLine(); // Consume invalid input
        }
    }
	public void sortSinhVienByGPA() {
		Collections.sort(listSV, Comparator.comparingDouble(SVModel::getGpa));
		System.out.println("========================");
        System.out.println("Sinh vien duoc sap xep theo  GPA:");
        for (SVModel sinhvien : listSV) {
            updateView(sinhvien);
        }
	}

    public void sortSinhVienByName() {
        Collections.sort(listSV, Comparator.comparing(SVModel::getName));
        System.out.println("========================");
        System.out.println("Sinh vien duoc sap xep theo ten:");
        for (SVModel sinhvien : listSV) {
            updateView(sinhvien);
        }
    }
    public void updateView(SVModel sinhvien) {                  
        view.displaySVDetails(sinhvien.getId(),sinhvien.getName(),sinhvien.getAge(), sinhvien.getAdress(),sinhvien.getGpa());  
    }  
    public void showDSSV() {
    	view.displayDanhSachSinhVien(listSV);
    }
}
