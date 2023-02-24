
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
fun main(args: Array<String>) {
    println("hello world")
    println(funExample(1,2));

    // short fun if 가능
    fun maxOf(a: Int, b:Int) = if(a>b) a else b
    rangeex()
    collectionsBasic()
}