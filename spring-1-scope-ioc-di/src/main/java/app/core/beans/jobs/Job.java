package app.core.beans.jobs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("the-message-job")
public class Job implements BeanNameAware {

	@Value("${job.msg}")
	private String msg;
	private Thread thread;
	private String beanName;
	
	

	@PostConstruct
	public void startJob() {
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					break;
				}
				System.out.println("bean name: " + this.beanName + ": "  + this.msg);
			}
		}, "job");
		thread.start();
	}

	@PreDestroy
	public void stopJob() {
		this.thread.interrupt();
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		
	}

}
