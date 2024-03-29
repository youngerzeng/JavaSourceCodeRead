/**
 * Author: youngerzeng
 * Date: 2019/9/9 22:26
 * Description:
 */
package java.lang;
/*
记：1. 共12个方法
    2. 9个native方法：registerNatives、getClass、hashCode、clone、notify、notifyAll、wait、wait(long)、wait(long,int)
    3. 3个非native方法：equals、finalize、toString
 */

/**
 * 所有类的超类，所有的类都实现了该类的方法
 * @author  unascribed
 * @see     Class
 * @since   JDK1.0
 */
public class Object {

    /**
     * 本地方法，具体是用C（C++）在DLL中实现，在JNI调用
     */
    private static native void registerNatives();

    /**
     * 初始化调用该方法
     */
    static {
        registerNatives();
    }

    /**
     * 返回此类的运行时类
     * 返回的类对象是被表示该类的static synchronized方法锁定的对象
     * @return The {@code Class} 表示该类运行时类的Class对象
     * @jls 15.8.2 Class Literals
     */
    public final native Class<?> getClass();

    /**
     *
     * @return  该对象的哈希值
     * @see     Object#equals(Object)
     * @see     System#identityHashCode
     */
    public native int hashCode();

    /**
     *比较两个对象引用地址是否相等
     * 非空对象特性：
     * 自反性：x.equals(x)  true
     * 对称性: x.equals(y)  =  y.equals(x)
     * 传递性：x.equals(y) y.equals(z) 则 x.equals(z)
     * 一致性：多次调用x.equals(y)始终为true或false ,则x,y没有被修改过
     * x.equals(null)  = false
     * @param   obj
     * @return
     */
    public boolean equals(Object obj) {
        return (this == obj);
    }

    /**
     * 克隆对象
     * 记：protected权限，需要覆盖该方法才能调用。而覆盖还需要继承Cloneable接口,否则无法调用抛出CloneNotSupportedException异常
     * @return     创建并返回此对象的副本
     * @throws  CloneNotSupportedException  如果对象的类不支持Cloneable接口。 覆盖clone方法的子类也可以抛出此异常以指示实例无法克隆。
     * @see Cloneable
     */
    protected native Object clone() throws CloneNotSupportedException;

    /**
     * 返回对象的字符串表示形式：类名 + “@” + 16进制字符串哈希值
     * 建议一般重写
     * @return  a string representation of the object.
     */
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    /**
     * 唤醒正在等待对象监视器的单个线程
     * @throws  IllegalMonitorStateException  if the current thread is not
     *               the owner of this object's monitor.
     * @see        Object#notifyAll()
     * @see        Object#wait()
     */
    public final native void notify();

    /**
     * 唤醒正在等待对象监视器的所有线程。
     * @throws  IllegalMonitorStateException  if the current thread is not
     *               the owner of this object's monitor.
     * @see        Object#notify()
     * @see        Object#wait()
     */
    public final native void notifyAll();

    /**
     * 导致当前线程等待，直到另一个线程调用此对象的notify()方法或notifyAll()方法，或指定的时间已过。
     * @param      timeout   以毫秒为单位等待的最长时间。
     * @throws  IllegalArgumentException 如果超时值为负。
     * @throws  IllegalMonitorStateException  如果当前线程不是对象监视器的所有者。
     * @throws  InterruptedException 如果任何线程在当前线程等待通知之前或当前线程中断当前线程。 当抛出此异常时，当前线程的中断状态将被清除。
     * @see        Object#notify()
     * @see        Object#notifyAll()
     */
    public final native void wait(long timeout) throws InterruptedException;

    /**
     *
     * @param      timeout   以毫秒为单位等待的最长时间。
     * @param      nanos      额外的时间，以纳秒范围0-999999。
     * @throws  IllegalArgumentException      如果超时值为负值或 IllegalArgumentException值不在0-999999范围内。
     * @throws  IllegalMonitorStateException  如果当前线程不是此对象的监视器的所有者。
     * @throws  InterruptedException 如果任何线程在当前线程等待通知之前或当前线程中断当前线程。 当抛出此异常时，当前线程的中断状态将被清除。
     */
    public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                    "nanosecond timeout value out of range");
        }

        if (nanos > 0) {
            timeout++;
        }

        wait(timeout);
    }

    /**
     * 导致当前线程等待，直到另一个线程调用该对象的notify()方法或notifyAll()方法。 换句话说，这个方法的行为就好像简单地执行呼叫wait(0) 。
     * @throws  IllegalMonitorStateException  if the current thread is not
     *               the owner of the object's monitor.
     * @throws  InterruptedException
     * @see        Object#notify()
     * @see        Object#notifyAll()
     */
    public final void wait() throws InterruptedException {
        wait(0);
    }

    /**
     * 当垃圾收集确定不再有对该对象的引用时，由对象的垃圾回收器调用此方法。 一个子类覆盖了处理系统资源或执行其他清理的finalize方法。
     * @throws Throwable the {@code Exception} raised by this method
     */
    protected void finalize() throws Throwable { }
}

