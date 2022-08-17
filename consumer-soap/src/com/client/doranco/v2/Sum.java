
package com.client.doranco.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour sum complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="sum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sum", propOrder = {
    "a",
    "b"
})
public class Sum {

    protected int a;
    protected int b;

    /**
     * Obtient la valeur de la propri�t� a.
     * 
     */
    public int getA() {
        return a;
    }

    /**
     * D�finit la valeur de la propri�t� a.
     * 
     */
    public void setA(int value) {
        this.a = value;
    }

    /**
     * Obtient la valeur de la propri�t� b.
     * 
     */
    public int getB() {
        return b;
    }

    /**
     * D�finit la valeur de la propri�t� b.
     * 
     */
    public void setB(int value) {
        this.b = value;
    }

}
