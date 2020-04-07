/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import cuenta.Cuenta;
import interfaces.Deudas;
import interfaces.ExportarInformacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.ArrayList;
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Empleado extends Persona implements Deudas, ExportarInformacion, Serializable, Comparable{
    
    private String cargo;
    private Date fechaIngreso;
    private double salario;

    public Empleado(String cargo, Date fechaIngreso, double salario, double identificacion, String nombres, String apellidos) {
        super(identificacion, nombres, apellidos);
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        
    }
    
    public Empleado(String cargo, Date fechaIngreso, double salario, double identificacion, String nombres, String apellidos, Cuenta[] cuentas) {
        super(identificacion, nombres, apellidos, cuentas);
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        
    }

    public Empleado() {
      
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    

    @Override
    public void registrar(String descripcion, double valor, Date fecha, double identificacion) {
        System.out.println("Empleado_registrar deuda a: ");
        System.out.println("Identificacion: "+identificacion+" Descripcion: "+valor);
    }

    @Override
    public void quitar(int id_deuda) {
      System.out.println("Empleado_Quitar deuda a: ");
    }

    @Override
    public void toPDF() throws Exception{
         
         File f = new File("Empleado.pdf");
         FileOutputStream fis = new FileOutputStream(f);
	 Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, fis);
            documento.open();
            documento.add(new Paragraph(this.toString()));
	    documento.close();
        } catch (DocumentException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println("Se generó el documento PDF del EMPLEADO en la raíz del proyecto");
    }
    @Override
    public String toString() {
        return "Empleado {" + "cargo = " + cargo + ", fechaIngreso = " + fechaIngreso + ", salario = " + salario + '}'+" "+super.toString()+"";
    }
    @Override
    public void toExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(this.toString());
        try {
            OutputStream out = new FileOutputStream("Empleado.xls");
            workbook.write(out);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Se generó el documento EXCEL del EMPLEADO en la raíz del proyecto");
    }

    @Override
    public void toXML() throws Exception{
        String name = "Empleado";
        ArrayList<String> key = new ArrayList<String>();
        ArrayList<String> value = new ArrayList<String>();
 
        key.add("Cargo");
        value.add(this.cargo);
        key.add("Fecha Ingreso");
        value.add(this.fechaIngreso.toString());
        key.add("Salario");
        value.add(""+this.salario);
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
        System.out.println("Se generó el documento XML del EMPLEADO en la raíz del proyecto");
    }
    @Override
    public void toHTML() throws Exception{
        File f = new File("Empleado.html");
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
        System.out.println("Se generó el documento HTML del EMPLEADO en la raíz del proyecto");
    }
    @Override
    public int compareTo(Object o) {
      
       Empleado e = (Empleado)o;
        if ( super.getIdentificacion() > e.getIdentificacion() ) 
            return 1;
        if(super.getIdentificacion() == e.getIdentificacion())
            return 0;
        else
            return -1;
    }
    
}
