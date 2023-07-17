import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MainStream {

	public static void main(String[] args)  {
		
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		//FileWriter fw = null;
		
		
		//BufferedOutputStream buf = null;
		
		
		//DataOutputStream dos = null;
		//DataInputStream dis = null;
		
		ObjectOutputStream ooo = null;
		ObjectInputStream oin = null;
		
		// TODO Auto-generated method stub
		try {
		//FileInputStream fins = new FileInputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\templates\\Ok_notes.txt");
		
		/*
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.length());
		System.out.println("File: "+ file.isFile());
		System.out.println("Hidden: "+ file.isHidden());
		System.out.println("Delete: "+ file.delete());
		*/
			
		/*
		int ch ;
		while((ch=fins.read())!=-1) {
			System.out.print((char)ch);
		}
		fins.close();
		*/
			
		/*	
		fos = new FileOutputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\templates\\Helio.txt", true);
		for (int i = 97;i<=122; i++)
			fos.write(i);
		fos.close();
		*/
		
			/*
			fw = new FileWriter("C:\\Users\\HTyagi\\Desktop\\Pikachu\\templates\\Helio1.txt");
			for (int i = 65;i<=90; i++)
				fw.write(i);
			fw.close();
			*/
			
			/*
			fos = new FileOutputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\templates\\Helio.txt", true);
			buf = new BufferedOutputStream(fos,25);
			
			for (int i = 65;i<=90; i++)
				buf.write(i);
			buf.close();
			fos.close();
			*/
		
			/*
			int i =420,i1;
			double d =625.225,d1;
			float f = 9999.26f,f1;
			long l = 984654165L,l1;
			
			fos = new FileOutputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\templates\\Helio.txt");
			fis = new FileInputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\templates\\Helio.txt");
			dos = new DataOutputStream(fos);
			dis = new DataInputStream(fis);
			
			dos.writeInt(i);
			dos.writeLong(l);
			dos.writeDouble(d);
			dos.writeFloat(f);
			
			i1 = dis.readInt();
			l1 = dis.readLong();
			d1 = dis.readDouble();
			f1 = dis.readFloat();
			
			System.out.println(i1+"\n"+l1+"\n"+d1+"\n"+f1);
			
			
			dos.close();
			fos.close();
			*/
			// serialization
			fos = new FileOutputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\IOStreamsDemo\\src\\emp.dat");
			fis = new FileInputStream("C:\\Users\\HTyagi\\Desktop\\Pikachu\\IOStreamsDemo\\src\\emp.dat");
			ooo = new ObjectOutputStream(fos);
			oin = new ObjectInputStream(fis);
			
			Employee e1 = new Employee(101, 62500, "Ajay Saxena", LocalDate.of(2001, 1, 30));
			
			ooo.writeObject(e1);
			
			Employee e2 = (Employee)oin.readObject();
			
			System.out.println("Employee ID: "+ e2.getE_id());
			System.out.println("Employee Name: "+ e2.getEname());
			System.out.println("Employee Salary: "+ e2.getSalary());
			System.out.println("Employee DOB: "+ e2.getDob());
			
			
			
			System.out.println("ok");
		}catch(IOException | ClassNotFoundException e) {
			System.out.println(e + " File not found");
		}
		
		
	}

}
