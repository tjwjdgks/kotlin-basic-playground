import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.math.BigDecimal

// basic syntax
fun funExample(a : Int, b:Int): Int{
    // $변수로 값 표현 가능
    println("$a + $b = ${a+b}")
    // 이것도 가능
    fun basicFun2(a: Int, b:Int) = a+b
    println(basicFun2(3,4));
    return a+b
}
// Unit 은 java void 개념
// Unit type은 kotlin.unit single value를 가지고 있음
fun variable() : Unit {
    // 변수 설정
    // val read only
    val a : Int = 1
    val b = 2
    val c : Int
    c = 3
    // var reassign
    var x = 5
    x +=1
    println(c);

}
fun classex (){
    // class
    val rectangle = Rectangle(5.0,2.0)
    println("This perimter is ${rectangle.perimeter}")
}
fun forWhileex() {
    // for ans
    val items = listOf("apple","banna");
    for(item in items) println(item)
    // or
    for (index in items.indices){
        println("item at $index is ${items[index]}")
    }
    // while
    var index = 0
    while(index < items.size){
        println("item at ${index} is ${items[index]}")
        index++
    }
}
fun whenex(){
    // when <-> switch
    // any 아무거나, is 문법 type
    fun describe (obj : Any) : String =
        when (obj) {
            1 -> "One"
            "hello" -> "greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "unknown"
        }
    println(describe(1L));
}

