package com.example.jakathishab;

public class SpinnerItem {
  private String mtextValue;
  private String meditTestValue;

  public SpinnerItem(String textValue,String editTextValue)
  {
      mtextValue=textValue;
      meditTestValue=editTextValue;
  }

      public String getTextValue()
      {
          return mtextValue;
      }
      public String getEditTextValue()
        {
            return meditTestValue;
        }
}
