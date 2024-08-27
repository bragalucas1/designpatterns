//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v2.3.3 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.19 às 05:35:34 PM ART 
//


package fig.xmlclasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de BorderType complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BorderType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.dpi.ufv.br/fig}FigType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://www.dpi.ufv.br/fig}figElement"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BorderType", propOrder = {
    "figElement"
})
public class BorderType
    extends FigType
{

    @XmlElementRef(name = "figElement", namespace = "http://www.dpi.ufv.br/fig", type = JAXBElement.class)
    protected JAXBElement<? extends FigType> figElement;

    /**
     * Obtém o valor da propriedade figElement.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CircleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BorderType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LineType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FigType }{@code >}
     *     
     */
    public JAXBElement<? extends FigType> getFigElement() {
        return figElement;
    }

    /**
     * Define o valor da propriedade figElement.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CircleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BorderType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LineType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FigType }{@code >}
     *     
     */
    public void setFigElement(JAXBElement<? extends FigType> value) {
        this.figElement = value;
    }

}
