package com.phamluu.script_executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;

public class ActionScriptFactory {

    @SuppressWarnings("finally")
    static String readFile(String path, Charset encoding) throws IOException {
        String result = "";
        try {
            File fileDir = new File(path);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

            String str;

            while ((str = in.readLine()) != null) {
                result += (str);
            }

            in.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return result;
        }
    }

    @SuppressWarnings("finally")
    public static ActionScript parseScripts(String scriptPath) {
        ActionScript result = null;
        try {
            String content = readFile(scriptPath, Charset.defaultCharset());
            //            XStream xstream = new XStream(new DomDriver());
            //            result = (ActionScript) xstream.fromXML(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

}
