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
 * <p>Classe Java de LineType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="LineType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dpi.ufv.br/fig}FigPosColorType">
 *       &lt;sequence>
 *         &lt;element name="posX2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="posY2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineType", propOrder = {
    "posX2",
    "posY2"
})
public class LineType
    extends FigPosColorType
{

    protected int posX2;
    protected int posY2;

    /**
     * Obtém o valor da propriedade posX2.
     * 
     */
    public int getPosX2() {
        return posX2;
    }

    /**
     * Define o valor da propriedade posX2.
     * 
     */
    public void setPosX2(int value) {
        this.posX2 = value;
    }

    /**
     * Obtém o valor da propriedade posY2.
     * 
     */
    public int getPosY2() {
        return posY2;
    }

    /**
     * Define o valor da propriedade posY2.
     * 
     */
    public void setPosY2(int value) {
        this.posY2 = value;
    }

}
