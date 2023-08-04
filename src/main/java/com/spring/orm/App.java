// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Program started ");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
//        Student student = new Student();
//        student.setStudentId(1);
//        student.setStudentName("Durgesh Tiwari");
//        student.setStudentCity("Lucknow");
//        
//        int r = studentDao.insert(student);
//        System.out.println("inserted - " + r);
        Scanner input = new Scanner(System.in);
        boolean go = true;
        while(go) {
        	System.out.println("1......Add new Student............");
        	System.out.println("2......Get all students...........");
        	System.out.println("3......Get particular student.....");
        	System.out.println("4......Update a student...........");
        	System.out.println("5......Delete a student...........");
        	System.out.println("6........Exit.....................");
        	int choice = input.nextInt();
        	switch(choice) {
        		case 1: Student student = new Student();
        				System.out.println("Enter id : ");
        				int id = input.nextInt();
        				System.out.println("Enter name: ");
        				String name = input.next();
        				System.out.println("Enter city: ");
        				String city = input.next();
        				
        				student.setStudentId(id);
        				student.setStudentName(name);
        				student.setStudentCity(city);
        				
        				int r = studentDao.insert(student);
        				System.out.println("inserted - " + r);
        				break;
        		
        		 case 2: List<Student> students = studentDao.getAllStudents();
        		 		 for(Student student1 : students) {
        		 			 System.out.println(student1);
        		 		 }
        		 		 break;
        		 
        		 case 3: System.out.println("Enter student id : ");
        		 		 int studentId = input.nextInt();
        		 		 Student s = studentDao.getStudent(studentId);
        		 		 System.out.println(s);
        		 		 break;
        		 		 
        		 case 4: System.out.println("Enter student id : ");
        		 		 int sid = input.nextInt();
        			 	 System.out.println("Enter updated name: ");
        		 		 String sname = input.next();
        		 		 System.out.println("Enter updated city: ");
        		 		 String scity = input.next();
        		 		 Student s2 = new Student();
        		 		 s2.setStudentId(sid);
        		 		 s2.setStudentName(sname);
        		 		 s2.setStudentCity(scity);
        		 		 
        		 		 studentDao.updateStudent(s2);
        		 		 break;
        		 
        		 case 5: System.out.println("Enter student id : ");
		 		 		 int sid3 = input.nextInt();
		 		 		 studentDao.deleteStudent(sid3);
		 		 		 break;
		 		 		 
        		 case 6: go = false;
        		 		 break;
        	}
        }
        System.out.println("Thank you !, visit again");
    }
}
