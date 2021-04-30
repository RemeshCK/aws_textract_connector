package org.mycompany.com.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.textract.AmazonTextractClientBuilder;
import com.amazonaws.services.textract.model.Block;
import com.amazonaws.services.textract.model.DetectDocumentTextRequest;
import com.amazonaws.services.textract.model.DetectDocumentTextResult;
import com.amazonaws.services.textract.model.Document;
import com.amazonaws.util.IOUtils;



public class AmazonTextractOperations {
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonTextractOperations.class);

  @MediaType(value = ANY, strict = false)
  @Alias("DetectsDocText")
  public String detectDocText (@Config AmazonTextractConfiguration c ,@ParameterGroup(name= "Document") AmazonTextractParameters p ) {
	  DetectDocumentTextResult response =null;
	  String  text = "";
	  String ACCESS_KEY = c.getAccess_key_id();
	  String ACCESS_SECRET =c.getSecret_key_id();	
	  InputStream inputStream = p.getImage();
	  String region = c.getRegion();
	 AmazonTextractClientBuilder client = AmazonTextractClientBuilder.standard().withRegion(region);
	  LOGGER.info("TexTract Client Build Successfull");
	  client.setCredentials(new AWSStaticCredentialsProvider(new
				BasicAWSCredentials(ACCESS_KEY, ACCESS_SECRET)));  
	  try  {  
		  ByteBuffer imageBytes;
		 imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
		  LOGGER.info("Sending Request To Amazon Textract Service.");
		 DetectDocumentTextRequest request = new DetectDocumentTextRequest().withDocument(new Document().withBytes(imageBytes));
		  LOGGER.info("Request Successfull.");
		 DetectDocumentTextResult result = client.build().detectDocumentText(request);
		  LOGGER.info("Response Recieved");
		 response  = result;
	  		}
	  catch(Exception e) {
			LOGGER.error("Error Occuried !!!!!!!!!!");
			e.printStackTrace();
			
			}
      List<Block> docInfo = response.getBlocks();
      Iterator<Block> blockIterator = docInfo.iterator();
      while(blockIterator.hasNext()) {
          Block block = blockIterator.next();
          if(block.getBlockType().equals("LINE")) {
        	  text = text + " "+block.getText().toString();
        	  LOGGER.info(block.getText().toString());
          }
          
      }

		



           
	  return text ;
  		   }
}
