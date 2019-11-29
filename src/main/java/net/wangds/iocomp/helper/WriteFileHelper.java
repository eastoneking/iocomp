package net.wangds.iocomp.helper;

import net.wangds.log.helper.LogHelper;

import java.io.*;

public final class WriteFileHelper {


    public static File buildFile(String dir, String file){
        return new File(dir, file);
    }

    public static File buildFile(String fullPath){
        return new File(fullPath);
    }

    public static void write2File(byte[] data, File file, boolean append){
        try(FileOutputStream fos = new FileOutputStream(file, append)){
            writeNotFlash(data, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            LogHelper.error(e);
        } catch (IOException e) {
            LogHelper.error(e);
        }
    }

    public static void writeNotFlash(byte[] data, OutputStream os){
        if(data==null||os==null){
            return;
        }
        try{
            os.write(data);
        }catch (Exception e){
            LogHelper.error(e);
        }
    }

    public static void writeAndFlush(byte[] data, OutputStream os){
        writeNotFlash(data, os);
        if(os!=null){
            try {
                os.flush();
            } catch (IOException e) {
                LogHelper.error(e);
            }
        }
    }

}
