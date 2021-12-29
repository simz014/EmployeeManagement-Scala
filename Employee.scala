class Employee {
  var name=""
  var id=0
  var department=""
  def this(name:String, id:Int, department:String){
     this()
     this.name=name
     this.id=id
     this.department=department
  }
 override def toString():String={
     return this.name+": " + this.id+": " +this.department
 }
}
