/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.sw.util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author nmtien
 */
public class ImageFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        try {
            if(f.isDirectory()){
                return true;
            }
            String fileName = f.getName();
            if(fileName.endsWith(".bmp") || fileName.endsWith(".gif") || fileName.endsWith(".png") || fileName.endsWith(".jpg")){
                return true;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Please choose image file";
    }
    
}
