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
 * <p>Classe Java de CompositeType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CompositeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dpi.ufv.br/fig}FigType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.dpi.ufv.br/fig}figList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompositeType", propOrder = {
    "figList"
})
public class CompositeType
    extends FigType
{

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
