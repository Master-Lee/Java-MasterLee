元注解
	其实就是可以注解到别的注解上的注解。而被注解的注解我们就称之为组合注解。组合注解同时具备元注解的功能！
	四类元注解：
		1.@Target：说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）
　　　　	取值(ElementType)有：
　　　　	CONSTRUCTOR:用于描述构造器
　　　　	FIELD:用于描述域
　　　　	LOCAL_VARIABLE:用于描述局部变量
　　　　	METHOD:用于描述方法
　　　　	PACKAGE:用于描述包
　　　　	PARAMETER:用于描述参数
　　　　	TYPE:用于描述类、接口(包括注解类型) 或enum声明
			例如： 
				注解Table 可以用于注解类、接口(包括注解类型)
				@Target(ElementType.Tye)
				public @interface Table {
					/**
					 * 数据表名称注解，默认值为类名称
					 * @return
					 */
					 public String tableName() default "className";
				}
				
		2.@Retention 定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。
			取值（RetentionPoicy）有：
	　　　　SOURCE:在源文件中有效（即源文件保留）
	　　　　CLASS:在class文件中有效（即class保留）
	　　　　RUNTIME:在运行时有效（即运行时保留）
			例如：
				@Target(ElementType.FIELD)
				@Retention(RetentionPolicy.RUNTIME)
				public @interface Column {
					public String name() default "fieldName";
					public String setFuncName() default "setField";
					public String getFuncName() default "getField";
					public boolean defaultDBValue() default false;
				}
				Column注解的RetentionPolicy的属性值是RUNTIME，这样注解处理可以通过反射，获取到该注解的属性值，从而去做一些运行时的逻辑处理。
			
　　　　3.@Documented 用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。

　　　　4.@Inherited 是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类
			例如:
				@Inherited
				public @interface Greeting {
					public enum FontColor{BLUE,RED,GREEN};
					String name();
					FontColor fontColor() default FontColor.GREEN;
				}