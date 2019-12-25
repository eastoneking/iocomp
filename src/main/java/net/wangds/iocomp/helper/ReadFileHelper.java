package net.wangds.iocomp.helper;

import net.wangds.log.helper.LogHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ReadFileHelper {

    /**
     * 读取时，每次读取块大小.
     */
    public static int READ_BUFFER_SIZE = 1024*512;

    /**
     * 从输入流中读取数据.
     * @param is 输入流.
     * @return 数据.
     */
    public byte[] readInputStream(InputStream is){
        byte[] res = new byte[0];
        if(is==null){
            return res;
        }

        try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
            byte[] buff = new byte[READ_BUFFER_SIZE];
            int len; // 每次读取数据块大小.
            while((len=is.read(buff))>=0){
                out.write(buff,0,len);
            }
            out.flush(); // 刷新缓存
            res = out.toByteArray();
        } catch (IOException e) {
            LogHelper.error(e);
        }
        return res;
    }

}
