
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