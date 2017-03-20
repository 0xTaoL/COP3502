//Name: Tao Ling
//UFL ID: tao.ling
//Section: 5994
//Project Number: 2
//Brief description of file contents: Shape Machine

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShapeMachine {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Shape Machine login\n\n");
		
		//Verifies date with user input date as the password
		int i = 1;
		while(i<4){
			System.out.print("What is today's day? ");
			String dd = input.next();
			System.out.print("What is today's month? ");
			String MM = input.next();
			System.out.print("What is today's year? ");
			String yyyy = input.next();
			String date = new SimpleDateFormat("dd-MM-yyyy").
					format(new Date());
			String inputdate = dd + "-" + MM + "-" +yyyy;
			if(date.equals(inputdate)){
			System.out.print("Correct date. Welcome!");
			break;
			}
			else{
				if(i<3){
					System.out.print("#ERROR Login attempt #" + i + " Invalid "
							+ "input. Please try again.\n");
					i++;
				}
				else{
					System.out.print("#ERROR 3rd invalid login attempt. "
							+ "Terminating program.");
					System.exit(0);
				}
			}
		}
		
		//Actual program
		while(true){
		System.out.print("\n---Welcome to the Shape Machine---\nAvailable "
				+ "Options:\nCircles\nRectangles\nTriangles\nExit\n");
			String shape =input.next();
			
			//Generates Circles option
			if(shape.equals("Circles")){
				System.out.print("Circles selected. "
						+ "Please enter the radius: ");
				double radius = input.nextDouble();
				while(radius < 0){
					System.out.print("#ERROR Negative input. "
							+ "Please input the radius again: ");
					radius = input.nextDouble();
				}
				double circumference = 2*Math.PI*radius;
				double circleArea = Math.PI*radius*radius;
				System.out.println("The circumference is: " + circumference);
				System.out.println("The area is: " + circleArea);
				String circumferenceDigits = Double.toString(circumference);
				String circleAreaDigits = Double.toString(circleArea);
				System.out.println("Total number of digits in the circumference"
						+ " is: " + (circumferenceDigits.length() - 1));
				System.out.print("Total number of digits in the area is: " + 
						(circleAreaDigits.length() - 1));
			}
			
			//generates rectangles option
			if(shape.equals("Rectangles")){
				System.out.print("Rectangles selected. Please enter the"
						+ " 2 sides: ");
				double rectangleSide1 = input.nextDouble();
				double rectangleSide2 = input.nextDouble();
				while((rectangleSide1 < 0) || (rectangleSide2 < 0)){
					System.out.print("#ERROR Negative input. Please input the "
							+ "2 sides again: ");
					rectangleSide1 = input.nextDouble();
					rectangleSide2 = input.nextDouble();
				}
				double rectangleArea = rectangleSide1 * rectangleSide2;
				double rectanglePerimeter = rectangleSide1 * 2 + 
						rectangleSide2 *2;
				System.out.println("The area is: " + rectangleArea);
				System.out.println("The perimeter is: " + rectanglePerimeter);
				String recAreaDigits = Double.toString(rectangleArea);
				String recPeriDigits = Double.toString(rectanglePerimeter);
				System.out.println("Total number of digits in the area is: " + 
						(recAreaDigits.length() - 1));
				System.out.print("Total number of digits in the perimeter is: "
						+ (recPeriDigits.length() - 1));
			}
			
			//generates triangles option
			if(shape.equals("Triangles")){
				System.out.print("Triangles selected. Please enter the "
						+ "3 sides: ");
				double triangleSide1 = input.nextDouble();
				double triangleSide2 = input.nextDouble();
				double triangleSide3 = input.nextDouble();
				while((triangleSide1 < 0) || (triangleSide2 < 0) 
						|| (triangleSide3 < 0)){
					System.out.print("#ERROR Negative input. "
							+ "Please input the 3 sides again: ");
					triangleSide1 = input.nextDouble();
					triangleSide2 = input.nextDouble();
					triangleSide3 = input.nextDouble();
				}
				if(!((triangleSide1 + triangleSide2) > triangleSide3) 
						|| !((triangleSide2 + triangleSide3) > triangleSide1) 
						|| !((triangleSide1 + triangleSide3) > triangleSide2)){
					System.out.print("#ERROR Triangle is not valid. "
							+ "Returning to menu.");
					continue;
				}
				
				String triangleType = null;
				if((triangleSide1 == triangleSide2) 
						&& (triangleSide2 == triangleSide3) 
						&& (triangleSide3 == triangleSide1)){
					triangleType = "Equilateral";
				}
				else if((triangleSide1 != triangleSide2) 
						&& (triangleSide2 != triangleSide3) 
						&& (triangleSide3 != triangleSide1)){
					triangleType = "Scalene";
				}
				else{
					triangleType = "Isosceles";
				}
				
				double trianglePeri = triangleSide1 + triangleSide2 
						+ triangleSide3;
				double triHalfPeri = trianglePeri/2;
				double triangleArea = Math.sqrt((triHalfPeri)
						*(triHalfPeri-triangleSide1)
						*(triHalfPeri-triangleSide2)
						*(triHalfPeri-triangleSide3));
				System.out.println("The triangle is: " + triangleType);
				System.out.println("The perimeter is: " + trianglePeri);
				System.out.println("The area is: " + triangleArea);
				String triAreaDigits = Double.toString(triangleArea);
				String triPeriDigits = Double.toString(trianglePeri);
				System.out.println("Total number of digits in the perimeter "
						+ "is: " + (triPeriDigits.length() - 1));
				System.out.print("Total number of digits in the area "
						+ "is: " + (triAreaDigits.length() - 1));

			}
			
			if(shape.equals("Exit")){
				break;
			}
			
			if(!shape.equals("Exit") && !shape.equals("Triangles") 
					&& !shape.equals("Rectangles") 
					&& !shape.equals("Circles")){
				System.out.print("\n#ERROR Invalid option. Please try again.");
			}
				
		}
		System.out.print("\nTerminating the program. Have a nice day!");
		System.exit(0);
	}

}