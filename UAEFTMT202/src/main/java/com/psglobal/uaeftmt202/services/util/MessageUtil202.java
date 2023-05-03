package com.psglobal.uaeftmt202.services.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.psglobal.uaeftmt202.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt202.domain.PaymentMethodSubFields;


@Component
public class MessageUtil202 {

    public static Optional<?> getValueForSub(PaymentMethodSubFields paymentMethodSubFields, Map<String, Object> loanIQMap) {

        if (paymentMethodSubFields.getSubFieldType() != null) {
            if (paymentMethodSubFields.getSubFieldType().equalsIgnoreCase("text")) {
                //return Optional.ofNullable(paymentMethodSubFields.getSubFieldValue());
                return Optional.ofNullable((paymentMethodSubFields.getSubFieldValue()!=null||paymentMethodSubFields.getSubFieldValue().isEmpty())?null :paymentMethodSubFields.getSubFieldValue());
            } else if (paymentMethodSubFields.getSubFieldType().equalsIgnoreCase("column")) {
                return Optional.ofNullable(loanIQMap.get(paymentMethodSubFields.getSubFieldValue()));
            }
        }
        return Optional.ofNullable(null);

    }

    public static String[] getFixedLengthStrings(String longString, int length) {
        length = length - 1;
        int numStrings = (int) Math.ceil((double) longString.length() / length);
        String[] strings = new String[6];
        int startPos = 0;
        for (int i = 0; i < numStrings; i++) {
            int endPos = startPos + length;
            if (endPos > longString.length()) {
                endPos = longString.length();
            }
            strings[i] = longString.substring(startPos, endPos);
            startPos = endPos;
        }
        return strings;
    }

    public static void main(String[] args) {
        String a = "wesd  wrrqweqwe  qwe qw e qwe qwe1111111111 qw e qw eqwe q w e qwe qwe qwe";
//       List list = convertNameAndAddressToSwiftCompliantFormat(a
//                ,0,35,1 ,35);
//       list.stream().forEach(System.out::println);

        String[] strings = getFixedLengthStrings(a, 35);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public Optional<?> getPaymentMethodFormat(List<PaymentMethodFormat> blockList, String fieldName, Map<String, Object> loanIQMap) {
        Optional<PaymentMethodFormat> paymentMethodFormat = blockList.stream().filter(a -> a.getFieldsName().equalsIgnoreCase(fieldName)).findFirst();

        if (paymentMethodFormat.isPresent()) {
            if (paymentMethodFormat.get().getFieldType().equalsIgnoreCase("text")) {
                return Optional.ofNullable( (paymentMethodFormat.get().getFieldValue()==null || paymentMethodFormat.get().getFieldValue().isEmpty())?null:paymentMethodFormat.get().getFieldValue());
            } else if (paymentMethodFormat.get().getFieldType().equalsIgnoreCase("column")) {
                if (loanIQMap.get(paymentMethodFormat.get().getFieldValue()) != null) {
                    return Optional.of(loanIQMap.get(paymentMethodFormat.get().getFieldValue()).toString().trim());
                }
            } else if (paymentMethodFormat.get().getFieldType().equalsIgnoreCase("sub")) {
                Set<PaymentMethodSubFields> paymentMethodSubFieldsSet = paymentMethodFormat.get().getPaymentMessageSubFields();
                Map<String, Object> subFieldMap = paymentMethodSubFieldsSet.stream().collect(Collectors.toMap(PaymentMethodSubFields::getSubFieldName, a -> getValueForSub(a, loanIQMap)));

                return Optional.ofNullable(subFieldMap);
            }
        }
        return Optional.ofNullable(null);
    }

    public String formatAmount(Map<String, Object> loanIQMap, BigDecimal amount) {
        String amountStr = "";
        if (loanIQMap.get("ccy_num_precision") != null) {
            Integer intCurrPrecision = (Integer) loanIQMap.get("ccy_num_precision");
            amount = amount.setScale(intCurrPrecision);
            amountStr = amount.toString();
            return amountStr.replace(".", ",");
        }
        return null;
    }

    public String formatExchangeRate(String amount) {
        if (amount != null) {
            amount=amount.replace(".", ",");
            if (amount.length() >= 12) {
                return amount.substring(0, 12);
            } else {
                return amount;
            }
        }
        return null;
    }

    public String convertLoanIQRIDToUAEFT(String loanIQRid) {
        StringBuffer uaeftValue = new StringBuffer();
        int i;
        for (i = 0; i < loanIQRid.length(); i++) {
            switch (loanIQRid.charAt(i)) {
                case '=':
                	uaeftValue.append("11");
                    break;
                case '*':
                	uaeftValue.append("22");
                    break;
                case '$':
                	uaeftValue.append("33");
                    break;
                case '#':
                	uaeftValue.append("44");
                    break;
                case '@':
                	uaeftValue.append("55");
                    break;
                case '!':
                	uaeftValue.append("66");
                    break;
                case ':':
                	uaeftValue.append("77");
                    break;
                case ';':
                	uaeftValue.append("88");
                    break;
                case '~':
                	uaeftValue.append("99");
                    break;
                case '+':
                	uaeftValue.append("98");
                    break;
                case '^':
                	uaeftValue.append("97");
                    break;
                case '-':
                	uaeftValue.append("96");
                    break;
                case '_':
                	uaeftValue.append("95");
                    break;
                case '(':
                	uaeftValue.append("94");
                    break;
                case ')':
                	uaeftValue.append("93");
                    break;
                case '}':
                	uaeftValue.append("92");
                    break;
                case ']':
                	uaeftValue.append("91");
                    break;
                case '{':
                	uaeftValue.append("89");
                    break;
                case '[':
                	uaeftValue.append("87");
                    break;
                case '?':
                	uaeftValue.append("86");
                    break;
                case '/':
                	uaeftValue.append("85");
                    break;
                case '>':
                	uaeftValue.append("84");
                    break;
                case '<':
                	uaeftValue.append("83");
                    break;
                case '.':
                	uaeftValue.append("82");
                    break;
                case ',':
                	uaeftValue.append("81");
                    break;
                case '%':
                	uaeftValue.append("79");
                    break;
                case '&':
                	uaeftValue.append("78");
                    break;
                case '"':
                	uaeftValue.append("75");
                    break;
                case '\'':
                	uaeftValue.append("76");
                    break;
                default:
                	uaeftValue.append('0');
                	uaeftValue.append(loanIQRid.charAt(i));
                    break;
            }
        }
        return uaeftValue.toString();
    }

public String generateRandomFourNumber()
{
    Random rand = new Random();
    int randomNumber = rand.nextInt(9000) + 1000;
    return String.valueOf(randomNumber);
}
    public String generateRandomSixNumber()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(900000) + 100000;
        return String.valueOf(randomNumber);
    }

    public String padXToString(String str)
    {
        int originalLength=str.length();
        if(originalLength<12)
        {
            int numXsToAdd = 12 - originalLength;
            return str + "X".repeat(numXsToAdd);
        }
        return str;
    }

}
