/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.services.core;


import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field13C;
import com.prowidesoftware.swift.model.field.Field20;
import com.prowidesoftware.swift.model.field.Field21;
import com.prowidesoftware.swift.model.field.Field23B;
import com.prowidesoftware.swift.model.field.Field23E;
import com.prowidesoftware.swift.model.field.Field26T;
import com.prowidesoftware.swift.model.field.Field32A;
import com.prowidesoftware.swift.model.field.Field33B;
import com.prowidesoftware.swift.model.field.Field36;
import com.prowidesoftware.swift.model.field.Field70;
import com.prowidesoftware.swift.model.field.Field71A;
import com.prowidesoftware.swift.model.field.Field72;
import com.prowidesoftware.swift.model.field.Field77B;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;
import com.psglobal.uaeftmt202.config.UaeftConfiguration202;
import com.psglobal.uaeftmt202.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt202.repositories.LoanIQExtAtr202;
import com.psglobal.uaeftmt202.services.util.MessageUtil202;

@Component
public class Message202Block4 {

    final String BLOCK4 = "4";

    final MessageUtil202 messageUtil;

    final UaeftConfiguration202 uaeftMT130Configuration;
    final LoanIQExtAtr202 loanIQExtAtr;

    Message202Block4(MessageUtil202 messageUtil, UaeftConfiguration202 uaeftMT130Configuration, LoanIQExtAtr202 loanIQExtAtr) {
        this.messageUtil = messageUtil;
        this.uaeftMT130Configuration = uaeftMT130Configuration;
        this.loanIQExtAtr = loanIQExtAtr;
    }

