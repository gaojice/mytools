package transaction;


public class ServiceB {

	private ServiceA serviceA;

	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public void methodB() {
		serviceA.methodA();
	}
}
