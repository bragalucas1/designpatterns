//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v2.3.3 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.07.01 às 08:05:18 AM ART 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de FigPosColorType complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FigPosColorType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.dpi.ufv.br/fig}FigType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="posX" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="posY" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    CircleType.class,
    RectangleType.class,
    LineType.class
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
