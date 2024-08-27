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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.dpi.ufv.br/fig}figList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
