package Utils;

public enum RahulShettyTestDataEnum {
      RADIOBUTTON1("Radio1"),
      RADIOBUTTON2("Radio2"),
      RADIOBUTTON3("Radio3"),
      CHECKBOX1("Option1"),
      CHECKBOX2("Option2"),
      CHECKBOX3("Option3");


      String values;

      RahulShettyTestDataEnum(String values) {
         this.values= values;
      }

      public String getEnum(){
            return  values;
      }


}
