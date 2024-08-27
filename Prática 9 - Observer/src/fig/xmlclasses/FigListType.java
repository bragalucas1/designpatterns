//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.10.15 às 11:38:24 AM BRST 
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
 * <p>Classe Java de FigListType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="FigListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.dpi.ufv.br/fig}figElement" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the figElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFigElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     * {@link JAXBElement }{@code <}{@link LineType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     * {@link JAXBElement }{@code <}{@link CircleType }{@code >}
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