    void constructBlock4(Set<PaymentMethodFormat> paymentMethodFormatList, MT202 mt202, Map<String, Object> loanIQMap) {
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");

        List<PaymentMethodFormat> block4List = paymentMethodFormatList.stream().filter(a -> a.getBlockId().equalsIgnoreCase(BLOCK4)).collect(Collectors.toList());

        Optional<?> field13C = messageUtil.getPaymentMethodFormat(block4List, "13C", loanIQMap);
        if (field13C.isPresent() && !((String) field13C.get()).isEmpty()) {
            field13C.ifPresent(a -> mt202.addField(new Field13C((String) a)));
        }

        Optional<?> field20 = messageUtil.getPaymentMethodFormat(block4List, "20", loanIQMap);
        if (field20.isPresent() && !((String) field20.get()).isEmpty()) {
            field20.ifPresent(a -> mt202.addField(new Field20(messageUtil.convertLoanIQRIDToUAEFT((String) a))));
        }

        Optional<?> field21 = messageUtil.getPaymentMethodFormat(block4List, "21", loanIQMap);
        if (field21.isPresent() && !((String) field21.get()).isEmpty()) {
            field21.ifPresent(a -> mt202.addField(new Field21(messageUtil.convertLoanIQRIDToUAEFT((String) a))));
        }

        Optional<?> field23B = messageUtil.getPaymentMethodFormat(block4List, "23B", loanIQMap);
        if (field23B.isPresent() && !((String) field23B.get()).isEmpty()) {
            field23B.ifPresent(a -> mt202.addField(new Field23B((String) a)));
        }
        Optional<?> field23E = messageUtil.getPaymentMethodFormat(block4List, "23E", loanIQMap);
        if (field23E.isPresent() && !((String) field23E.get()).isEmpty()) {
            field23E.ifPresent(a -> mt202.addField(new Field23E((String) a)));
        }

        // this field is left blank until decision is made .
        //populateField26T(loanIQMap, mt202);

        Optional<?> field32AObject = messageUtil.getPaymentMethodFormat(block4List, "32A", loanIQMap);
        Optional<?> date32A = getFieldValueFromMap(field32AObject, "date");
        Optional<?> currency32A = getFieldValueFromMap(field32AObject, "currency");
        Optional<?> amount32A = getFieldValueFromMap(field32AObject, "amount");

        if (date32A.isPresent() || currency32A.isPresent() || amount32A.isPresent()) {
            Field32A f32A = new Field32A();
            date32A.ifPresent(a -> f32A.setDate(format.format(a)));
            currency32A.ifPresent(a -> f32A.setCurrency(a.toString()));
            amount32A.ifPresent(a -> f32A.setAmount(messageUtil.formatAmount(loanIQMap, (BigDecimal) a)));
            mt202.addField(f32A);
        }

        Optional<?> field33BObject = messageUtil.getPaymentMethodFormat(block4List, "33B", loanIQMap);
        Optional<?> currency33B = getFieldValueFromMap(field33BObject, "currency");
        Optional<?> amount33B = getFieldValueFromMap(field33BObject, "amount");
        if (currency33B.isPresent() || amount33B.isPresent()) {
            Field33B f33B = new Field33B();
            currency33B.ifPresent(a -> f33B.setCurrency(a.toString()));
            amount33B.ifPresent(a -> f33B.setAmount(messageUtil.formatAmount(loanIQMap, (BigDecimal) a)));
            mt202.addField(f33B);
        }

        Optional<?> field36 = messageUtil.getPaymentMethodFormat(block4List, "36", loanIQMap);
        if (field36.isPresent() && !((String) field36.get()).isEmpty()) {
            field36.ifPresent(a -> mt202.addField(new Field36(messageUtil.formatExchangeRate((String) field36.get()))));
        }

        Optional<?> field50AObject = messageUtil.getPaymentMethodFormat(block4List, "50A", loanIQMap);
        Optional<?> account50A = getFieldValueFromMap(field50AObject, "account");
        Optional<?> identifier50A = getFieldValueFromMap(field50AObject, "IdentifierCode");
        if (account50A.isPresent() && identifier50A.isPresent())
            setAccountAndIdentifier(field50AObject, "com.prowidesoftware.swift.model.field.Field50A", mt202);

        Optional<?> field50KObject = messageUtil.getPaymentMethodFormat(block4List, "50K", loanIQMap);
        Optional<?> nameAndAddressLine50K = getFieldValueFromMap(field50KObject, "nameAndAddressLine");
        if (nameAndAddressLine50K.isPresent() && identifier50A.isEmpty())
            setAccountNameAndAddress(field50KObject, "com.prowidesoftware.swift.model.field.Field50K", mt202);


        Optional<?> field51AObject = messageUtil.getPaymentMethodFormat(block4List, "51A", loanIQMap);
        Optional<?> account51A = getFieldValueFromMap(field51AObject, "account");
        Optional<?> identifier51A = getFieldValueFromMap(field51AObject, "IdentifierCode");
        if (account51A.isPresent() && identifier51A.isPresent())
            setAccountAndIdentifier(field51AObject, "com.prowidesoftware.swift.model.field.Field51A", mt202);

        Optional<?> field52AObject = messageUtil.getPaymentMethodFormat(block4List, "52A", loanIQMap);
        Optional<?> account52A = getFieldValueFromMap(field52AObject, "account");
        Optional<?> identifier52A = getFieldValueFromMap(field52AObject, "IdentifierCode");
        if (account52A.isPresent() && identifier52A.isPresent())
            setAccountAndIdentifier(field52AObject, "com.prowidesoftware.swift.model.field.Field52A", mt202);

        Optional<?> field52DObject = messageUtil.getPaymentMethodFormat(block4List, "52D", loanIQMap);
        Optional<?> nameAndAddressLine52D = getFieldValueFromMap(field52DObject, "nameAndAddressLine");
        if (nameAndAddressLine52D.isPresent() && identifier52A.isEmpty())
            setAccountNameAndAddress(field52DObject, "com.prowidesoftware.swift.model.field.Field52D", mt202);

        Optional<?> field53AObject = messageUtil.getPaymentMethodFormat(block4List, "53A", loanIQMap);
        Optional<?> account53A = getFieldValueFromMap(field53AObject, "account");
        Optional<?> identifier53A = getFieldValueFromMap(field53AObject, "IdentifierCode");
        if (account53A.isPresent() && identifier53A.isPresent())
            setAccountAndIdentifier(field53AObject, "com.prowidesoftware.swift.model.field.Field53A", mt202);

        Optional<?> field53DObject = messageUtil.getPaymentMethodFormat(block4List, "53D", loanIQMap);
        Optional<?> nameAndAddressLine53D = getFieldValueFromMap(field53DObject, "nameAndAddressLine");
        if (nameAndAddressLine53D.isPresent() && identifier53A.isEmpty())
            setAccountNameAndAddress(field53DObject, "com.prowidesoftware.swift.model.field.Field53D", mt202);

        Optional<?> field53BObject = messageUtil.getPaymentMethodFormat(block4List, "53B", loanIQMap);
        Optional<?> account53B = getFieldValueFromMap(field53BObject, "account");
        if (nameAndAddressLine53D.isEmpty() && identifier53A.isEmpty() && account53B.isPresent())
            setAccountOnly(field53BObject, "com.prowidesoftware.swift.model.field.Field53B", mt202);


        Optional<?> field54AObject = messageUtil.getPaymentMethodFormat(block4List, "54A", loanIQMap);
        Optional<?> account54A = getFieldValueFromMap(field54AObject, "account");
        Optional<?> identifier54A = getFieldValueFromMap(field54AObject, "IdentifierCode");
        if (account54A.isPresent() && identifier54A.isPresent())
            setAccountAndIdentifier(field54AObject, "com.prowidesoftware.swift.model.field.Field54A", mt202);

        Optional<?> field54DObject = messageUtil.getPaymentMethodFormat(block4List, "54D", loanIQMap);
        Optional<?> nameAndAddressLine54D = getFieldValueFromMap(field54DObject, "nameAndAddressLine");
        if (nameAndAddressLine54D.isPresent() && identifier54A.isEmpty())
            setAccountNameAndAddress(field54DObject, "com.prowidesoftware.swift.model.field.Field54D", mt202);

        Optional<?> field54BObject = messageUtil.getPaymentMethodFormat(block4List, "54B", loanIQMap);
        Optional<?> account54B = getFieldValueFromMap(field54BObject, "account");
        if (nameAndAddressLine54D.isEmpty() && identifier54A.isEmpty() && account54B.isPresent())
            setAccountOnly(field54BObject, "com.prowidesoftware.swift.model.field.Field54B", mt202);

        Optional<?> field56AObject = messageUtil.getPaymentMethodFormat(block4List, "56A", loanIQMap);
        Optional<?> account56A = getFieldValueFromMap(field56AObject, "account");
        Optional<?> identifier56A = getFieldValueFromMap(field56AObject, "IdentifierCode");
        if (account56A.isPresent() && identifier56A.isPresent())
            setAccountAndIdentifier(field56AObject, "com.prowidesoftware.swift.model.field.Field56A", mt202);

        Optional<?> field56DObject = messageUtil.getPaymentMethodFormat(block4List, "56D", loanIQMap);
        Optional<?> nameAndAddressLine56D = getFieldValueFromMap(field56DObject, "nameAndAddressLine");
        if (nameAndAddressLine56D.isPresent() && identifier56A.isEmpty())
            setAccountNameAndAddress(field56DObject, "com.prowidesoftware.swift.model.field.Field56D", mt202);

        Optional<?> field56CObject = messageUtil.getPaymentMethodFormat(block4List, "56C", loanIQMap);
        Optional<?> account56C = getFieldValueFromMap(field56CObject, "account");
        if (account56C.isPresent() && identifier56A.isEmpty() && nameAndAddressLine56D.isEmpty())
            setAccountOnly(field56CObject, "com.prowidesoftware.swift.model.field.Field56C", mt202);

        Optional<?> field57AObject = messageUtil.getPaymentMethodFormat(block4List, "57A", loanIQMap);
        Optional<?> account57A = getFieldValueFromMap(field57AObject, "account");
        Optional<?> identifier57A = getFieldValueFromMap(field57AObject, "IdentifierCode");
        if (identifier57A.isPresent() && account57A.isPresent()) {
            setAccountAndIdentifier(field57AObject, "com.prowidesoftware.swift.model.field.Field57A", mt202);
        }

        Optional<?> field57DObject = messageUtil.getPaymentMethodFormat(block4List, "57D", loanIQMap);
        Optional<?> nameAndAddressLine57D = getFieldValueFromMap(field57DObject, "nameAndAddressLine");
        if (identifier57A.isEmpty() && nameAndAddressLine57D.isPresent()) {
            setAccountNameAndAddress(field57DObject, "com.prowidesoftware.swift.model.field.Field57D", mt202);
        }

        Optional<?> field57CObject = messageUtil.getPaymentMethodFormat(block4List, "57C", loanIQMap);
        Optional<?> account57C = getFieldValueFromMap(field57CObject, "account");
        if (account57C.isPresent() && nameAndAddressLine57D.isEmpty() && identifier57A.isEmpty()) {
            setAccountOnly(field57CObject, "com.prowidesoftware.swift.model.field.Field57C", mt202);
        }

        Optional<?> field59AObject = messageUtil.getPaymentMethodFormat(block4List, "59A", loanIQMap);
        Optional<?> account59A = getFieldValueFromMap(field59AObject, "account");
        Optional<?> identifier59A = getFieldValueFromMap(field59AObject, "IdentifierCode");
        if (account59A.isPresent() && identifier59A.isPresent())
            setAccountAndIdentifier(field59AObject, "com.prowidesoftware.swift.model.field.Field59A", mt202);

        Optional<?> field59Object = messageUtil.getPaymentMethodFormat(block4List, "59", loanIQMap);
        Optional<?> nameAndAddressLine59 = getFieldValueFromMap(field57DObject, "nameAndAddressLine");
        if (nameAndAddressLine59.isPresent() && identifier59A.isEmpty())
            setAccountNameAndAddress(field59Object, "com.prowidesoftware.swift.model.field.Field59", mt202);


        Optional<?> field7Object = messageUtil.getPaymentMethodFormat(block4List, "70", loanIQMap);
        if (field7Object.isPresent()) {
            Optional<?> nameAndAddressArray = setNameAndAddressLine(field7Object);
            if (nameAndAddressArray.isPresent() && isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[0])) {
                Field70 field70 = new Field70();
                if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[0]))
                    field70.appendLine(((String[]) nameAndAddressArray.get())[0]);
                if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[1]))
                    field70.appendLine(((String[]) nameAndAddressArray.get())[1]);
                if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[2]))
                    field70.appendLine(((String[]) nameAndAddressArray.get())[2]);
                if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[3]))
                    field70.appendLine(((String[]) nameAndAddressArray.get())[3]);
                mt202.addField(field70);
            }
        }

        Optional<?> field71A = messageUtil.getPaymentMethodFormat(block4List, "71A", loanIQMap);
        if (field71A.isPresent() && !((String) field71A.get()).isEmpty()) {
            field71A.ifPresent(a -> mt202.addField(new Field71A((String) a)));
        }

        Optional<?> field72Object = messageUtil.getPaymentMethodFormat(block4List, "72", loanIQMap);
        if (field72Object.isPresent()) {
            Optional<?> senderToReceiverInfo = setNameAndAddressLine(field72Object);
            if (senderToReceiverInfo.isPresent() && isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[0])) {
                Field72 field72 = new Field72();
                if (isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[0]))
                    field72.appendLine(((String[]) senderToReceiverInfo.get())[0]);
                if (isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[1]))
                    field72.appendLine(((String[]) senderToReceiverInfo.get())[1]);
                if (isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[2]))
                    field72.appendLine(((String[]) senderToReceiverInfo.get())[2]);
                if (isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[3]))
                    field72.appendLine(((String[]) senderToReceiverInfo.get())[3]);
                if (isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[4]))
                    field72.appendLine(((String[]) senderToReceiverInfo.get())[4]);
                if (isNotNullNotEmpty(((String[]) senderToReceiverInfo.get())[5]))
                    field72.appendLine(((String[]) senderToReceiverInfo.get())[5]);

                mt202.addField(field72);
            }
        }
        populateField77B(loanIQMap, mt202);

    }

    private void setAccountOnly(Optional<?> fieldObject, String fieldClasPath, MT202 mt202) {
        try {
            Optional<?> account = getFieldValueFromMap(fieldObject, "account");
            Class<?> fieldClass = Class.forName(fieldClasPath);
            Object object = fieldClass.getDeclaredConstructor().newInstance();
            Method setAccount = fieldClass.getMethod("setAccount", String.class);
            if (account.isPresent()) {
                account.ifPresent(a -> {
                    try {
                        setAccount.invoke(object, a);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                mt202.addField((Field) object);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void setAccountNameAndAddress(Optional<?> fieldObject, String fieldClasPath, MT202 mt202) {
        try {
            Optional<?> account = getFieldValueFromMap(fieldObject, "account");
            Optional<?> nameAndAddressLine = getFieldValueFromMap(fieldObject, "nameAndAddressLine");
            if (nameAndAddressLine.isPresent()) {
                Class<?> fieldClass = Class.forName(fieldClasPath);
                Object object = fieldClass.getDeclaredConstructor().newInstance();

                Method setAccount = fieldClass.getMethod("setAccount", String.class);
                Method setNameAndAddressLine1 = fieldClass.getMethod("setNameAndAddressLine1", String.class);
                Method setNameAndAddressLine2 = fieldClass.getMethod("setNameAndAddressLine2", String.class);
                Method setNameAndAddressLine3 = fieldClass.getMethod("setNameAndAddressLine3", String.class);
                Method setNameAndAddressLine4 = fieldClass.getMethod("setNameAndAddressLine4", String.class);

                if (account.isPresent()) {
                    account.ifPresent(a -> {
                        try {
                            setAccount.invoke(object, a);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                }

                Optional<?> nameAndAddressArray = setNameAndAddressLine(nameAndAddressLine);

                if (nameAndAddressArray.isPresent()) {
                    if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[0]))
                        setNameAndAddressLine1.invoke(object, ((String[]) nameAndAddressArray.get())[0]);
                    if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[1]))
                        setNameAndAddressLine2.invoke(object, ((String[]) nameAndAddressArray.get())[1]);
                    if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[2]))
                        setNameAndAddressLine3.invoke(object, ((String[]) nameAndAddressArray.get())[2]);
                    if (isNotNullNotEmpty(((String[]) nameAndAddressArray.get())[3]))
                        setNameAndAddressLine4.invoke(object, ((String[]) nameAndAddressArray.get())[3]);
                }
                mt202.addField((Field) object);
            }
        } catch (Exception e) {

        }
    }

    private void setAccountAndIdentifier(Optional<?> fieldObject, String fieldClasPath, MT202 mt202) {
        try {
            Optional<?> account = getFieldValueFromMap(fieldObject, "account");
            Optional<?> identifier = getFieldValueFromMap(fieldObject, "IdentifierCode");
            if (identifier.isPresent()) {
                Class<?> fieldClass = Class.forName(fieldClasPath);
                Object object = fieldClass.getDeclaredConstructor().newInstance();
                Method setAccount = fieldClass.getMethod("setAccount", String.class);
                Method setIdentifierCode = fieldClass.getMethod("setIdentifierCode", String.class);
                identifier.ifPresent(a -> {
                    try {
                        setIdentifierCode.invoke(object, a);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                if (account.isPresent()) {
                    account.ifPresent(a -> {
                        try {
                            setAccount.invoke(object, a);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                mt202.addField((Field) object);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Optional<?> setNameAndAddressLine(Optional<?> nameAndAddressLine) {
        if (nameAndAddressLine.isPresent()) {
            return Optional.ofNullable(MessageUtil202.getFixedLengthStrings((String) nameAndAddressLine.get(), uaeftMT130Configuration.getLength()));
        }
        return Optional.empty();
    }

    private Optional<?> getFieldValueFromMap(Optional<?> fieldObject, String fieldName) {
        if (fieldObject.isPresent() && (fieldObject.get()) instanceof Map) {
            Optional<?> fieldValue = ((Optional) (((Map) (fieldObject.get())).get(fieldName)));
            if (fieldValue != null) {
                if (fieldValue.isPresent() && fieldValue.get() instanceof String && !((String) (fieldValue.get())).isEmpty()) {
                    return fieldValue;
                } else if (fieldValue.isPresent() && fieldValue.get() instanceof Date && fieldValue.get() != null) {
                    return fieldValue;
                } else if (fieldValue.isPresent() && fieldValue.get() != null) {
                    return fieldValue;
                }
            }
        } else if (fieldObject.isPresent() && (fieldObject.get()) instanceof String) {
            if (fieldObject.isPresent()) {
                return Optional.of(fieldObject.get());
            }
        }
        return Optional.empty();
    }

    private boolean isNotNullNotEmpty(String value) {
        return (null != value && !value.isBlank());
    }

    private void populateField26T(Map<String, Object> loanIQMap, MT202 mt202) {
        String strOwnerType = (String) loanIQMap.get("imt_cde_owner_type");
        String strOwnerId = (String) loanIQMap.get("imt_rid_owner");

        String str26TValue = null;
        if (strOwnerType != null && !"OTR".equals(strOwnerType.trim())) {
            List<Map<String, Object>> list1 = loanIQExtAtr.getExtAtr("FILED 26T TRANSACTION TYPE", strOwnerId, strOwnerType, false);
            str26TValue = getValueFromList(list1);
            if (str26TValue == null) {
                // get the rid of OST for this OTR
                List<Map<String, Object>> list2 = loanIQExtAtr.getOstRid(strOwnerId);
                String strOstRid = getValueFromList(list2);
                List<Map<String, Object>> list3 = loanIQExtAtr.getExtAtr("FILED 26T TRANSACTION TYPE", strOstRid, "OST", true);
                str26TValue = getValueFromList(list3);
            }
        } else if (strOwnerType != null && "OTR".equals(strOwnerType.trim())) {
            // get the rid of OST for this OTR
            List<Map<String, Object>> list4 = loanIQExtAtr.getOstRid(strOwnerId);
            String strOstRid = getValueFromList(list4);
            List<Map<String, Object>> list5 = loanIQExtAtr.getExtAtr("FILED 26T TRANSACTION TYPE", strOstRid, "OST", true);
            str26TValue = getValueFromList(list5);
        }
        // TODO:add the logic for the default value here
        if (str26TValue != null && str26TValue.length() >= 3) {
            // Only Code should be added
            str26TValue = str26TValue.substring(0, 2);
            mt202.addField(new Field26T(str26TValue));
        }
    }

    private void populateField77B(Map<String, Object> loanIQMap, MT202 mt202) {
        String strOwnerType = (String) loanIQMap.get("imt_cde_owner_type");
        String strOwnerId = (String) loanIQMap.get("imt_rid_owner");
        String str77BValue = null;
        if (strOwnerType != null && !"OTR".equals(strOwnerType.trim())) {
            List<Map<String, Object>> list1 = loanIQExtAtr.getExtAtr("FILED 77B PURPOSE TYPE", strOwnerId, strOwnerType, false);
            str77BValue = getValueFromList(list1);
            if (str77BValue == null) {
                List<Map<String, Object>> list2 = loanIQExtAtr.getOstRid(strOwnerId);
                String strOstRid = getValueFromList(list2);
                List<Map<String, Object>> list3 = loanIQExtAtr.getExtAtr("FILED 26T TRANSACTION TYPE", strOstRid, "OST", true);
                str77BValue = getValueFromList(list3);
            }
        } else if (strOwnerType != null && "OTR".equals(strOwnerType.trim())) {
            List<Map<String, Object>> list4 = loanIQExtAtr.getOstRid(strOwnerId);
            String strOstRid = getValueFromList(list4);
            List<Map<String, Object>> list5 = loanIQExtAtr.getExtAtr("FILED 26T TRANSACTION TYPE", strOstRid, "OST", true);
            str77BValue = getValueFromList(list5);

        }
        if (str77BValue != null && str77BValue.length() >= 3) {
            // Only Code should be added
            str77BValue = str77BValue.substring(0, 2);
            mt202.addField(new Field77B(str77BValue));
        }
    }

    private String getValueFromList(List<Map<String, Object>> list) {
        if (list != null && !list.isEmpty()) {
            Map<String, Object> map = list.get(0);
            if (map != null && !map.isEmpty()) return (String) map.get("key");
        }
        return null;
    }
}
