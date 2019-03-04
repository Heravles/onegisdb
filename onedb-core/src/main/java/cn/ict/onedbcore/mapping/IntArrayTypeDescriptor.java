package cn.ict.onedbcore.mapping;

public class IntArrayTypeDescriptor
extends AbstractArrayTypeDescriptor<int[]> {

public static final IntArrayTypeDescriptor INSTANCE = 
new IntArrayTypeDescriptor();

public IntArrayTypeDescriptor() {
super( int[].class );
}

@Override
protected String getSqlArrayType() {
return "integer";
}
}