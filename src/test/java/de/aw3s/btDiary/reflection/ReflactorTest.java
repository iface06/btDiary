package de.aw3s.btDiary.reflection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReflactorTest {


    @Test
    public void testGetStringProperty(){

        Dummy d = new Dummy();
        d.setName("hallo");

        String property = new Reflactor().getProperty(d, "name");
        assertEquals("hallo", property);
    }

    @Test(expected = RuntimeException.class)
    public void testExceptionHandling(){
        Dummy d = new Dummy();

        String property = new Reflactor().getProperty(d, "noSuchMethode");
        fail();
    }

    public static class Dummy{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
