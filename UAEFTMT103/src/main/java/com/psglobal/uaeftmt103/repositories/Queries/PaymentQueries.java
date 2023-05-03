package com.psglobal.uaeftmt103.repositories.Queries;

public class PaymentQueries {

final public String LoanIQOutQuery="\n" +
        "\n" +
        "\n" +
        "SELECT a.imt_tsp_rec_create,\n" +
        "       a.imt_cde_msg_type,\n" +
        "       f.ccy_num_precision,\n" +
        "       a.imt_rid_cashflow,\n" +
        "       a.imt_cde_currency,\n" +
        "       a.imt_amt_out_tot,\n" +
        "       a.imt_dte_value_date,\n" +
        "       a.imt_rid_imt_out,\n" +
        "       a.imt_cde_bnk_op,\n" +
        "       imt_cde_queue_stat,\n" +
        "       a.imt_txt_paymt_dtls,\n" +
        "       a.imt_cde_dtls_chges,\n" +
        "       a.imt_txt_sdr_rvr_tx,\n" +
        "       a.imt_dsc_narrative,\n" +
        "       a.imt_txt_uetr_cde,\n" +
        "       a.imt_cde_branch,\n" +
        "       a.imt_cde_owner_type,\n" +
        "       a.imt_rid_owner,\n" +
        "       (SELECT c.cus_nme_full_name\n" +
        "        FROM   vls_customer c,\n" +
        "               vls_branch d\n" +
        "        WHERE  a.imt_cde_branch = d.brn_cde_branch\n" +
        "               AND d.brn_cid_cust_id = c.cus_cid_cust_id) AS debtorfullnme,\n" +
        "       (SELECT c.cus_cde_country\n" +
        "        FROM   vls_customer c,\n" +
        "               vls_branch d\n" +
        "        WHERE  a.imt_cde_branch = d.brn_cde_branch\n" +
        "               AND d.brn_cid_cust_id = c.cus_cid_cust_id) AS debtorcountrya,\n" +
        "       (SELECT b.ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role b\n" +
        "        WHERE  a.imt_rid_imt_out = b.ior_rid_outgng_imt\n" +
        "               AND b.ior_cde_swft_rtyp = 'BENIN')         AS\n" +
        "       beneficiaryinsswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENIN')           AS\n" +
        "       beneficiaryinsswiftname,\n" +
        "       (SELECT c.ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role c\n" +
        "        WHERE  a.imt_rid_imt_out = c.ior_rid_outgng_imt\n" +
        "               AND c.ior_cde_swft_rtyp = 'BENIN')         AS\n" +
        "       beneficiaryinsaccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENIN')           AS\n" +
        "       beneficiaryinsaccountname,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENCR')           AS\n" +
        "       beneficiarycusswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENIN')           AS\n" +
        "       beneficiarycusswiftname,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENCR')           AS\n" +
        "       beneficiarycusclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENCR')           AS\n" +
        "       beneficiarycusclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENCR')           AS\n" +
        "       beneficiarycusaccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'BENCR')           AS\n" +
        "       beneficiarycusaccountname,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORCSR')           AS\n" +
        "       orderingcustomerswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORCSR')           AS\n" +
        "       orderingcustomerswiftname,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORCSR')           AS\n" +
        "       orderingcustomerclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORCSR')           AS\n" +
        "       orderingcustomerclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORCSR')           AS\n" +
        "       orderingcustomeraccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORCSR')           AS\n" +
        "       orderingcustomerdescription,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RECVR')           AS receiverswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RECVR')           AS receiverswiftname,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RECVR')           AS\n" +
        "       receiverclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RECVR')           AS\n" +
        "       receiverclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RECVR')           AS\n" +
        "       receiveraccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RECVR')           AS receiverdescription\n" +
        "       ,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SENDR')           AS senderswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SENDR')           AS senderswiftname,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SENDR')           AS\n" +
        "       senderclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SENDR')           AS senderclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SENDR')           AS senderaccountnumber\n" +
        "       ,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SENDR')           AS senderdescription,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORINS')           AS\n" +
        "       orderinginstswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORINS')           AS\n" +
        "       orderinginstswiftname,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORINS')           AS\n" +
        "       orderinginstclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORINS')           AS\n" +
        "       orderinginstclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORINS')           AS\n" +
        "       orderinginstaccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ORINS')           AS\n" +
        "       orderinginstadescription,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SRCOR')           AS sendercorrswiftcode\n" +
        "       ,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SRCOR')           AS sendercorrswiftname\n" +
        "       ,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SRCOR')           AS\n" +
        "       sendercorrclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SRCOR')           AS\n" +
        "       sendercorrclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SRCOR')           AS\n" +
        "       sendercorraccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'SRCOR')           AS sendercorradesc,\n" +
        "       (SELECT ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RCCOR')           AS\n" +
        "       receivercorrswiftcode,\n" +
        "       (SELECT ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RCCOR')           AS\n" +
        "       receivercorrswiftname,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RCCOR')           AS\n" +
        "       receivercorrclearingnumber,\n" +
        "       (SELECT ior_txt_clg_code\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RCCOR')           AS\n" +
        "       receivercorrclearingtype,\n" +
        "       (SELECT ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RCCOR')           AS\n" +
        "       receivercorraccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'RCCOR')           AS receivercorradesc,\n" +
        "       (SELECT b.ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role b\n" +
        "        WHERE  a.imt_rid_imt_out = b.ior_rid_outgng_imt\n" +
        "               AND b.ior_cde_swft_rtyp = 'INTMY')         AS\n" +
        "       internmedinsswiftcode,\n" +
        "       (SELECT b.ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role b\n" +
        "        WHERE  a.imt_rid_imt_out = b.ior_rid_outgng_imt\n" +
        "               AND b.ior_cde_swft_rtyp = 'INTMY')         AS\n" +
        "       internmedinsswiftname,\n" +
        "       (SELECT c.ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role c\n" +
        "        WHERE  a.imt_rid_imt_out = c.ior_rid_outgng_imt\n" +
        "               AND c.ior_cde_swft_rtyp = 'INTMY')         AS\n" +
        "       internmedinsaccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'INTMY')           AS\n" +
        "       internmedinsaccountname,\n" +
        "       (SELECT b.ior_cde_swft_id\n" +
        "        FROM   vls_imt_out_role b\n" +
        "        WHERE  a.imt_rid_imt_out = b.ior_rid_outgng_imt\n" +
        "               AND b.ior_cde_swft_rtyp = 'ACWIN')         AS\n" +
        "       acctwithinsswiftcode,\n" +
        "       (SELECT b.ior_nme_swft_id\n" +
        "        FROM   vls_imt_out_role b\n" +
        "        WHERE  a.imt_rid_imt_out = b.ior_rid_outgng_imt\n" +
        "               AND b.ior_cde_swft_rtyp = 'ACWIN')         AS\n" +
        "       acctwithinsswiftname,\n" +
        "       (SELECT c.ior_txt_acct_no\n" +
        "        FROM   vls_imt_out_role c\n" +
        "        WHERE  a.imt_rid_imt_out = c.ior_rid_outgng_imt\n" +
        "               AND c.ior_cde_swft_rtyp = 'ACWIN')         AS\n" +
        "       acctwithinsaccountnumber,\n" +
        "       (SELECT ior_txt_desc\n" +
        "        FROM   vls_imt_out_role\n" +
        "        WHERE  a.imt_rid_imt_out = ior_rid_outgng_imt\n" +
        "               AND ior_cde_swft_rtyp = 'ACWIN')           AS\n" +
        "       acctwithinsaccountname,\n" +
        "\t   c.cfl_rte_fx_rate\n" +
        "FROM   vls_imt_out a,\n" +
        "       vls_currency f,\n" +
        "\t   VLS_CASHFLOW c\n" +
        "WHERE  f.ccy_cde_currency = a.imt_cde_currency and \n" +
        "        a.imt_rid_cashflow=c.cfl_rid_cashflow\n" +
        "       AND imt_cde_queue_stat = ? \n " +
        " AND imt_cde_msg_type=? ";


    final static public String queryForOst="select OEA_TXT_VALUE " +
            "from VLS_OBJ_EXT_ATR a where    a.OEA_TXT_NAME= ? " +
            "and a.OEA_CDE_OWNER_TYPE = ? and a.OEA_RID_OWNER = ? ";

   final static public String queryExtAtr="select OEA_TXT_VALUE from VLS_OBJ_EXT_ATR a, VLS_IMT_OUT b  " +
            "where  a.OEA_CDE_OWNER_TYPE = b.IMT_CDE_OWNER_TYPE " +
            "and a.OEA_RID_OWNER = b.IMT_RID_OWNER and a.OEA_TXT_NAME= ? " +
            "and b.IMT_CDE_OWNER_TYPE = ? and b.IMT_RID_OWNER = ? ";

    final static public String queryOstRid = "select OTR_RID_OUTSTANDNG from VLS_OST_TRAN  " +
            "where OTR_RID_OST_TRAN = ?";

    final static  public String updateQuery="update vls_imt_out set imt_cde_queue_stat=? where imt_rid_imt_out=? ";

}
