//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v2.3.3 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2024.08.19 �s 05:35:34 PM ART 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de CircleType complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CircleType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.dpi.ufv.br/fig}FigPosColorType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="radius" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleType", propOrder = {
    "radius"
})
public class CircleType
    extends FigPosColorType
{

    protected int radius;

    /**
     * Obt�m o valor da propriedade radius.
     * 
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Define o valor da propriedade radius.
     * 
     */
    public void setRadius(int value) {
        this.radius = value;
    }

}
