package com.kevin.demo.business.democode

import kotlin.reflect.KProperty

/**
 * 范型、委托
 */
open class Animal<T>(t:T){
    var a=1
}
class Dog :Animal<Dog>(Dog()){
}
interface IAnimal<T>{}

fun <T> initAnimal(param:T){}

fun <T:Animal<T>> initAnimal2(param: T){}

interface Base{
    fun print()
}

class BaseImpl(val x:Int):Base{
    var p:String by Delegate()
    override fun print() {
        print("---$x")
    }
}
class Derived(b:Base):Base by b
class Delegate{
    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        return "$thisRef, 委托 ${property.name} ${thisRef.toString()} "
    }
    operator fun setValue(thisRef:Any?,property: KProperty<*>,value:String){
        println("-----$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

fun main() {
    // 范型
//    var a:Animal<String> = Animal<String>("1")
//    initAnimal2(Dog())

    //委托
    val b=BaseImpl(10)
    println(b.p)
    b.p="Runoob"
    println(b.p)
    Derived(b).apply {
        print()
    }
}