package app.core.beans.jobs;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Job2 implements InitializingBean, DisposableBean {

	@Value("${job.msg}")
	private String msg;
	private Thread thread;

	@Override
	public void afterPropertiesSet() throws Exception {
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					break;
				}
				System.out.println("\t" + this.msg);
			}
		}, "job2");
		thread.start();
	}

	@Override
	public void destroy() throws Exception {
		this.thread.interrupt();
	}

}
