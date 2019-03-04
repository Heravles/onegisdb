package cn.ict.onedbcore.mapping;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

public class LongArrayType
extends AbstractSingleColumnStandardBasicType<long[]>
implements DynamicParameterizedType {

public LongArrayType() {
super( 
    ArraySqlTypeDescriptor.INSTANCE, 
    LongArrayTypeDescriptor.INSTANCE 
);
}

public String getName() {
return "long-array";
}

@Override
protected boolean registerUnderJavaType() {
return true;
}

@Override
public void setParameterValues(Properties parameters) {
((LongArrayTypeDescriptor) 
    getJavaTypeDescriptor())
    .setParameterValues(parameters);
}
}