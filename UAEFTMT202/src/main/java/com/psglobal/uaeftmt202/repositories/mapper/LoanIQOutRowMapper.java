package com.psglobal.uaeftmt202.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public   class LoanIQOutRowMapper implements RowMapper<Map<String,Object>> {
    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<String,Object> LoanIQFieldMap = new HashMap<String, Object>();
        LoanIQFieldMap.put("imt_tsp_rec_create",rs.getTimestamp("imt_tsp_rec_create"));
        LoanIQFieldMap.put("imt_cde_msg_type",rs.getString("imt_cde_msg_type"));

        LoanIQFieldMap.put("ccy_num_precision",rs.getInt("ccy_num_precision"));
        LoanIQFieldMap.put("imt_rid_cashflow",rs.getString("imt_rid_cashflow"));
        LoanIQFieldMap.put("imt_cde_currency",rs.getString("imt_cde_currency"));
        LoanIQFieldMap.put("imt_amt_out_tot",rs.getBigDecimal("imt_amt_out_tot"));
        LoanIQFieldMap.put("imt_dte_value_date",rs.getDate("imt_dte_value_date"));
        LoanIQFieldMap.put("imt_rid_imt_out",rs.getString("imt_rid_imt_out"));
        LoanIQFieldMap.put("imt_cde_bnk_op",rs.getString("imt_cde_bnk_op"));
        //LoanIQFieldMap.put("imt_cde_queue_stat",rs.getString("imt_cde_queue_stat"));
        LoanIQFieldMap.put("imt_txt_paymt_dtls",rs.getString("imt_txt_paymt_dtls"));
        LoanIQFieldMap.put("imt_cde_dtls_chges",rs.getString("imt_cde_dtls_chges"));
        LoanIQFieldMap.put("imt_txt_sdr_rvr_tx",rs.getString("imt_txt_sdr_rvr_tx"));
        //LoanIQFieldMap.put("imt_dsc_narrative",rs.getString("imt_dsc_narrative"));
        LoanIQFieldMap.put("imt_txt_uetr_cde",rs.getString("imt_txt_uetr_cde"));
        LoanIQFieldMap.put("imt_cde_branch",rs.getString("imt_cde_branch"));
        LoanIQFieldMap.put("imt_cde_owner_type",rs.getString("imt_cde_owner_type"));
        LoanIQFieldMap.put("imt_rid_owner",rs.getString("imt_rid_owner"));
       // LoanIQFieldMap.put("debtorfullnme",rs.getString("debtorfullnme"));
        //LoanIQFieldMap.put("debtorcountrya",rs.getString("debtorcountrya"));
        LoanIQFieldMap.put("beneficiaryinsswiftcode",rs.getString("beneficiaryinsswiftcode"));
        LoanIQFieldMap.put("beneficiaryinsswiftname",rs.getString("beneficiaryinsswiftname"));
        LoanIQFieldMap.put("beneficiaryinsaccountnumber",rs.getString("beneficiaryinsaccountnumber"));
        LoanIQFieldMap.put("beneficiaryinsaccountname",rs.getString("beneficiaryinsaccountname"));
        LoanIQFieldMap.put("beneficiarycusswiftcode",rs.getString("beneficiarycusswiftcode"));
        LoanIQFieldMap.put("beneficiarycusswiftname",rs.getString("beneficiarycusswiftname"));

        //LoanIQFieldMap.put("beneficiarycusclearingnumber",rs.getString("beneficiarycusclearingnumber"));
        //LoanIQFieldMap.put("beneficiarycusclearingtype",rs.getString("beneficiarycusclearingtype"));
        LoanIQFieldMap.put("beneficiarycusaccountnumber",rs.getString("beneficiarycusaccountnumber"));
        LoanIQFieldMap.put("beneficiarycusaccountname",rs.getString("beneficiarycusaccountname"));
        LoanIQFieldMap.put("orderingcustomerswiftcode",rs.getString("orderingcustomerswiftcode"));
        LoanIQFieldMap.put("orderingcustomerswiftname",rs.getString("orderingcustomerswiftname"));
        //LoanIQFieldMap.put("orderingcustomerclearingnumber",rs.getString("orderingcustomerclearingnumber"));
        //LoanIQFieldMap.put("orderingcustomerclearingtype",rs.getString("orderingcustomerclearingtype"));

        LoanIQFieldMap.put("orderingcustomeraccountnumber",rs.getString("orderingcustomeraccountnumber"));
        LoanIQFieldMap.put("orderingcustomerdescription",rs.getString("orderingcustomerdescription"));
        LoanIQFieldMap.put("receiverswiftcode",rs.getString("receiverswiftcode"));
        LoanIQFieldMap.put("receiverswiftname",rs.getString("receiverswiftname"));
        //LoanIQFieldMap.put("receiverclearingnumber",rs.getString("receiverclearingnumber"));
        //LoanIQFieldMap.put("receiverclearingtype",rs.getString("receiverclearingtype"));
       // LoanIQFieldMap.put("receiveraccountnumber",rs.getString("receiveraccountnumber"));
        LoanIQFieldMap.put("receiverdescription",rs.getString("receiverdescription"));
        LoanIQFieldMap.put("senderswiftcode",rs.getString("senderswiftcode"));
        LoanIQFieldMap.put("senderswiftname",rs.getString("senderswiftname"));

        //LoanIQFieldMap.put("senderclearingnumber",rs.getString("senderclearingnumber"));
       // LoanIQFieldMap.put("senderclearingtype",rs.getString("senderclearingtype"));
        //LoanIQFieldMap.put("senderaccountnumber",rs.getString("senderaccountnumber"));
        LoanIQFieldMap.put("senderdescription",rs.getString("senderdescription"));
        LoanIQFieldMap.put("orderinginstswiftcode",rs.getString("orderinginstswiftcode"));
        LoanIQFieldMap.put("orderinginstswiftname",rs.getString("orderinginstswiftname"));
        //LoanIQFieldMap.put("orderinginstclearingnumber",rs.getString("orderinginstclearingnumber"));
        //LoanIQFieldMap.put("orderinginstclearingtype",rs.getString("orderinginstclearingtype"));
        LoanIQFieldMap.put("orderinginstaccountnumber",rs.getString("orderinginstaccountnumber"));



        LoanIQFieldMap.put("orderinginstadescription",rs.getString("orderinginstadescription"));
        LoanIQFieldMap.put("sendercorrswiftcode",rs.getString("sendercorrswiftcode"));
        LoanIQFieldMap.put("sendercorrswiftname",rs.getString("sendercorrswiftname"));
        //LoanIQFieldMap.put("sendercorrclearingnumber",rs.getString("sendercorrclearingnumber"));
        //LoanIQFieldMap.put("sendercorrclearingtype",rs.getString("sendercorrclearingtype"));
        LoanIQFieldMap.put("sendercorraccountnumber",rs.getString("sendercorraccountnumber"));
        LoanIQFieldMap.put("sendercorradesc",rs.getString("sendercorradesc"));
        LoanIQFieldMap.put("receivercorrswiftcode",rs.getString("receivercorrswiftcode"));
        LoanIQFieldMap.put("receivercorrswiftname",rs.getString("receivercorrswiftname"));

        //LoanIQFieldMap.put("receivercorrclearingnumber",rs.getString("receivercorrclearingnumber"));
        LoanIQFieldMap.put("receivercorrclearingtype",rs.getString("receivercorrclearingtype"));
       // LoanIQFieldMap.put("receivercorraccountnumber",rs.getString("receivercorraccountnumber"));
        LoanIQFieldMap.put("receivercorradesc",rs.getString("receivercorradesc"));


        LoanIQFieldMap.put("internmedinsswiftcode",rs.getString("internmedinsswiftcode"));
        LoanIQFieldMap.put("internmedinsswiftname",rs.getString("internmedinsswiftname"));
        LoanIQFieldMap.put("internmedinsaccountnumber",rs.getString("internmedinsaccountnumber"));
        LoanIQFieldMap.put("internmedinsaccountname",rs.getString("internmedinsaccountname"));

        LoanIQFieldMap.put("acctwithinsswiftcode",rs.getString("acctwithinsswiftcode"));
        LoanIQFieldMap.put("acctwithinsswiftname",rs.getString("acctwithinsswiftname"));
        LoanIQFieldMap.put("acctwithinsaccountnumber",rs.getString("acctwithinsaccountnumber"));
        LoanIQFieldMap.put("internmedinsaccountname",rs.getString("internmedinsaccountname"));

        LoanIQFieldMap.put("acctwithinsaccountname",rs.getString("acctwithinsaccountname"));

        LoanIQFieldMap.put("cfl_rte_fx_rate",rs.getString("cfl_rte_fx_rate"));

        return LoanIQFieldMap;
    }
}