/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public interface ExportarInformacion {
    
    public void toPDF() throws Exception;
    public void toExcel();
    public void toXML() throws Exception;
    public void toHTML() throws Exception;
    
}
