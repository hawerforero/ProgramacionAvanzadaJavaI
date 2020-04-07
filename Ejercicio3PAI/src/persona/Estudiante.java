/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import cuenta.Cuenta;
import interfaces.ExportarInformacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Estudiante extends Persona implements Comparable, ExportarInformacion, Serializable{
    private String codigo;
    private String programa;
    private Date fechaIngreso;
    
    public Estudiante(String codigo, String programa, Date fechaIngreso, double identificacion, String nombres, String apellidos) {
        super(identificacion, nombres, apellidos);
        this.codigo = codigo;
        this.programa = programa;
        this.fechaIngreso = fechaIngreso;
    }
    
    public Estudiante(String codigo, String programa, Date fechaIngreso, double identificacion, String nombres, String apellidos, Cuenta[] cuentas) {
        super(identificacion, nombres, apellidos, cuentas);
        this.codigo = codigo;
        this.programa = programa;
        this.fechaIngreso = fechaIngreso;
    }

    public Estudiante() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Estudiante {" + "codigo = " + codigo + ", programa = " + programa + ", fecha Ingreso = " + fechaIngreso + '}'+super.toString()+"";
    }
    
 
    @Override
    public void toPDF() throws FileNotFoundException, IOException{
         File f = new File("Estudiante.pdf");
         FileOutputStream fis = new FileOutputStream(f);
         ObjectOutputStream fob = new ObjectOutputStream(fis);
	 Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, fis);
            documento.open();
            documento.add(new Paragraph(this.toString()));
	    documento.close();
        } catch (DocumentException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println("Se generó el documento PDF del ESTUDIANTE en la raíz del proyecto");
    }

    @Override
    public void toExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(this.toString());
        try {
            OutputStream out = new FileOutputStream("Estudiante.xls");
            workbook.write(out);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Se generó el documento EXCEL del ESTUDIANTE en la raíz del proyecto");
    }

    @Override
    public void toXML() throws Exception{
        String name = "Estudiante";
        ArrayList<String> key = new ArrayList<String>();
        ArrayList<String> value = new ArrayList<String>();
 
        key.add("Codigo");
        value.add(this.codigo);
        key.add("Programa");
        value.add(this.programa);
        key.add("Fecha de Ingreso");
        value.add(this.fechaIngreso.toString());
        key.add("Identificacion");
        value.add(""+super.getIdentificacion());
        key.add("Nombres");
        value.add(super.getNombres());
        key.add("Apellidos");
        value.add(super.getApellidos());
        key.add("Cuentas");
        value.add(""+super.getCuenta());
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        org.w3c.dom.Document document = implementation.createDocument(null, name, null);
        document.setXmlVersion("1.0");

        Element raiz = document.getDocumentElement();
        for(int i=0; i<key.size();i++){
            Element itemNode = document.createElement("ITEM"); 
            Element keyNode = document.createElement("KEY"); 
            Text nodeKeyValue = document.createTextNode(key.get(i));
            keyNode.appendChild(nodeKeyValue);      
            Element valueNode = document.createElement("VALUE"); 
            Text nodeValueValue = document.createTextNode(value.get(i));                
            valueNode.appendChild(nodeValueValue);
            itemNode.appendChild(keyNode);
            itemNode.appendChild(valueNode);
            raiz.appendChild(itemNode); 
        }               
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File(name+".xml")); 
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        System.out.println("Se generó el documento XML del ESTUDIANTE en la raíz del proyecto");
    }

    @Override
    public void toHTML() throws Exception{
        File f = new File("Estudiante.html");
        FileOutputStream fis = new FileOutputStream(f);
        ObjectOutputStream fob = new ObjectOutputStream(fis);
        try{
                 fob.writeObject(this.toString());         
        } 
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
         finally{
            fob.close();
         }
        System.out.println("Se generó el documento HTML del ESTUDIANTE en la raíz del proyecto");
    }
    
     @Override
    public int compareTo(Object o) {
      
        Estudiante e = (Estudiante)o;
        if ( Integer.parseInt(this.codigo) > Integer.parseInt(e.codigo)  ) 
            return 1;
        if(this.codigo == e.codigo)
            return 0;
        else
            return -1;
    }
    
}
