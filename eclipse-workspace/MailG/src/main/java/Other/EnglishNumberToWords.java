package Other;
import java.text.DecimalFormat;

public class EnglishNumberToWords {

  private static final String[] tensNames = {
    "",
    " Mười",
    " Hai Mươi",
    " Ba Mươi",
    " Bốn Mươi",
    " Năm Mươi",
    " Sáu Mươi",
    " Bảy Mươi",
    " Tám Mươi",
    " Chín Mươi"
  };

  private static final String[] numNames = {
    "",
    " Một",
    " Hai",
    " Ba",
    " Bốn",
    " Năm",
    " Sáu",
    " Bảy",
    " Tám",
    " Chín",
    " Mười",
    " Mười Một",
    " Mười Hai",
    " Mười Ba",
    " Mười Bốn",
    " Mười Lăm",
    " Mười Sáu",
    " Mười Bảy",
    " Mười Tám",
    " Mười Chín"
  };

  private EnglishNumberToWords() {}

  private static String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20){
      soFar = numNames[number % 100];
      number /= 100;
    }
    else {
      soFar = numNames[number % 10];
      number /= 10;

      soFar = tensNames[number % 10] + soFar;
      number /= 10;
    } 
    if (number == 0) return   soFar;
    return numNames[number] + " Trăm" + soFar;
  }


  public static String convert(long number) {
    // 0 to 999 999 999 999
    if (number == 0) { return "Không"; }

    String snumber = Long.toString(number);

    // pad with "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int billions = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int millions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int thousands = Integer.parseInt(snumber.substring(9,12));

    String tradBillions;
    switch (billions) {
    case 0:
      tradBillions = "";
      break;
    case 1 :
      tradBillions = convertLessThanOneThousand(billions)
      + " Tỷ ";
      break;
    default :
      tradBillions = convertLessThanOneThousand(billions)
      + " Tỷ ";
    }
    String result =  tradBillions;

    String tradMillions;
    switch (millions) {
    case 0:
      tradMillions = "";
      break;
    case 1 :
      tradMillions = convertLessThanOneThousand(millions)
         + " Triệu ";
      break;
    default :
      tradMillions = convertLessThanOneThousand(millions)
         + " Triệu ";
    }
    result =  result + tradMillions;

    String tradHundredThousands;
    switch (hundredThousands) {
    case 0:
      tradHundredThousands = "";
      break;
    case 1 :
      tradHundredThousands = "Một Nghìn ";
      break;
    default :
      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
         + " Nghìn ";
    }
    result =  result + tradHundredThousands;

    String tradThousand;
    tradThousand = convertLessThanOneThousand(thousands);
    result =  result + tradThousand;

    // remove extra spaces!
    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
  }

  /**
   * testing
   * @param args
   */
  public static void main(String[] args) {
	  long number=230056000;
    System.out.println("*** " + EnglishNumberToWords.convert(number));
   

 
  }
}