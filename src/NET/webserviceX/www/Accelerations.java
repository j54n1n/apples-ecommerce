/**
 * Accelerations.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public class Accelerations implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Accelerations(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _celo = "celo";
    public static final java.lang.String _centigal = "centigal";
    public static final java.lang.String _centimeterPersquaresecond = "centimeterPersquaresecond";
    public static final java.lang.String _decigal = "decigal";
    public static final java.lang.String _decimeterPersquaresecond = "decimeterPersquaresecond";
    public static final java.lang.String _dekameterPersquaresecond = "dekameterPersquaresecond";
    public static final java.lang.String _footPersquaresecond = "footPersquaresecond";
    public static final java.lang.String _gunit = "gunit";
    public static final java.lang.String _gal = "gal";
    public static final java.lang.String _galileo = "galileo";
    public static final java.lang.String _gn = "gn";
    public static final java.lang.String _grav = "grav";
    public static final java.lang.String _hectometerPersquaresecond = "hectometerPersquaresecond";
    public static final java.lang.String _inchPersquaresecond = "inchPersquaresecond";
    public static final java.lang.String _kilometerPerhoursecond = "kilometerPerhoursecond";
    public static final java.lang.String _kilometerPersquaresecond = "kilometerPersquaresecond";
    public static final java.lang.String _leo = "leo";
    public static final java.lang.String _meterPersquaresecond = "meterPersquaresecond";
    public static final java.lang.String _milePerhourminute = "milePerhourminute";
    public static final java.lang.String _milePerhoursecond = "milePerhoursecond";
    public static final java.lang.String _milePersquaresecond = "milePersquaresecond";
    public static final java.lang.String _milligal = "milligal";
    public static final java.lang.String _millimeterPersquaresecond = "millimeterPersquaresecond";
    public static final Accelerations celo = new Accelerations(_celo);
    public static final Accelerations centigal = new Accelerations(_centigal);
    public static final Accelerations centimeterPersquaresecond = new Accelerations(_centimeterPersquaresecond);
    public static final Accelerations decigal = new Accelerations(_decigal);
    public static final Accelerations decimeterPersquaresecond = new Accelerations(_decimeterPersquaresecond);
    public static final Accelerations dekameterPersquaresecond = new Accelerations(_dekameterPersquaresecond);
    public static final Accelerations footPersquaresecond = new Accelerations(_footPersquaresecond);
    public static final Accelerations gunit = new Accelerations(_gunit);
    public static final Accelerations gal = new Accelerations(_gal);
    public static final Accelerations galileo = new Accelerations(_galileo);
    public static final Accelerations gn = new Accelerations(_gn);
    public static final Accelerations grav = new Accelerations(_grav);
    public static final Accelerations hectometerPersquaresecond = new Accelerations(_hectometerPersquaresecond);
    public static final Accelerations inchPersquaresecond = new Accelerations(_inchPersquaresecond);
    public static final Accelerations kilometerPerhoursecond = new Accelerations(_kilometerPerhoursecond);
    public static final Accelerations kilometerPersquaresecond = new Accelerations(_kilometerPersquaresecond);
    public static final Accelerations leo = new Accelerations(_leo);
    public static final Accelerations meterPersquaresecond = new Accelerations(_meterPersquaresecond);
    public static final Accelerations milePerhourminute = new Accelerations(_milePerhourminute);
    public static final Accelerations milePerhoursecond = new Accelerations(_milePerhoursecond);
    public static final Accelerations milePersquaresecond = new Accelerations(_milePersquaresecond);
    public static final Accelerations milligal = new Accelerations(_milligal);
    public static final Accelerations millimeterPersquaresecond = new Accelerations(_millimeterPersquaresecond);
    public java.lang.String getValue() { return _value_;}
    public static Accelerations fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Accelerations enumeration = (Accelerations)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Accelerations fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Accelerations.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "Accelerations"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
