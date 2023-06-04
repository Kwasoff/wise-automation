package guru;

import org.junit.Assert;
import org.junit.Test;

public class Buy {

    public String getInitials(String fullName){
        fullName = fullName.trim();
        if (fullName.isEmpty()){
            return null;
        }

        String [] arr = fullName.split(" ");
        if (arr.length != 2){
            return null;
        }

        String initials = "" + arr[0].charAt(0) + arr[1].charAt(0);
        return initials.toUpperCase();


    }






    @Test
    public void test1(){
       String actualResult = getInitials("james  bond");
        Assert.assertEquals("JB",actualResult);

    }

    @Test
    public void test2(){
        String actualResult = getInitials("james");
        Assert.assertNull(actualResult);
    }

    @Test
    public void test3(){
        String actualResult = getInitials("james bond");
        Assert.assertEquals("JB",actualResult);
    }

    @Test
    public void test4(){
        String actualResult = getInitials("");
        Assert.assertNull(actualResult);
    }

    @Test
    public void  test5(){
        String actualResult = getInitials("  James bond ");
        Assert.assertEquals("JB",actualResult);
    }


    @Test
    public void test6(){
        String actualRresult = getInitials("James bond junior");
        Assert.assertNull(actualRresult);
    }




}
