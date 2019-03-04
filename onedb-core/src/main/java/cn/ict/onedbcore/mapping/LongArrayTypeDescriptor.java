package cn.ict.onedbcore.mapping;

public class LongArrayTypeDescriptor
extends AbstractArrayTypeDescriptor<long[]> {

public static final LongArrayTypeDescriptor INSTANCE = 
new LongArrayTypeDescriptor();

public LongArrayTypeDescriptor() {
super( long[].class );
}

@Override
protected String getSqlArrayType() {
return "bigint";
}
}