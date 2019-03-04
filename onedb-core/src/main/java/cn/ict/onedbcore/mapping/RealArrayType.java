package cn.ict.onedbcore.mapping;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

public class RealArrayType
extends AbstractSingleColumnStandardBasicType<double[]>
implements DynamicParameterizedType {

public RealArrayType() {
super( 
    ArraySqlTypeDescriptor.INSTANCE, 
    RealArrayTypeDescriptor.INSTANCE 
);
}

public String getName() {
return "real-array";
}

@Override
protected boolean registerUnderJavaType() {
return true;
}

@Override
public void setParameterValues(Properties parameters) {
((RealArrayTypeDescriptor) 
    getJavaTypeDescriptor())
    .setParameterValues(parameters);
}
}