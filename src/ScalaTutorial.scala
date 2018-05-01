import scala.io.StdIn.{readLine, readInt}
import scala.collection.mutable.ArrayBuffer
import scala.math._

/**
 * http://www.newthinktank.com/2015/08/learn-scala-one-video/
 */
object ScalaTutorial {
  def main(args: Array[String]) {
    var i = 0
    val randLetters = "ABCDEFG"
    for (i <- 0 until randLetters.length())
      println(randLetters(i))
    println(randLetters.toArray)
    
    val aList = List(1,2,3,4,5,6)
    for (i <- aList)
      println(i)
    
    var evenList = for { i <- 1 to 20
      if (i % 2) == 0
      } yield i
      
    println(evenList)
      
      
    for (i <- 1 to 5; j <- 6 to 10) {
      println(i,j)
    }
      
    /**
     * 
     */
    def printPrimes() {
      val primeList = List(1,2,3,5,7,11)
      for (i <- primeList) {
        if (i == 11)
          return
        if (i != 1)
          println(i)
      }
    }
    
    printPrimes()
    /**
     * Input, output

    
    var numberGuess = 0
    do {
      print("Guess a number ")
      numberGuess = readLine.toInt
    } while(numberGuess != 15)
      
    println("You guessed the secret number!");
     */
    
    
    // Format output: use prefix s
    val name = "Thong"
    val age = 40
    val weight = 140.5
    println(s"Hello $name! You are $age y.o. and weight $weight%.2f")
    // Left justified
    printf("'%5d'\n", 5)
    // right-justified
    printf("'%-5d'\n", 5)

    // toArray
    for(c <- "Hello".toArray)
      println(c)
      
    // http://www.newthinktank.com/2015/08/learn-scala-one-video/
    
    // You can give parameters default values
    def getSum( num1:Int = 1, num2:Int = 1) : Int = {
      num1 + num2  
    }
    def getSum2(args: Int*) : Int = {
      var sum : Int = 0
      for (num <- args) {
        sum += num
      }
      sum
    }
    println("5 + 4 = " + getSum(5,4))
    println("5 + 4 + 3 = " + getSum2(5,4, 3))

    // Recursion example calculating factorials
    def factorial(num : BigInt) : BigInt = {
      if (num <= 1)
        1
      else
        num * factorial(num - 1)
    }
    println("5! = " + factorial(5))
    
    // A function that returns nothing (Procedure)
    def sayHi() : Unit = {
      println("Hi how are you doing")
    }
    
    // ---------- ARRAYS ----------
    // You'll use arrays when the size is fixed, or an ArrayBuffer for a
    // variable size
     
    // Create an array of Ints with a max size of 20
    val favNums = new Array[Int](20)
    
    // Create and initialize array in 1 line
    val friends = Array("Bob", "Tom")
     
    // Change the value in an array
    friends(0) = "Sue"
     
    println("Best Friend " + friends(0))
     
    // Create an ArrayBuffer
    val friends2 = ArrayBuffer[String]()
     
    // Add an item to the 1st index
    friends2.insert(0, "Phil")
     
    // Add item to the next available slot
    friends2 += "Mark"
     
    // Add multiple values to the next available slot
    friends2 ++= Array("Susy", "Paul")
     
    // Add items starting at 2nd slot
    friends2.insert(1, "Mike", "Sally", "Sam", "Mary", "Sue")
     
    // Remove the 2nd element
    friends2.remove(1)
     
    // Remove 2 elements starting at the 2nd index
    friends2.remove(1, 2)
     
    // Cycle through and print ArrayList or Array
    for(friend <- friends2)
          println(friend)
          
    // Add values to an array with a loop
    for (j <- 0 to (favNums.length - 1)){
      favNums(j) = j
      println(favNums(j))
    }
    
    println("Sum : " + favNums.sum)
     
    println("Min : " + favNums.min)
     
    println("Max : " + favNums.max)
 
    // Use yield to multiply all values times 2 and store in a new array
    val favNumsTimes2 = for(num <- favNums) yield 2 * num
 
    // Another way to print out values in array
    favNumsTimes2.foreach(println)
    
    // You can also store values that match a condition
    var favNumsDiv4 = for(num <- favNums if num % 4 == 0) yield num
    favNumsDiv4.foreach(println)

    // Create a multidimensional array with Array.ofDim
    var multTable = Array.ofDim[Int](10,10)
     
    for(i <- 0 to 9){
      for(j <- 0 to 9){
        multTable(i)(j) = i * j
      }
    }
     
    for(i <- 0 to 9){
      for(j <- 0 to 9){
        printf("%d : %d = %d\n", i, j, multTable(i)(j))
      }
    }
    
    // Sort in desending order (Use < for assending)
    val sortedNums = favNums.sortWith(_ > _)
     
    // Return an indexed sequence and convert it into a string with commas
    println(sortedNums.deep.mkString(", "))
    
    // ---------- MAPS ----------
    // Maps are collections of key value pairs
     
    // Create a Map that can't be changed (Immutable)
    val employees = Map("Manager" -> "Bob Smith", "Secretary" -> "Sue Brown")
     
    // Get value using the key after checking that it exists
    if(employees.contains("Manager"))
      printf("Manager : %s\n", employees("Manager"))
     
    // Create a Mutable map
    val customers = collection.mutable.Map(100 -> "Paul Smith",
      101 -> "Sally Smith")
     
    printf("Cust 1 : %s\n", customers(100))
     
    // Change a value using the key
    customers(100) = "Tom Marks"
     
    // Add an item
    customers(102) = "Megan Swift"
     
    // Output a Map
    for((k,v) <- customers)
      printf("%d : %s\n", k, v)
     
    
    // ---------- TUPLES ----------
    // Tuples can hold values of many types, but they are immutable
     
    var tupleMarge = (103, "Marge Simpson", 10.25)
     
    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)
     
