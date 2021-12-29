import java.util.Scanner
import javax.crypto.BadPaddingException

/**Bad Data
 *  -Negative ID
 *  -Wrong type of data(Int when it should be string)
 * -id >999
 *  -Department is not a department in our company
 * 
 * 
*/

object EmployeeManagement {
  def main(args:Array[String]):Unit={
      var count=0
      var arrEmp=new Array[Employee](5)
      var scanner = new Scanner(System.in)
      var departments = Set("IT", "HR", "SALES", "INSURANCE", "LEGAL", "MARKETING")
      //while loop to enter 5 employees
      while(count < 5){
          var badData=true
          var name=""
           print("Enter Employee " +(count+1) + " name: ")
           // For constraints on emp name. Throws BadDataEntryException if user
            // enters an empty string
          while(badData){
             badData=false
           try{
                 name= scanner.nextLine()
                 if(name ==""){
                     badData=true
                     throw new BadDataEntryException
                 }
                 } catch{
                     case bde: BadDataEntryException => println("Enter a valid name!")
                     case e: Exception              => println("Exception was thrown, try again ....")
                 }
                 }
             var id= -1
             badData=true
             // For constraints on emp id. Throws BadDataEntryException if user
            // enters an int < 1 or > 9999
             while(badData){
                 badData=false
            println("\n Enter ID " +(count+1) + " id: ")
            try{
                  id= scanner.nextInt()
                  scanner.nextLine()
                  if(id<=0 || id>=9999){
                      badData=true
                      throw new BadDataEntryException
                  }
            }catch{
                case bde: BadDataEntryException => println("Please enter a valid id (1-9999)")
                case e:   Exception              => println("Exception was thrown, try again ....")
            }
        }
           badData = true
            var department = ""
            // For constraints on emp department. Throws BadDataEntryException if user
            // enters a department that does nopt match our set of departments
            while (badData) {
                badData = false
                print("\nEnter Employee " + (count+1) + " department: ")
                try {
                    department = scanner.nextLine().toUpperCase()
                    if (!departments. (department)) {
                        badData = true
                        throw new BadDataEntryException
                    }
                } catch {
                    case bde: BadDataEntryException => println(department + " is not a department in our company! Enter a valid department")
                    case e: Exception => println("Exception thrown. Trying again..")
                }
            }

            arrEmp(count) = new Employee(name, id, department)
            // Increase count
            count += 1
        }
        arrEmp.foreach(println)
    }
}