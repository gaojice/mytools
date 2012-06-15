package transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ServiceA {
	private transaction.Component component;

	public void methodA() {
		// insert;
		component.comp();
	}
}
