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
 * &lt;p&gt;Classe Java de LineType complex type.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="LineType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.dpi.ufv.br/fig}FigPosColorType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="posX2" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="posY2" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
     * Obt�m o valor da propriedade posX2.
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
     * Obt�m o valor da propriedade posY2.
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
