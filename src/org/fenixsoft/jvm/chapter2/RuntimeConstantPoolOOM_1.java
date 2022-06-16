package org.fenixsoft.jvm.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args：
 * JDK6:-XX:PermSize=6M -XX:MaxPermSize=6M   限制永久代大小
 * JDK8:-XX:MaxMetaspaceSize=6M  限制元空间/方法区
 * -Xmx6M :限制堆大小
 *
 * 限制方法区会无限循环  因为字符串常量池在堆中
 * @author zzm
 */
public class RuntimeConstantPoolOOM_1 {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
