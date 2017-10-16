
package com;


public class Myenc {
    
    //==========================================================================ENCRYPTION METHODS
    public static String binaryToHash(String newPass){                              
        String newHashPass="";                                                
        char[] p=newPass.toCharArray();                                       
        for(int i=0;i<p.length-1;i++){     

            if((int)p[i]==48){                                                
               if((int)p[i+1]==48){ 
                   newHashPass=newHashPass+"#";
                   i++;
               }
               else if((int)p[i+1]==49){
                   newHashPass=newHashPass+"$";
               }
               else {
                   newHashPass=newHashPass+"$";
               }
           }
           else if((int)p[i]==49){
               if((int)p[i+1]==49){
                   newHashPass=newHashPass+"*";
                   i++;
               }
               else if((int)p[i+1]==48){
                   newHashPass=newHashPass+"@";
               }
               else{
                   newHashPass=newHashPass+"@";
               }
           }
           else{
               newHashPass=newHashPass+"%";
           }
        }
        return newHashPass;
    } 
    public static String decimalToBinary(int i){
        String a="";
        if(i==0){
            return "0";
        }
        while(i>0){
            a=a+i%2;
            i=i/2;
        }
        return a;
    }
    //==========================================================================
    
    //**************************************************************************DECRYPTION METHOD
    //**************************************************************************
    public static String hashToBinary(String newHashPass){
        String binaryPass="";
        String [] newPass=newHashPass.split("%");
        for(String pass:newPass){
            char[] hashPass=pass.toCharArray();
            for(char p:hashPass){
                if(p=='#'){
                    binaryPass=binaryPass+"00";
                }
                else if(p=='*'){
                    binaryPass=binaryPass+"11";
                }
                else if(p=='@'){
                    binaryPass=binaryPass+"1";
                }
                else if(p=='$'){
                    binaryPass=binaryPass+"0";
                }
            }
            binaryPass=binaryPass+"%";
        }
        return binaryPass;
    }
    
    public static String binaryToDecimal(String pass){
        String[] newPassword=pass.split("%");
        int j=0;
        String newpassword="";
        for(String p:newPassword){
            j=0;
            int po=0;
            char[] newpass=p.toCharArray();
            for(int i=0;i<newpass.length;i++){
                
                j=(int) (j+(((int)newpass[i]-48)*Math.pow(2, po)));
                po++;
            }
            
            char a=(char)j;
            newpassword=newpassword+a;
            
        }
        return newpassword;
    }
    
    

    
    public static String encrypt(String password){
        char[] pass=password.toCharArray();
        String newPass="";
        for(char p:pass){
            newPass=newPass+decimalToBinary(p);
            newPass=newPass+"%";
        }
        String encpass=binaryToHash(newPass);
        System.out.println(encpass);
        return encpass;
    }
    public static String decrypt(String password){
        
        String decpass=hashToBinary(password);
        String orpassword=binaryToDecimal(decpass);
        System.out.println(orpassword);
        return orpassword;
    }
    
}
