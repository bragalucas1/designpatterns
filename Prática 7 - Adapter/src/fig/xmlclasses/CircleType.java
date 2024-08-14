//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.07.30 às 09:16:09 PM BRT 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CircleType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CircleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dpi.ufv.br/fig}FigPosColorType">
 *       &lt;sequence>
 *         &lt;element name="radius" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
     * Obtém o valor da propriedade radius.
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
