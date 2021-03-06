#### ClassNotFoundException

> java.lang public class ClassNotFoundException extends **ReflectiveOperationException**
>
> Thrown when an application tries to load in a class through its string name using:
>
> + The forName method in class Class.
> + The findSystemClass method in class ClassLoader .
> + The loadClass method in class ClassLoader.
>
> but no definition for the class with the specified name could be found.
> As of release 1.4, this exception has been retrofitted to conform to the general purpose exception-chaining mechanism. The "optional exception that was raised while loading the class" that may be provided at construction time and accessed via the getException() method is now known as the cause, and may be accessed via the Throwable.getCause() method, as well as the aforementioned "legacy method."

看这个异常继承自ReflectiveOperationException，就可知这个异常发生在通过反射加载Class文件的时候，如果没有在classpath中查找到指定的类，就会抛出ClassNotFoundException 



#### NoClassDefFoundError

> java.lang public class NoClassDefFoundError extends LinkageError
> Thrown if the Java Virtual Machine or a ClassLoader instance tries to load in the definition of a class (as part of a normal method call or as part of creating a new instance using the new expression) and no definition of the class could be found.
> The searched-for class definition existed **when the currently executing class was compiled, but the definition can no longer be found.**

当JVM在加载一个类的时候，如果这个类在编译时是可用的，但是在运行时找不到这个类的定义的时候，JVM就会抛出一个NoClassDefFoundError错误；

我们先创建一个NoClassDefFoundErrorTest类，然后编译以后，将创建的类生产的NoClassDefFoundErrorTest.class文件删除，然后执行程序，就会出现该异常 
