package edu.depaul.cdm.se.bootstore;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(serviceName="BootService")
public class BootService {
	@WebMethod
	public ProductSummary[] getBootStyles() {
		ProductSummary[] retval = new ProductSummary[2];
		retval[0] = new ProductSummary("7177382","Caterpillar Tradesman Work Boot");
		retval[1] = new ProductSummary("7269643","Caterpillar Logger Boot");
		return retval;
	}
	
	@WebMethod
	public String[] getColorOptions(String bootStyle) {
		return null;
	}
	
	@WebMethod
	public ProductDetail getProductDetail(String productId) {
		return null;
	}
}
