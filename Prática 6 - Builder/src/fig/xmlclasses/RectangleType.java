//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v2.3.3 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.07.25 às 07:19:27 PM BRT 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de RectangleType complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RectangleType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.dpi.ufv.br/fig}FigPosColorType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
