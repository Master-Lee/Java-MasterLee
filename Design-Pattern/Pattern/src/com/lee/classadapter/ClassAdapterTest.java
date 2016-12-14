package com.lee.classadapter;

public class ClassAdapterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OldCellPhone myPhone = new OldCellPhone();
		myPhone.call();
		myPhone.text();
		System.out.println("手机变形前后");
		CellPhoneTransformer transformedPhone = new CellPhoneTransformer();
		transformedPhone.call();
		transformedPhone.text();
		transformedPhone.internet();
	}
}

//类适配器和对象适配器的权衡
//
//●　　类适配器使用对象继承的方式，是静态的定义方式；而对象适配器使用对象组合的方式，是动态组合的方式。
//
//●　　对于类适配器，由于适配器直接继承了Adaptee，使得适配器不能和Adaptee的子类一起工作，因为继承是静态的关系，当适配器继承了Adaptee后，就不可能再去处理  Adaptee的子类了。
//
//　　 对于对象适配器，一个适配器可以把多种不同的源适配到同一个目标。换言之，同一个适配器可以把源类和它的子类都适配到目标接口。因为对象适配器采用的是对象组合的关系，只要对象类型正确，是不是子类都无所谓。
//
//●　  对于类适配器，适配器可以重定义Adaptee的部分行为，相当于子类覆盖父类的部分实现方法。
//
//　　 对于对象适配器，要重定义Adaptee的行为比较困难，这种情况下，需要定义Adaptee的子类来实现重定义，然后让适配器组合子类。虽然重定义Adaptee的行为比较困难，但是想要增加一些新的行为则方便的很，而且新增加的行为可同时适用于所有的源。
//
//●　　对于类适配器，仅仅引入了一个对象，并不需要额外的引用来间接得到Adaptee。
//
//　　 对于对象适配器，需要额外的引用来间接得到Adaptee。
