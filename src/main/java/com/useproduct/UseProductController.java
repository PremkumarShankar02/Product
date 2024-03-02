package com.useproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/useproduct")
public class UseProductController {
	@Autowired
	RestTemplate rt;
	
	@GetMapping(value="/getallproductwithgst")
	public List<UseProductPojoClass> getAllProductWithGst(){
		String url1="http://localhost:8081/product/get";
		String url2="http://localhost:8082/gst/getgst/";
		ResponseEntity<List<UseProductPojoClass>> products=rt.exchange(url1,HttpMethod.GET,null,new ParameterizedTypeReference<List<UseProductPojoClass>>() {
		});
		List<UseProductPojoClass> x=products.getBody();
		x.forEach(z->{
			int hsn=z.getHsnCode();
			ResponseEntity<Integer> gst=rt.exchange(url2+hsn,HttpMethod.GET,null,Integer.class);
			Integer percent=gst.getBody();
			int netPrice=z.getPrice()+(z.getPrice()*percent/100);
			z.setPrice(netPrice);
		});
		return x;
	}

}
