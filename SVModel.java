package Model;

public class SVModel {
	//khai báo kiểu dữ liệu của một sinh viên
	private int Id;
	private String Name;
	private int Age;
	private String Address;
	private double Gpa;
	/////////////////////////////////////////
	//dùng để truy cập và cập nhật các thông tin của sinh viên đối với các phạm vi private ở trên
	public int getId(){
		return Id;
	}
	public void setId(int Id) {
		this.Id=Id;
	}
	public String getName(){
		return Name;
	}
	public void setName(String Name) {
		this.Name=Name;
	}
	public int getAge(){
		return Age;
	}
	public void setAge(int Age) {
		this.Age=Age;
	}
	public String getAdress(){
		return Address;
	}
	public void setAddress(String Adress) {
		this.Address=Adress;
	}
	public double getGpa() {
		return Gpa;
	}
	public void setGpa(double Gpa) {
		this.Gpa=Gpa;
	}
	public SVModel() {
        
    }
	public SVModel(int Id, String Name, int Age, String Address, double Gpa) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.Address = Address;
        this.Gpa = Gpa;
    }
}
