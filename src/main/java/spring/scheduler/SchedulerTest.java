package spring.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTest {
	@Scheduled(cron = "${test}")
	public void sayHello() {
		System.out.println("hello:" + new Date(System.currentTimeMillis()));
	}
}
