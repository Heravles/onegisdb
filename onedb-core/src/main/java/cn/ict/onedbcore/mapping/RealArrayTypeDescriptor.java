package cn.ict.onedbcore.mapping;

public class RealArrayTypeDescriptor
extends AbstractArrayTypeDescriptor<double[]> {

public static final RealArrayTypeDescriptor INSTANCE = 
new RealArrayTypeDescriptor();

public RealArrayTypeDescriptor() {
super( double[].class );
}

@Override
protected String getSqlArrayType() {
return "real";
}
}