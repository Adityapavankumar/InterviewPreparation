// this interview was mostly on scala functional programming
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object Main {
  def main(args: Array[String]): Unit = {
    implicit val ec = ExecutionContext
    println("Hello world!")
    val lstInt = List.empty[Int]
    //val sumOfList = greet(addList(lstInt))
    val sumOfL = for {
      sum <- addList(lstInt)
    } yield {
      greet(sum)
      sum
    }
    sumOfL.onComplete{
      case Success(x) => println(x)
      case Failure(e) => println(e)
    }
    println("Good night!")
  }
  def addList(lstInt:List[Int]): Future[Int] = {
    Future {
      lstInt.fold(0)((a, b) => a + b)
    }
  }

  def greet(s: Int) = Some{
    s match {
      case 0 => println("Good morning")
      case _ => println("Good evening")
    }
  }
}