// range using "in"
fun rangeex(){
    val x = 10
    val y = 9

    if (x in 1..y+1){
        println("fits in range")
    }
    val list = listOf("a","b","c")
    if(-1 !in 0..list.lastIndex){
        println("not in index")
    }
    if(list.size !in list.indices){
        println("n is not range")
    }
    // progression
    // step +2
    for(x in 1..10 step 2){
        println(x);
    }
    // step -(downTo)3
    for(x in 9 downTo 0 step 3){
        println(x);
    }
}
// collections
fun collectionsBasic(){
    val item = listOf("test","apple")
    for(i in item){
        println(i)
    }
    when {
        "apple" in item -> println("juicy")
    }
    // 내부에서 it 으로 받을 수 있음
    item
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

// ? null return 가능
fun nullCheck(str : String): Int?{
    return null
}

// string template
fun stringTemplateEx() {
    var a = 1
    val s1 = "a is $a"
    println(s1)
    a = 2
    val s2 = "${s1.replace("is","was")}, but now is $a"
    println(s2)
}
fun typeCheckEx(obj: Any) : Int? {
    if(obj is String) return obj.length
    return null
}
// create dto
// var mutable val immutable
// 내부적으로 getter, setter를 사용함, 변수 private이다. 단 코틀린은 단순히 참조하는 것처럼 보이게 함
// data Type, getter,setter, equals, hashCode, toString, copy 등 자동생성
data class Customer(var name: String, val email: String)

// default values for function parameters
fun foo(a: Int =0, b: String="") : Unit {

}

fun filterex(){
    val arr = intArrayOf(1,2,3,4,5)
    val positives1 = arr.filter { x-> x>0 }
    val positives2 = arr.filter { it >0 }
}

// check presence of a element
fun isPresence(){
    val arr = listOf("tt")
    if("ho" in arr){

    }
    if("ho" !in arr){

    }
}
// string interpolation
fun sinterpol(){
    val name = "tet"
    println("name $name")
}
// instance check
fun instanceCheck(any: Any) : Int {
    var test = 0;
    test = when(any){
        is Shape -> 1
        is Rectangle -> 2
        is Int -> 0
        else -> 3
    }
    return test
}
// read-oney list, map
fun readOnly(){
    val list = listOf("a","b","c")
    val map = mapOf("a" to 1, "b" to 2)
    // access map entry
    println(map["a"])
    // traverse map list pair
    for((k,v) in map){
        println("$k -> $v")
    }
}

// lazy property
fun lazyP(){
    val p : String by lazy { // the value is computed only on first access
        "test"
    }
}
// create a singleton
// 코틀린에서 object 키워드는 싱글톤 object로 define 한다는 것
object Resource {
    val name = "Name"
}

// instantiate an abstract class
abstract class MyAbstaractClass{
    abstract fun doSomething();
    abstract fun sleep()
}
fun abstractEx(){
    val myObject = object : MyAbstaractClass(){
        override fun doSomething() {
            TODO("Not yet implemented")
        }

        override fun sleep() {
            TODO("Not yet implemented")
        }
    }
}
// if not null, if not null else
fun ifNotNullEx(){
    val test = arrayOf("s");
    println(test?.size)
    val test2 = typeCheckEx(1L)
    println(test2?.toString() ?: "empty") // if test2 is null, print "empty"
    val test3 = test2?.toString() ?: run{ // to calculate the fallback value in a code block, use 'run'
        "test"
    }

}
// execute if null
fun executeIfNull(){
    val values = mapOf("s" to 1)
    val email = values["email"] ?: throw IllegalStateException("email is missing")
}

// get first item of a possible empty collection
fun firstItemEmptyCollection(){
    val emails = emptyArray<String>()
    val mainEmail = emails.firstOrNull() ?: "null";
}
// execute is not null
fun executeNotNull(){
    val value = emptyArray<String>()
    value?.let {
        println(it) // execute this block if not null
    }
    val m = typeCheckEx("test")
    val mapped = m?.let { it } ?: "default_value" // defaultValue is returned if the value or transform result is null
}
// return on when statement
fun transform(color: String): Int{
    return when(color) {
        "Red" -> 0
        "Green" -> 1
        else -> throw IllegalArgumentException("invalid color")
    }
}
// try-catch expression
fun testTryCatch(){
    val result = try{
        transform("test")
    }catch (e: IllegalArgumentException){
        throw Exception("no")
    }
}
// if expression
fun ifExpression(){
    val x = 1
    val y = if(x==1){
        "one"
    } else if (x==2){
        "two"
    } else {
        "other"
    }
}
// Builder-style usage of methods that return unit
fun arrayOfMinusOnes(size :Int) : IntArray {
    return IntArray(size).apply { fill(-1) }
}
// single-expression functions
fun theAnswer() = 42
// == equal
fun theAnswerEq() : Int{
    return 42
}
// when expression is useful for single-expression
fun transformSingle(color: String) : Int = when(color){
    "Red" -> 0
    "Blue" -> 1
    else -> throw IllegalArgumentException("no")
}

// call mulitple mothods on an object instance with
class Turtle {
    fun penDown(){

    }
    fun penUp(){

    }
    fun turn(degrees: Double){

    }
    fun forward(pixels: Double){

    }
}
fun TurtleEx(){
    val myTurtle = Turtle()
    with(myTurtle) { //draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
}

// configure properties of an object
fun rectangleApply(){
    val myRectangle2  = Rectangle(1.0,2.0).apply {
        height = 2.0
        length = 3.0
    }
}}


/**
 * Generic function that requires the generic type information
 *   public final class Gson {
 *      ...
 *      public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
 *      ...
 *  inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)
 */

// swap two variable
fun swapEx(){
    var a = 1
    var b = 2
    a = b.also { b = a }
}

// mar code as incomplete (TODO)
// Kotlin's standard library has a TODO() function
// that will always throw a NotImplementedError.
//  Its return type is Nothing so it can be used regardless of expected type.
//  There's also an overload that accepts a reason parameter:
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")



fun main(args: Array<String>) {
    println("hello world")
    println(funExample(1,2));

    // short fun if 가능
    fun maxOf(a: Int, b:Int) = if(a>b) a else b
    rangeex()
    collectionsBasic()
    stringTemplateEx()
    var test = listOf("test");
    test += "ed"
    // 중괄호이다 소괄호 아님
    test.forEach {
        println(it)
    };
    println(typeCheckEx("test"))
    var testDto = Customer("test","test")
    println(instanceCheck(1))
    readOnly()
}