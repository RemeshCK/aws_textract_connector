package org.mycompany.com.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(AmazonTextractOperations.class)
public class AmazonTextractConfiguration {

  @Parameter
  private String access_key_id;
  @Parameter
  private String secret_key_id;
  @Parameter
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
