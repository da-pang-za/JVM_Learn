package org.fenixsoft.jvm.chapter2;

//JDK6 false false
//JDK7 true  false  字符串常量池已经移到Java堆中，那只需要在常量池里记录一下首次出现的实例引 用即可
public class RuntimeConstantPoolOOM_2 {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        //"java"这个字符串在之前已经出现过了
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
