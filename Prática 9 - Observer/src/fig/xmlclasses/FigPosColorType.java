//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.10.15 às 11:38:24 AM BRST 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de FigPosColorType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="FigPosColorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dpi.ufv.br/fig}FigType">
 *       &lt;sequence>
 *         &lt;element name="posX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="posY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FigPosColorType", propOrder = {
    "posX",
    "posY",
    "color"
})
@XmlSeeAlso({
    LineType.class,
    CircleType.class,
    RectangleType.class
})
public class FigPosColorType
    extends FigType
{

    protected int posX;
    protected int posY;
    @XmlElement(required = true)
    protected String color;

    /**
     * Obtém o valor da propriedade posX.
     * 
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Define o valor da propriedade posX.
     * 
     */
    public void setPosX(int value) {
        this.posX = value;
    }

    /**
     * Obtém o valor da propriedade posY.
     * 
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Define o valor da propriedade posY.
     * 
     */
    public void setPosY(int value) {
        this.posY = value;
    }

    /**
     * Obtém o valor da propriedade color.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Define o valor da propriedade color.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

}
