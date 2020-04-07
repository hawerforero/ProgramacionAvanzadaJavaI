/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.ExportarInformacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import persona.Empleado;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class CuentaAhorros extends Cuenta implements ExportarInformacion{
    private double CuotaMantenimiento;

    public double getCuotaMantenimiento() {
        return CuotaMantenimiento;
    }

    public CuentaAhorros(double CuotaMantenimiento, String cliente, String numeroCuenta, double saldo, double interes) {
        super(cliente, numeroCuenta, saldo, interes);
        this.CuotaMantenimiento = CuotaMantenimiento;
    }

    public void setCuotaMantenimiento(double CuotaMantenimiento) {
        this.CuotaMantenimiento = CuotaMantenimiento;
    }
    
    @Override
    public void toPDF() throws FileNotFoundException, IOException{
         
         File f = new File("CuentaAhorros.pdf");
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
	//System.out.println("Se generó el documento PDF de la CUENTA DE AHORROS en la raíz del proyecto");
    }

    @Override
    public void toExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(this.toString());
        try {
            OutputStream out = new FileOutputStream("CuentaAhorros.xls");
            workbook.write(out);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Se generó el documento EXCEL de la CUENTA DE AHORROS en la raíz del proyecto");
    }

    @Override
    public void toXML() throws Exception{
        String name = "CuentaAhorros";
        ArrayList<String> key = new ArrayList<String>();
        ArrayList<String> value = new ArrayList<String>();
 
        key.add("Cuota de mantenimiento");
        value.add(""+this.CuotaMantenimiento);
        key.add("Cliente");
        value.add(super.getCliente());
        key.add("Numero cuenta");
        value.add(super.getNumeroCuenta());
        key.add("Saldo");
        value.add(""+super.getSaldo());
        key.add("Interes");
        value.add(""+super.getInteres());
       
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
        //System.out.println("Se generó el documento XML de la CUENTA DE AHORROS en la raíz del proyecto");
    }

    @Override
    public void toHTML() throws Exception{
        File f = new File("CuentaAhorros.html");
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
        //System.out.println("Se generó el documento HTML de la CUENTA DE AHORROS en la raíz del proyecto");
    }

    @Override
    public String toString() {
        return "CuentaAhorros {" + "CuotaMantenimiento = " + CuotaMantenimiento + '}'+" "+super.toString()+"";
    }
    
}
