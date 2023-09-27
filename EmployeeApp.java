import java.util.Scanner;

class Employee
{
	//instance variables are declared private
	private String firstName, lastName;
	private int employeeId;
	private double salary;

   	public Employee(){}; //default constructor

	public Employee(String last, String first){ //constructor for first and last name
		lastName = last;
		firstName = first;
	}

	//constructor for first name, last name, ID and salary
	public Employee(String last, String first, int id, double sal){

		lastName = last;
		firstName = first;
		employeeId = id;
		salary = sal;

	}

	//get and set methods
	public int getEmployeeId() {

		return employeeId;
    }
    public void setEmployeeId(int newId) {

		this.employeeId = newId;
    }

	public void getFirstName() {

		System.out.println("First name: " + firstName);
	}
	public void setFirstName(String newFN) {

		this.firstName = newFN;
	}

	public void getLastName() {

		System.out.println("Last name: " + lastName);
	}
	public void setLastName(String newLN) {

		this.lastName = newLN;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double newSal) {
		this.salary = newSal;
	}
   
	//toString() method declared to get the string representations of the objects created
	public String toString(){
		 return lastName + ", " + firstName + "\n" + "\t" + "ID: " + employeeId
					 						+ "\n" + "\t" + "Salary: " + salary
				 							+ "\n";
	}
   
	//equals() method declared to check if last name input matches the last name in the system
	public Boolean equals( String ln ){
		if ( lastName.equals(ln) ){
			return true;
		}
		else{
			return false; //if last name doesn't match, means there is no employee with said last name
		}
	}
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES]; //max number of employees in Employee[] array
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount = 0;

		//employee information already in system
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						//object created for new employee
						employees[empCount] = new Employee();
                
						//prompt user for employee information and set them
						System.out.println("Enter the first name of the employee: ");
						String inputFN = keyboard.nextLine();
						employees[empCount].setFirstName( inputFN );

						System.out.println("Enter the last name of the employee: ");
						String inputLN = keyboard.nextLine();
						employees[empCount].setLastName( inputLN );

						System.out.println("Enter the ID of the employee: ");
						int inputID = keyboard.nextInt();
						employees[empCount].setEmployeeId( inputID );

						System.out.println("Enter the salary of the employee: ");
						double inputSalary = keyboard.nextDouble();
						//if salary is negative, automatically set to 0
							if (inputSalary < 0 ){
								inputSalary = 0.0;
							}
							else{
								continue;
							}
						employees[empCount].setSalary( inputSalary ); //added employees' info set

						empCount++; //increment employee count
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.println( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						//verify that the employee entry has been allocated before editing
						if ( employees[lp] != null )
						{
							if (employees[lp].equals(inputString))
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] ); //print out employees' info
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' ); //if user does not quit program, loop again
	}  
}
