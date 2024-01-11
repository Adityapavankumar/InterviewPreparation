### Scala Questions:

1. **Immutable Collections:**
   - Immutability in Scala means that once an object is created, its state cannot be changed. This ensures that the object is thread-safe and helps in writing more predictable and maintainable code.
   - Examples of immutable collections in Scala include `List`, `Set`, `Map`, and `Vector`.

2. **Pattern Matching:**
   - Pattern matching in Scala is a powerful feature that allows you to match values against patterns. It is similar to a switch statement in other languages but is more flexible.
   - Example:
     ```scala
     val day = "Monday"
     val result = day match {
       case "Monday" => "Start of the week"
       case "Friday" => "End of the week"
       case _ => "Other day"
     }
     ```

3. **Type System:**
   - Scala's type system helps catch errors at compile-time and provides better code readability. `val` declares an immutable variable, while `var` declares a mutable variable.

4. **Concurrency:**
   - Akka is a toolkit for building concurrent and distributed applications. It uses an actor-based model for concurrency.
   - `Future` represents a computation that might complete in the future, while `Promise` is a writable, single-assignment container for a value that may be assigned exactly once.

5. **Functional Programming:**
   - Functional programming in Scala emphasizes immutability, first-class functions, and expressions. Higher-order functions take functions as parameters or return them as results.
   - Example:
     ```scala
     def operateOnNumbers(numbers: List[Int], operation: Int => Int): List[Int] = {
       numbers.map(operation)
     }
     ```

### Spark Questions:

1. **RDDs (Resilient Distributed Datasets):**
   - RDD (Resilient Distributed Dataset) is the fundamental data structure of Spark, representing an immutable distributed collection of objects.
   - Spark achieves fault tolerance by tracking the lineage of transformations on RDDs, allowing the reconstruction of lost data.

2. **Spark Transformations and Actions:**
   - Transformations are operations that create a new RDD (e.g., `map`, `filter`), while actions perform computation and return a value to the driver program (e.g., `count`, `collect`).

3. **Spark SQL:**
   - Spark SQL is a Spark module for structured data processing. It provides a programming interface for data manipulation using SQL queries.
   - Example:
     ```scala
     val df = spark.read.json("path/to/json")
     df.createOrReplaceTempView("myTable")
     val result = spark.sql("SELECT * FROM myTable WHERE age > 21")
     ```

4. **Spark DataFrames:**
   - DataFrames in Spark are distributed collections of data organized into named columns. They provide a higher-level abstraction than RDDs.
   - DataFrames offer optimizations like Catalyst (query optimizer) and Tungsten (execution engine) for better performance.

5. **Spark Architecture:**
   - Spark has a master/worker architecture. The Driver runs the main function and creates SparkContext. Executors run on worker nodes and execute tasks.
   - The Driver sends tasks to Executors, and Executors return results to the Driver.

### Coding Exercises:

1. **Scala Basics:**
   - Factorial:
     ```scala
     def factorial(n: Int): Int = {
       if (n <= 1) 1
       else n * factorial(n - 1)
     }
     ```
   - Tail-recursive Fibonacci:
     ```scala
     def fibonacci(n: Int): Int = {
       @tailrec
       def fibHelper(a: Int, b: Int, n: Int): Int = {
         if (n == 0) a
         else fibHelper(b, a + b, n - 1)
       }
       fibHelper(0, 1, n)
     }
     ```

2. **Collections in Scala:**
   - Sum of squares of even numbers:
     ```scala
     def sumOfSquaresOfEvenNumbers(list: List[Int]): Int = {
       list.filter(_ % 2 == 0).map(x => x * x).sum
     }
     ```
   - Generic function to find the maximum element in a list:
     ```scala
     def findMax[T](list: List[T])(implicit ordering: Ordering[T]): T = {
       list.max
     }
     ```

3. **Spark RDD Transformation:**
   ```scala
   val numbersRDD = sc.parallelize(List(1, 2, 3, 4, 5))
   val resultRDD = numbersRDD.filter(_ % 2 == 0).map(x => x * x)
   ```

4. **Spark DataFrame Operations:**
   ```scala
   val df = spark.read.csv("path/to/csv/file")
   val filteredDF = df.filter("column_name > 10").groupBy("another_column").agg("yet_another_column" -> "sum")
   ```

5. **Advanced Spark:**
   - Reading from Kafka and processing:
     ```scala
     val df = spark.readStream.format("kafka").option("kafka.bootstrap.servers", "host:port").option("subscribe", "topic").load()
     // Perform processing on the DataFrame df
     ```
   - Broadcasting a variable:
     ```scala
     val broadcastVar = sc.broadcast(Array(1, 2, 3))
     val resultRDD = someRDD.map(x => x * broadcastVar.value(0))
     ```

Remember to adapt and test these solutions based on your specific requirements and data.
