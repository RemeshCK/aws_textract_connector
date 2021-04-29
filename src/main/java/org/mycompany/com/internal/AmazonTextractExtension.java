package org.mycompany.com.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;



@Xml(prefix = "amazon-textract")
@Extension(name = "Amazon Textract")
@Configurations(AmazonTextractConfiguration.class)
public class AmazonTextractExtension {

}
