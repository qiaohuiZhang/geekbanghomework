package org.geekbang.service;

import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassloader extends ClassLoader {


    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassloader().loadTheClass();
            Method hello = helloClass.getMethod("hello");
            hello.invoke(helloClass.newInstance());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Class<?> loadTheClass(){
        Class <?> targetClass = null;
        try {
            Path path = Paths.get(new ClassPathResource("Hello.xlass").getURI());
            byte[] bytes = Files.readAllBytes(path);
            if(bytes.length > 0){
                for(int i=0;i<bytes.length;i++){
                    bytes[i] = (byte) (255-bytes[i]);
                }
            }
            targetClass = this.defineClass("Hello", bytes, 0, bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return targetClass;
    }
}
