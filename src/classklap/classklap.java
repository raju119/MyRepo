/**
 * 
 */
package classklap;


import java.util.Scanner;


/**
 * @author raaajuu
 *
 */
public class classklap {

	/**
	 * @param args
	 */
	public static int size;
	public static boolean flag;
	public static classklap[] parkslots;
	
	public String number;
	public String color;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("same as everyone-- Hello world");
		
		while(sc.hasNextLine()){
			String input = sc.nextLine();
			String[] arr = input.split(" ");
			if(arr[0].contains("create")) {
				size = Integer.parseInt(arr[1]);
				parkslots = new classklap[size];		
				System.out.println("parking lot with "+size+" slots");
			}
			else if(arr[0].contains("park")){
				park(arr);
			}
			else if(arr[0].contains("leave")) {
				leave(Integer.parseInt(arr[1]));
			}
			else if(arr[0].contains("status")) {
				display();
			}
			else if(arr[0].contains("slot")) {
				if(arr[0].contains("color")) {
					findByColor(arr[1]);
				}
				else {
					findByNo(arr[1]);
				}
			}
			else if(arr[0].contains("registration") && arr[0].contains("color")) {
				findNumberByColor(arr[1]);
			}
			else {
				System.out.println("invalid input");
				System.exit(0);
			}
		}
	}
public static void park(String[] arr) {
		classklap ck = new classklap();
		ck.color = arr[2];
		ck.number = arr[1];
		flag = false;
		for(int i=0;i<size;i++) {
			if(parkslots[i] == null) {
				parkslots[i] = ck;
				System.out.println("Allocated slot number: "+(i+1));
				return;
			}
		}
		System.out.println("Sorry, parking lot is full");
}
public static void leave(int ind) {
	parkslots[ind-1] = null;
	System.out.println("Slot number "+ind+" is free");
}
public static void display() {
	System.out.println("Slot No. "+"Registration No"+"\t"+"color");
	for(int i=0;i<size;i++) {
		if(parkslots[i]!= null)
		System.out.println((i+1)+"\t"+parkslots[i].number+"\t"+parkslots[i].color);
	}
}
public static void findByColor(String color) {
	int c = 0;
	for(int i=0;i<size;i++) {
		if(!(parkslots[i] == null)) {
			if(parkslots[i].color.equals(color)) {
			if(c>0) { 
			System.out.print(c+", ");}
			c = i+1;
			}
		}
	}
	if(c>0)
		System.out.print(c);
	else {
		System.out.println("Not found");
	}
}
public static void findByNo(String number) {
	for(int i=0;i<size;i++) {
		if(!(parkslots[i] == null)) {
			if(parkslots[i].number.equals(number)) {
			System.out.print(parkslots[i].number);
			return;
			}
		}
	}
	System.out.println("Not found");
}
public static void findNumberByColor(String color) {
	String c = null;
	for(int i=0;i<size;i++) {
		if(!(parkslots[i] == null)) {
			if(parkslots[i].color.equals(color)) {
			if(c != null) { 
			System.out.print(c+", ");}
			c = parkslots[i].number;
			}
		}
	}//Codechef
	if(c != null)
		System.out.print(c);
	else {
		System.out.println("Not found");
	}
}
}