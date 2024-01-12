// Didn't execute any of this, just asked for response one by one
object JDoodle {
  //----------1
  def f1:Option[Int] = {println("1"); None}
  def f2:Option[Int] = {println("2"); Some(2)}
  def f3:Option[Int] = {println("3"); Some(3)}
  f1 orElse f2 orElse f3
  val f1val = f1
  val f2val = f2
  val f3val = f3
  if(f1.isNotEmpty){
      
  }
  //----------2
def func(b: Boolean, i: => Int) =
  if ( b ) {
    i + i
  } else 0
val d = func(true, { println("hi"); 1+41 })
println(d)
// 84

  //----------3
// list of numbers
// get second largest element from list
val lst = List(1,2,3,4,5,6)

var lstMax = 0
for(num <- lst){
    if(num > lstMax){
        lstMax = num
    }
}

var secondLargest = 0
for(num<-lst){
    if((num>secondLargest) && (num<lstMax)){
        secondLargest = num
    }
}

println(secondLargest)

  //----------4
def expr = {
 
    val x = {print("x"); 1}
 
    lazy val y = {print("y"); 2}
 
    def z = {print("z"); 3}
 
    z + y + x + z + y + x
 
  }
 
  expr


// zyxzyx

}
