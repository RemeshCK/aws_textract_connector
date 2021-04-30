package org.mycompany.com.internal;




import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import java.io.InputStream;

public class AmazonTextractParameters {

	@Parameter
	@Expression(ExpressionSupport.REQUIRED)
	private InputStream image;

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}
}



	


