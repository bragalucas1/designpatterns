//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v2.3.3 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2024.08.19 às 05:35:34 PM ART 
//


package fig.xmlclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de anonymous complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://www.dpi.ufv.br/fig}figList"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "figList"
})
@XmlRootElement(name = "FigDoc")
public class FigDoc {

    @XmlElement(required = true)
    protected FigListType figList;

    /**
     * Obtém o valor da propriedade figList.
     * 
     * @return
     *     possible object is
     *     {@link FigListType }
     *     
     */
    public FigListType getFigList() {
        return figList;
    }

    /**
     * Define o valor da propriedade figList.
     * 
     * @param value
     *     allowed object is
     *     {@link FigListType }
     *     
     */
    public void setFigList(FigListType value) {
        this.figList = value;
    }

}
