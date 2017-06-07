/**
 * CartEntryObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package interfaces;

public class CartEntryObject  implements java.io.Serializable {
    private int cart_id;

    private int product_id;

    private int quantity;

    private java.lang.String cart_date;

    public CartEntryObject() {
    }

    public CartEntryObject(
           int cart_id,
           int product_id,
           int quantity,
           java.lang.String cart_date) {
           this.cart_id = cart_id;
           this.product_id = product_id;
           this.quantity = quantity;
           this.cart_date = cart_date;
    }


    /**
     * Gets the cart_id value for this CartEntryObject.
     * 
     * @return cart_id
     */
    public int getCart_id() {
        return cart_id;
    }


    /**
     * Sets the cart_id value for this CartEntryObject.
     * 
     * @param cart_id
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }


    /**
     * Gets the product_id value for this CartEntryObject.
     * 
     * @return product_id
     */
    public int getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this CartEntryObject.
     * 
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the quantity value for this CartEntryObject.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this CartEntryObject.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the cart_date value for this CartEntryObject.
     * 
     * @return cart_date
     */
    public java.lang.String getCart_date() {
        return cart_date;
    }


    /**
     * Sets the cart_date value for this CartEntryObject.
     * 
     * @param cart_date
     */
    public void setCart_date(java.lang.String cart_date) {
        this.cart_date = cart_date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartEntryObject)) return false;
        CartEntryObject other = (CartEntryObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cart_id == other.getCart_id() &&
            this.product_id == other.getProduct_id() &&
            this.quantity == other.getQuantity() &&
            ((this.cart_date==null && other.getCart_date()==null) || 
             (this.cart_date!=null &&
              this.cart_date.equals(other.getCart_date())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCart_id();
        _hashCode += getProduct_id();
        _hashCode += getQuantity();
        if (getCart_date() != null) {
            _hashCode += getCart_date().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartEntryObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://interfaces/", "cartEntryObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cart_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cart_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("product_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cart_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cart_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
