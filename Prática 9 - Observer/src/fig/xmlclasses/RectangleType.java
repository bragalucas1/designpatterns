//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.10.15 às 11:38:24 AM BRST 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RectangleType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RectangleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dpi.ufv.br/fig}FigPosColorType">
 *       &lt;sequence>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RectangleType", propOrder = {
    "width",
    "height"
})
public class RectangleType
    extends FigPosColorType
{

    protected int width;
    protected int height;

    /**
     * Obtém o valor da propriedade width.
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * Define o valor da propriedade width.
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Obtém o valor da propriedade height.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Define o valor da propriedade height.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

}
