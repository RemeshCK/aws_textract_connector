package org.mycompany.com.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;


@Operations(AmazonTextractOperations.class)
public class AmazonTextractConfiguration {

  @Parameter
  @DisplayName(value = "ACCESS KEY ID")
  @Example(value = "dufhuwaehfiqwjeutcviuygfqufcbywqe")
  private String access_key_id;
  
  @Parameter
  @DisplayName(value = "SECRET KEY ID")
  @Example(value = "djhbgufcfuyqgwbecgfywc")
  private String secret_key_id;
  
  @Parameter
  @DisplayName(value = "Region")
  @Example(value = "us-east-1")
  private String region;
  
public String getAccess_key_id() {
	return access_key_id;
}
public void setAccess_key_id(String access_key_id) {
	this.access_key_id = access_key_id;
}
public String getSecret_key_id() {
	return secret_key_id;
}
public void setSecret_key_id(String secret_key_id) {
	this.secret_key_id = secret_key_id;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
  
  

}
