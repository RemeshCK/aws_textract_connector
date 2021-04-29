package org.mycompany.com.internal;

import java.io.InputStream;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Parameter;

public class AmazonTextractParameters {
	
	
	
	
	@Parameter
	@Expression(ExpressionSupport.REQUIRED)
	private InputStream Image;

	public InputStream getImage() {
		return Image;
	}

	public void setImage(InputStream image) {
		Image = image;
	}

}
