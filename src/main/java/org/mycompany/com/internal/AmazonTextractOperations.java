package org.mycompany.com.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.InputStream;
import java.nio.ByteBuffer;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.textract.AmazonTextractClientBuilder;
import com.amazonaws.util.IOUtils;




public class AmazonTextractOperations {
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonTextractOperations.class);

  @MediaType(value = ANY, strict = false)
  @Alias("DetectDocText")
  public String detectDocText (@Config AmazonTextractConfiguration c ,@ParameterGroup(name= "Document") AmazonTextractParameters p ) {
	  String ACCESS_KEY = c.getAccess_key_id();
	  String ACCESS_SECRET =c.getSecret_key_id();
	  LOGGER.info("ACCESS KEY AND SECRET ID is assigned");
	  
	  AmazonTextractClientBuilder clientBuilder = AmazonTextractClientBuilder.standard().withRegion(Regions.US_EAST_1);
	  clientBuilder.setCredentials(new AWSStaticCredentialsProvider(new
				BasicAWSCredentials(ACCESS_KEY, ACCESS_SECRET)));
	  LOGGER.info("TexTract client build successfull");
	  try {
		  
		  InputStream inputStream = p.getImage();
		  ByteBuffer imageBytes;
		  imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
		  LOGGER.info("Input stream of document processed");
		  
		  
	  }
	  catch(Exception e) {
			LOGGER.error("ERROR occurred...................... ");
			e.printStackTrace();
		}
	  
	  return "Successfull excecution";
  }



}
