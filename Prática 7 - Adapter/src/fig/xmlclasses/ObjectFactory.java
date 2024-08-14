//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2017.07.30 �s 09:16:09 PM BRT 
//


package fig.xmlclasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fig.xmlclasses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FigList_QNAME = new QName("http://www.dpi.ufv.br/fig", "figList");
    private final static QName _Rectangle_QNAME = new QName("http://www.dpi.ufv.br/fig", "Rectangle");
    private final static QName _Composite_QNAME = new QName("http://www.dpi.ufv.br/fig", "Composite");
    private final static QName _FigElement_QNAME = new QName("http://www.dpi.ufv.br/fig", "figElement");
    private final static QName _Circle_QNAME = new QName("http://www.dpi.ufv.br/fig", "Circle");
    private final static QName _Line_QNAME = new QName("http://www.dpi.ufv.br/fig", "Line");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fig.xmlclasses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LineType }
     * 
     */
    public LineType createLineType() {
        return new LineType();
    }

    /**
     * Create an instance of {@link CircleType }
     * 
     */
    public CircleType createCircleType() {
        return new CircleType();
    }

    /**
     * Create an instance of {@link CompositeType }
     * 
     */
    public CompositeType createCompositeType() {
        return new CompositeType();
    }

    /**
     * Create an instance of {@link RectangleType }
     * 
     */
    public RectangleType createRectangleType() {
        return new RectangleType();
    }

    /**
     * Create an instance of {@link FigListType }
     * 
     */
    public FigListType createFigListType() {
        return new FigListType();
    }

    /**
     * Create an instance of {@link FigDoc }
     * 
     */
    public FigDoc createFigDoc() {
        return new FigDoc();
    }

    /**
     * Create an instance of {@link FigPosColorType }
     * 
     */
    public FigPosColorType createFigPosColorType() {
        return new FigPosColorType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FigListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dpi.ufv.br/fig", name = "figList")
    public JAXBElement<FigListType> createFigList(FigListType value) {
        return new JAXBElement<FigListType>(_FigList_QNAME, FigListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectangleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dpi.ufv.br/fig", name = "Rectangle", substitutionHeadNamespace = "http://www.dpi.ufv.br/fig", substitutionHeadName = "figElement")
    public JAXBElement<RectangleType> createRectangle(RectangleType value) {
        return new JAXBElement<RectangleType>(_Rectangle_QNAME, RectangleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dpi.ufv.br/fig", name = "Composite", substitutionHeadNamespace = "http://www.dpi.ufv.br/fig", substitutionHeadName = "figElement")
    public JAXBElement<CompositeType> createComposite(CompositeType value) {
        return new JAXBElement<CompositeType>(_Composite_QNAME, CompositeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FigType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dpi.ufv.br/fig", name = "figElement")
    public JAXBElement<FigType> createFigElement(FigType value) {
        return new JAXBElement<FigType>(_FigElement_QNAME, FigType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dpi.ufv.br/fig", name = "Circle", substitutionHeadNamespace = "http://www.dpi.ufv.br/fig", substitutionHeadName = "figElement")
    public JAXBElement<CircleType> createCircle(CircleType value) {
        return new JAXBElement<CircleType>(_Circle_QNAME, CircleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dpi.ufv.br/fig", name = "Line", substitutionHeadNamespace = "http://www.dpi.ufv.br/fig", substitutionHeadName = "figElement")
    public JAXBElement<LineType> createLine(LineType value) {
        return new JAXBElement<LineType>(_Line_QNAME, LineType.class, null, value);
    }

}