    // Iterate through a tuple
    tupleMarge.productIterator.foreach{ i => println(i)}
     
    // Convert Tuple to String
    println(tupleMarge.toString())
    
    
    // ---------- CLASSES ----------
    val rover = new Animal
    rover.setName("Rover")
    rover.setSound("Woof")
    printf("%s says %s\n", rover.getName, rover.getSound)
     
    val whiskers = new Animal("Whiskers", "Meow")
    println(s"${whiskers.getName} with id ${whiskers.id} says ${whiskers.getSound}")
     
    println(whiskers.toString)
    
    val spike = new Dog("Spike", "Woof", "Grrrr")
     
    spike.setName("Spike")
    println(spike.toString)
   
 
    val fang = new Wolf("Fang")
    fang.moveSpeed =36.0
    println(fang.move)
    
    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(2500))
    
    // Higher order functions: function can be passed as variable
    val log10Func = log10 _
    print(log10Func(1000))
    
    List(100.0, 1000.0).map(log10Func).foreach(println)
    
    
  }
  // ---------- INHERITANCE ----------
  // A class that inherits from another gains all its fields and methods
  // A class declared final can't be extended
  class Dog (name : String, sound : String, growl : String) 
  extends Animal(name, sound){
   
    def this (name : String, sound : String){
      this("No Name", sound, "No Growl")
      this.setName(name)
    }
   
    def this (name : String){
      this("No Name", "No Sound", "No Growl")
      this.setName(name)
    }
   
    def this (){
      this("No Name", "No Sound", "No Growl")
    }
   
    // You can override any other method
    override def toString() : String = {
      return "%s with the id %d says %s or %s".format(
        this.name, this.id, this.sound, this.growl)
    }
  }
  // ---------- CLASSES ----------
  // Classes are used as blueprints to create objects
  // Objects define the attributes (fields) and capabilities (methods) of an
  // object
  class Animal(var name: String, var sound: String) {
    this.setName(name)
    this.setSound(sound)
    // This function is defined in the Animal companion object below
    val id = Animal.newIdNum
    
    def getName(): String = name
    def getSound(): String = sound
    def setName(name: String) {
      if (!name.matches(".*\\d+.*")) // doesn't contain any number
        this.name = name
      else
        this.name = "No Name"
    }
    def setSound(sound: String) {
      this.sound = sound
    }
    
    def this(name: String) {
      this(name, "No Sound")
    }
    
    def this() {
      this("No Name", "No Sound")
    }
    
    override def toString(): String = {
      return "%s with the id %d says %s".format(this.name, this.id, this.sound)
    }
  }
 // The companion object for a class is where you'd define static class
  // variables and functions in Java
  object Animal {
    private var idNumber = 0
    private def newIdNum = { idNumber += 1; idNumber }
  }
  
  // abstract class 
  abstract class Mammal(val name: String) {
    var moveSpeed : Double
    def move: String
  }
  
  class Wolf(name: String) extends Mammal(name) {
    var moveSpeed = 35.0
    def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
  }
  
  // trait is like interface but it can provide concrete class (diff java)
  trait Flyable {
    def fly : String
  }
  
  trait BulletProof {
    def hitByBullet : String
    def ricochet(startSpeed : Double) : String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
    }
  }
  
  class Superhero(val name: String) extends Flyable with BulletProof {
    def fly = "%s flies thru the air".format(name)
    def hitByBullet = "The bullet bounces off of %s".format(name)
  }
}