//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v2.3.3 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.07.01 às 08:05:18 AM ART 
//


package fig.xmlclasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de FigListType complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FigListType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://www.dpi.ufv.br/fig}figElement" maxOccurs="unbounded"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FigListType", propOrder = {
    "figElement"
})
public class FigListType {

    @XmlElementRef(name = "figElement", namespace = "http://www.dpi.ufv.br/fig", type = JAXBElement.class)
    protected List<JAXBElement<? extends FigType>> figElement;

    /**
     * Gets the value of the figElement property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the figElement property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFigElement().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CircleType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     * {@link JAXBElement }{@code <}{@link LineType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     * {@link JAXBElement }{@code <}{@link FigType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends FigType>> getFigElement() {
        if (figElement == null) {
            figElement = new ArrayList<JAXBElement<? extends FigType>>();
        }
        return this.figElement;
    }

}
