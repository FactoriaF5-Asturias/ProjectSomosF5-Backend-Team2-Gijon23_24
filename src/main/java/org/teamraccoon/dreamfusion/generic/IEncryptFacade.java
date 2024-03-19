package org.teamraccoon.dreamfusion.generic;

public interface IEncryptFacade {
    
    String encode(String type, String data);
    String decode(String type, String data);

}
