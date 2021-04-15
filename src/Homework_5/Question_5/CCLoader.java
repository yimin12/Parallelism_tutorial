package Homework_5.Question_5;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/25 13:35
 *   @Description :
 *
 */
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Our Custom ClassLoader to load the classes. Any class in the com.journaldev
 * package will be loaded using this ClassLoader. For other classes, it will delegate the request to its Parent ClassLoader.
 *
 */
public class CCLoader extends ClassLoader {

    /**
     * This constructor is used to set the parent ClassLoader
     */
    public CCLoader(ClassLoader parent) {
        super(parent);
    }

    /**
     * Loads the class from the file system. The class file should be located in
     * the file system. The name should be relative to get the file location
     *
     * @param name
     *            Fully Classified name of the class, for example, com.journaldev.Foo
     */
    private Class getClass(String name) throws ClassNotFoundException {
        String p = name.replace(".java","");
        String file = p.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {
            // This loads the byte code data from the file
            b = loadClassFileData(file);
            // defineClass is inherited from the ClassLoader class
            // that converts byte array into a Class. defineClass is Final
            // so we cannot override it
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Every request for a class passes through this method. If the class is in
     * com.journaldev package, we will use this classloader or else delegate the
     * request to parent classloader.
     *
     *
     * @param name
     *            Full class name
     */
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");
        if (name.startsWith("Homework_5.Question_5")) {
            System.out.println("Loading Class using CCLoader");
            return getClass(name);
        }
        return super.loadClass(name);
    }

    /**
     * Reads the file (.class) into a byte array. The file should be
     * accessible as a resource and make sure that it's not in Classpath to avoid
     * any confusion.
     *
     * @param name
     *            Filename
     * @return Byte array read from the file
     * @throws IOException
     *             if an exception comes in reading the file
     */
    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(
                name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }
}
