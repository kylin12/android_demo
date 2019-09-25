package com.kevin.demo.common.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.lang.Exception
import java.util.*

object AppManager {
    private var mActivitys: Stack<Activity> = Stack()

    fun add(activity: Activity) {
        mActivitys.add(activity)
    }

    fun remove(activity: Activity){
        mActivitys.remove(activity)
    }

    fun currentActivity():Activity{
        return mActivitys.lastElement()
    }

    fun finishActivity(){
        val a= mActivitys.lastElement()
        a.finish()
    }

    fun finishActivity(activity: Activity?){
        var index =-1
        for(i in mActivitys.indices){
            val a= mActivitys[i]
            if(a==activity){
                index= i
                break
            }
        }
        if(index!=-1){
            mActivitys.removeAt(index)
            activity?.finish()
        }
    }

    fun finishActivity(cls:Class<*>){
        for(i in mActivitys.indices){
            val a = mActivitys[i]
            if(a.javaClass.canonicalName == cls.canonicalName){
                mActivitys.removeAt(i)
                a.finish()
                break
            }
        }
    }

    fun isLive(activity: Activity):Boolean{
        return mActivitys.contains(activity)
    }

    fun isLive(cls:Class<*>):Boolean{
        mActivitys.forEach{
            if(it.javaClass.canonicalName == cls.canonicalName){
                return true
            }
        }
        return false
    }

    fun finishAllActivity(){
        mActivitys.forEach {
            it?.finish()
        }
        mActivitys.clear()
    }

    @SuppressLint("MissingPermission")
    fun appExit(context:Context){
        try{
            finishActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.killBackgroundProcesses(context.packageName)
            System.exit(0)
        }catch (e: Exception){

        }
    }
}