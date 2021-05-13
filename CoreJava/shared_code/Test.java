class A {
	public void fa() { 
		System.out.println("Inside A.fa()");
	}
	public void f() { 
		System.out.println("Inside A.f()");
	}
}
class B extends A {
	public void fb() { 
		System.out.println("Inside B.fb()");
	}
	public void f() { 
		System.out.println("Inside B.f()");
	}
}
class C extends A {
	public void fc() { 
		System.out.println("Inside C.fc()");
	}
	public void f() { 
		System.out.println("Inside C.f()");
	}
}
class Test {
	public static void main(String args[]) {
		B b = new B();//wrong
		C c = new C();//wrong
		D d = new D();//wrong
		b.f();
		c.f();
		d.f();

		A a[] = new A[3];
		a[0] = new B();
		a[1] = new C();
		a[2] = new D();
		
/*		
		//Reference is 'b'
		//Static type of 'b' is class B
		//Dynamic type of 'b' is class B
		B b = new B();
		b.fa();
		b.fb();
		b.f();
A a = new B();	OR	B b = new A();
Employee e = new Manager(); //OK
Manager m = new Employee(); //Error
*/		

		//Static type of 'a' is class A
		//Dynamic type of 'a' is class B
		A a = new B(); //correct [RECOMMENDED]
		a.fa();
		((B)a).fb(); //OK
		a.f();
	}
}