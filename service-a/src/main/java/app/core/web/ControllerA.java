package app.core.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerA {
	
	@Autowired
	private RestTemplate restTemplate;
//	@Autowired
//	private DiscoveryClient discoveryClient;
//	@Autowired
//	private LoadBalancerClient loadBalancerClient;
	
	// http://localhost:8001/service/a
	@GetMapping("/service/a")
	public String handleA() {
//		String serviceId = "service-b";
//		URI baseUri = getBaseUri(serviceId);
		String url = "http://service-b/service/b"; 
		String bResponse = restTemplate.getForObject(url, String.class);
		return "Service A - " + bResponse; 
	}
	
	// LB
//	public URI getBaseUri(String instanceId) {
//		ServiceInstance instance = loadBalancerClient.choose(instanceId);
//		return instance.getUri();
//	}
	
	// NO LB
//	public URI getBaseUri(String instanceId) {
//		List<ServiceInstance> instances = discoveryClient.getInstances(instanceId);
//		return instances.get(0).getUri();
//	}

}
